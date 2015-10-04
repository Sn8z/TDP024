package se.liu.ida.tdp024.account.data.test.facade;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import se.liu.ida.tdp024.account.data.api.facade.AccountEntityFacade;
import se.liu.ida.tdp024.account.data.api.util.StorageFacade;
import se.liu.ida.tdp024.account.data.impl.db.facade.AccountEntityFacadeDB;
import se.liu.ida.tdp024.account.data.impl.db.util.StorageFacadeDB;

public class AccountEntityFacadeTest {
    
    //---- Unit under test ----//
    private AccountEntityFacade accountEntityFacade = new AccountEntityFacadeDB();
    private StorageFacade storageFacade = new StorageFacadeDB();
    
    @After
    public void tearDown() {
        storageFacade.emptyStorage();
    }
    
    @Test
    public void testCreateAllCombos() {
        List<String> persons = new ArrayList<String>();
        List<String> banks = new ArrayList<String>();
        List<String> accountTypes = new ArrayList<String>();
        
        persons.add("Jakob Pogulis");
        persons.add("Xena");
        persons.add("Marcus Bendtsen");
        persons.add("Zorro");
        persons.add("Q");
    
        banks.add("SWEDBANK");
        banks.add("IKANOBANKEN");
        banks.add("JPMORGAN");
        banks.add("NORDEA");
        banks.add("CITIBANK");
        banks.add("HANDELSBANKEN");
        banks.add("SBAB");
        banks.add("HSBC");
        banks.add("NORDNET");

        accountTypes.add("CHECK");
        accountTypes.add("SAVINGS");
        
        for(String person : persons){
            for(String bank : banks){
                for(String accountType : accountTypes){
                    long id = accountEntityFacade.create(accountType, person, bank);
                    Assert.assertTrue(id > 0);
                }
            }
        }
    }
    
    @Test
    public void testFailureType(){
        String person = "Marcus Bendtsen";
        String accountType = "FAILURE";
        String bank = "SWEDBANK";
    
        long id = accountEntityFacade.create(accountType, person, bank);
        Assert.assertTrue(id < 0);
    }
}