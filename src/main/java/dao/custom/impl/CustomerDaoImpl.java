package dao.custom.impl;

import dao.util.CrudUtil;
import db.DBConnection;
import dto.CustomerDto;
import dao.custom.CustomerDao;
import entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customer Values(?,?,?,?)";
        boolean isAdded= CrudUtil.execute(sql, entity.getId(), entity.getName(), entity.getAddress(), entity.getSalary());
        return isAdded;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE customer SET name=?, address=?, salary=? WHERE id=?";
        boolean isUpdated = CrudUtil.execute(sql, entity.getName(), entity.getAddress(), entity.getSalary(), entity.getId());
        return isUpdated;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Customer WHERE id=?";
        return CrudUtil.execute(sql, value);
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        ResultSet resultSet= CrudUtil.execute(sql);

        while(resultSet.next()){

            Customer entity = new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)

            );
            customerList.add(entity);
        }

        return customerList;
    }
}
