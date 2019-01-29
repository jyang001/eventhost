package com.yang.eventhost.mapper;

import com.yang.eventhost.entity.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {

    public static final String BASE_SQL = "Select a.id, a.username, a.password, a.first_name, a.last_name, a.email From Account a";

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

        int userId = rs.getInt("id");

        String userName = rs.getString("username");

        String email = rs.getString("email");

        String firstName = rs.getString("first_name");

        String lastName = rs.getString("last_name");

        String encrytedPassword = rs.getString("password");

        return new Account(firstName, lastName, userName, encrytedPassword, email);
    }

}
