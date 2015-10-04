package se.liu.ida.tdp024.account.data.impl.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import se.liu.ida.tdp024.account.data.api.entity.Account;

@Entity
public class AccountDB implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long amount;
    
    private String personKey;
    private String bankKey;
    private String accountType;
    
    @Override
    public long getID() {
        return id;
    }

    @Override
    public String getType() {
        return accountType;
    }

    @Override
    public void setType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String getPersonKey() {
        return personKey;
    }

    @Override
    public void setPersonKey(String personKey) {
        this.personKey = personKey;
    }

    @Override
    public String getBankKey() {
        return bankKey;
    }

    @Override
    public void setBankKey(String bankKey) {
        this.bankKey = bankKey;
    }

    @Override
    public long getAmount() {
        return amount;
    }
}
