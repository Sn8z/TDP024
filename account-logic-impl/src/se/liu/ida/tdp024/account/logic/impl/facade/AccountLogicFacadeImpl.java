package se.liu.ida.tdp024.account.logic.impl.facade;

import se.liu.ida.tdp024.account.data.api.facade.AccountEntityFacade;
import se.liu.ida.tdp024.account.logic.api.facade.AccountLogicFacade;
import se.liu.ida.tdp024.account.util.http.HTTPHelperImpl;
import se.liu.ida.tdp024.account.logic.impl.facade.Bank;
import se.liu.ida.tdp024.account.logic.impl.facade.Person;
import se.liu.ida.tdp024.account.util.json.AccountJsonSerializerImpl;

public class AccountLogicFacadeImpl implements AccountLogicFacade {
    
    private final AccountEntityFacade accountEntityFacade;
    
    public AccountLogicFacadeImpl(AccountEntityFacade accountEntityFacade) {
        this.accountEntityFacade = accountEntityFacade;
    }

    @Override
    public long createAccount(String accountType, String person, String bank) {
        HTTPHelperImpl httpHelp = new HTTPHelperImpl();
        String personJSON = httpHelp.get("http://enterprise-systems.appspot.com/person/find.name", "name", person);
        String bankJSON = httpHelp.get("http://enterprise-systems.appspot.com/bank/find.name", "name", bank);
        
        //Check for input errors and return -1 if that's the case
        if(personJSON.equals("null")){
            return -1;
        }
        
        if(bankJSON.equals("null")){
            return -1;
        }
        
        try{
            if(!accountType.equals("CHECK") && !accountType.equals("SAVINGS")){
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
                
        AccountJsonSerializerImpl accJson = new AccountJsonSerializerImpl();
        Person personObject = accJson.fromJson(personJSON, Person.class);
        Bank bankObject = accJson.fromJson(bankJSON, Bank.class);
        
        return accountEntityFacade.create(accountType, personObject.getKey(), bankObject.getKey());
    }
    
}
