package edu.upc.dsa.services;

import edu.upc.dsa.Manager;
import edu.upc.dsa.dao.DAO;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Message;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;


import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

@Api("/messages")
@Path("/posts")
public class MessageService {

    Manager manager = DAO.getInstance();
    final static Logger logger = Logger.getLogger(MessageService.class);

    public MessageService() {
    }

    @GET
    @ApiOperation("Get all messages in the general forum")
    @Path("/getMessagesById/{idOrigin}/{idTarget}")
    @ApiResponses(value={
            @ApiResponse(code=200, message = "Success", response = Message.class, responseContainer = "List"),
            @ApiResponse(code=500,message="Internal server error")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessagesbyID(@PathParam("idOrigin") String originID, @PathParam("idTarget") String targetID){

        try{
            GenericEntity<List<Message>> entity = new GenericEntity<>(manager.getMessagesbyId(originID,targetID)){};
            return Response
                    .status(Response.Status.OK)
                    .entity(entity)
                    .build();
        }catch(SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @ApiOperation("Get all messages")
    @Path("/getMessages")
    @ApiResponses(value={
            @ApiResponse(code=200, message="Success",response = Message.class, responseContainer="List"),
            @ApiResponse(code=500,message="Internal server error")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages(){
        try{
            GenericEntity<List<Message>> entity = new GenericEntity<>(manager.getAllMessages()){};
            return Response
                    .status(Response.Status.OK)
                    .entity(entity)
                    .build();
        }catch(SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
