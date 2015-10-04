package se.liu.ida.tdp024.account.data.api.entity;

import java.io.Serializable;

public interface Account extends Serializable {
    long getID();
    
    String getType();
    void setType(String accountType);
    
    String getPersonKey();
    void setPersonKey(String personKey);

    String getBankKey();
    void setBankKey(String bankKey);
    
    long getAmount();
}
