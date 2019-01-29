package com.yang.eventhost.repository;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AccountDAO extends JdbcDaoSupport {

    @Autowired
    public AccountDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public Account findUserAccount(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = AccountMapper.BASE_SQL + " where a.username = ? ";

        Object[] params = new Object[] { userName };
        AccountMapper mapper = new AccountMapper();
        try {
            Account accountIfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return accountIfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
