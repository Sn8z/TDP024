package se.liu.ida.tdp024.account.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import se.liu.ida.tdp024.account.data.impl.db.facade.AccountEntityFacadeDB;
import se.liu.ida.tdp024.account.logic.api.facade.AccountLogicFacade;
import se.liu.ida.tdp024.account.logic.impl.facade.AccountLogicFacadeImpl;

@Path("/account")
public class AccountService {
    
    private final AccountLogicFacade AccountLogicFacade =
        new AccountLogicFacadeImpl(new AccountEntityFacadeDB());
    
    @GET
    @Path("/create")
    public Response createAccount(@QueryParam("accounttype") String accountType, @QueryParam("name") String name, @QueryParam("bank") String bank){
        long id = AccountLogicFacade.createAccount(accountType, name, bank);
        if(id > 0){
            return Response.ok().entity("OK").build();
        } else {
            return Response.ok().entity("FAILED").build();
        }
    }
    
    @GET
    @Path("/find/name")
    public Response findAccount(){
        return Response.ok().entity("OK").build();
    }
    
    @GET
    @Path("/debit")
    public Response debitAccount(){
        return Response.ok().entity("OK").build();
    }
    
    @GET
    @Path("/credit")
    public Response creditAccount(){
        return Response.ok().entity("OK").build();
    }
    
    @GET
    @Path("/transactions")
    public Response findTransactions(){
        return Response.ok().entity("OK").build();
    }
    
}
