package chapter04.dao.impl;

import chapter04.dao.AccountDao;
import chapter04.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpringAccountDaoImpl implements AccountDao {

    private final JdbcTemplate template;

    @Autowired
    public SpringAccountDaoImpl(JdbcTemplate jdbcTemplate){
        this.template = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account) {
        return template.update(
                "INSERT INTO account(id, name, balance) VALUES (?,?,?)",
                account.getId(), account.getName(), account.getBalance());
    }

    @Override
    public int updateAccount(Account account) {
        return template.update("UPDATE account SET name=?, balance=? WHERE id=?",
                account.getName(), account.getBalance(), account.getId());
    }

    @Override
    public int deleteAccount(Account account) {
        return template.update("DELETE FROM account WHERE id=?", account.getId());
    }

    @Override
    public Account findOne(long id) {
        return template.queryForObject("SELECT * FROM account WHERE id=?", new BeanPropertyRowMapper<>(Account.class), id);
    }

    @Override
    public List<Account> findAll() {
        return template.query("SELECT * FROM account", new BeanPropertyRowMapper<>(Account.class));
    }
}
