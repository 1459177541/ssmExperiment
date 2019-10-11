package chapter4.main;

import chapter4.dao.AccountDao;
import chapter4.dao.impl.JDBCAccountDaoImpl;
import chapter4.model.Account;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JdbcTest {

    private static AccountDao accountDao;

    @BeforeAll
    static void start(){
        accountDao = new JDBCAccountDaoImpl();
    }

    @Test
    void addAccount(){
        accountDao.addAccount(new Account()
                .setId((long) 1)
                .setName("user1")
                .setBalance(520.0)
        );
    }

    @Test
    void updateAccount(){
        accountDao.updateAccount(new Account()
                .setId((long) 1)
                .setName("user1")
                .setBalance(500.0)
        );
    }

    @Test
    void deleteAccount(){
        accountDao.deleteAccount(new Account()
                .setId((long) 1)
        );
    }

    @Test
    void findOne(){
        System.out.println(accountDao.findOne(1));
    }

    @Test
    void findAll(){
        System.out.println(accountDao.findAll());
    }
}
