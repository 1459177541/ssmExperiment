package chapter4.dao.impl;


import chapter4.dao.AccountDao;
import chapter4.model.Account;
import chapter4.tool.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCAccountDaoImpl implements AccountDao {

    @Override
    public int addAccount(Account account) {
        try(
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO account VALUES (?, ?, ?)");
        ){
            statement.setLong(1, account.getId());
            statement.setString(2, account.getName());
            statement.setDouble(3, account.getBalance());
            statement.execute();
            return statement.getFetchSize();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateAccount(Account account) {
        try(
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("UPDATE account SET name=?, balance=? WHERE id=?");
        ){
            statement.setString(1, account.getName());
            statement.setDouble(2, account.getBalance());
            statement.setLong(3, account.getId());
            statement.execute();
            return statement.getFetchSize();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteAccount(Account account) {
        try(
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM account WHERE id=?");
        ){
            statement.setLong(1, account.getId());
            statement.execute();
            return statement.getFetchSize();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Account findOne(long id) {
        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM account WHERE id=?")
        ) {
            statement.setLong(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.first()) {
                return new Account()
                        .setId(resultSet.getLong("id"))
                        .setName(resultSet.getString("name"))
                        .setBalance(resultSet.getDouble("balance"));
            } else {
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Account> findAll() {
        try(
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM account")
        ){
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            List<Account> list = new ArrayList<>();
            while (resultSet.next()){
                list.add(new Account()
                        .setId(resultSet.getLong("id"))
                        .setName(resultSet.getString("name"))
                        .setBalance(resultSet.getDouble("balance")));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
