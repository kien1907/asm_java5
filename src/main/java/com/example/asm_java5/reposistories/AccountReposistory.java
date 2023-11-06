package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountReposistory{
    private final String HAS_KEY = "Account";
    @Autowired
    RedisTemplate redisTemplate;
    public void save(Account account){
         redisTemplate.opsForHash().put(HAS_KEY,account.getMa(),account);
    }
    public List<Account> getAll(){
        return redisTemplate.opsForHash().values(HAS_KEY);
    }
    public boolean isKeyAlready(){
        return redisTemplate.hasKey(HAS_KEY);
    }
    public void delete(String ma){
        redisTemplate.opsForHash().delete(HAS_KEY,ma);
    }
}
