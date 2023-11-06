package com.example.asm_java5.services;

import com.example.asm_java5.entiy.Account;

import java.util.List;

public interface AccountService {
    void saveAcc(Account account);
    List<Account> getAll();
    boolean isKeyAlready();
    void delete(String ma);
}
