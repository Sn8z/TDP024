package se.liu.ida.tdp024.account.data.impl.db.facade;

import se.liu.ida.tdp024.account.data.api.facade.AccountEntityFacade;

public class AccountEntityFacadeDB implements AccountEntityFacade {

    @Override
    public long create(String accountType, String personKey, String bankKey) {
        
        return 1337;
    }
    
}
