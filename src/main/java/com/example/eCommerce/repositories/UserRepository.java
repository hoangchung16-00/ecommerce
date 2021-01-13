package com.example.eCommerce.repositories;

import com.example.eCommerce.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsername(final String username){
       SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM users WHERE username= ?",username);
       if(sqlRowSet.next()){
           return new User(sqlRowSet.getLong("id"),username,sqlRowSet.getString("password"),sqlRowSet.getBoolean("is_admin"));
       }
       return null;
    }

}
