package se.liu.ida.tdp024.account.data.impl.db.facade;

import javax.persistence.EntityManager;
import se.liu.ida.tdp024.account.data.api.entity.Account;
import se.liu.ida.tdp024.account.data.api.facade.AccountEntityFacade;
import se.liu.ida.tdp024.account.data.impl.db.entity.AccountDB;
import se.liu.ida.tdp024.account.data.impl.db.util.EMF;

public class AccountEntityFacadeDB implements AccountEntityFacade {

    @Override
    public long create(String accountType, String personKey, String bankKey) {
        EntityManager eManager = EMF.getEntityManager();
        
        if(!accountType.equals("SAVINGS") && !accountType.equals("CHECK")){
            return -1;
        }
        
        try{
            eManager.getTransaction().begin();
            Account account = new AccountDB();
        
            account.setType(accountType);
            account.setPersonKey(personKey);
            account.setBankKey(bankKey);
        
            eManager.persist(account);
            eManager.getTransaction().commit();
            eManager.close();
            
            return account.getID();
        } catch (Exception e){
            return -1;
        }
    }
    
}
