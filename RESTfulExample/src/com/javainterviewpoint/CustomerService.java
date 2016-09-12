package com.javainterviewpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/createjson")
public class CustomerService
{
    @GET
    @Path("/get")
    @Produces("application/json")
    public Customer getCustomerInJSON(@QueryParam("username") String name, @QueryParam("id") int id)
    {
        Customer cust = new Customer();
        cust.setName(name);
        cust.setId(id);
        return cust;
    }
    
    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createCustomerJSON(Customer customer)
    {
    	System.out.println("createCustomerJSON...");
    	String result = "Saved Customer : " + customer;
        System.out.println(customer.getName());
        return Response.status(200).entity(customer).build();
        
    }
}