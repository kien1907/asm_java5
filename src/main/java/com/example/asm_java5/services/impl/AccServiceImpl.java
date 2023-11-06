package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.Account;
import com.example.asm_java5.reposistories.AccountReposistory;
import com.example.asm_java5.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccServiceImpl implements AccountService {
    @Autowired
    AccountReposistory accountReposistory;
    @Override
    public void saveAcc(Account account) {
        this.accountReposistory.save(account);
    }

    @Override
    public List<Account> getAll() {
        return this.accountReposistory.getAll();
    }

    @Override
    public boolean isKeyAlready() {
        return accountReposistory.isKeyAlready();
    }

    @Override
    public void delete(String ma) {
        accountReposistory.delete(ma);
    }
}
