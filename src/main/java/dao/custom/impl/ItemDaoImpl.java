package dao.custom.impl;

import db.DBConnection;
import dto.ItemDto;
import dao.custom.ItemDao;
import entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public ItemDto searchItem() {
        return null;
    }

    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, entity.getCode());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setDouble(3, entity.getUnitPrice());
        preparedStatement.setInt(4, entity.getQtyOnHand());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item SET description=?, unitprice=?, qtyOnHand=? WHERE id=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, entity.getDescription());
        pstm.setDouble(2,entity.getUnitPrice());
        pstm.setInt(3, entity.getQtyOnHand());
        pstm.setString(4, entity.getCode());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item WHERE code=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, value);
        int result = preparedStatement.executeUpdate();
        return result>0;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<Item> itemList = new ArrayList<>();

        while (resultSet.next()){
            itemList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        return itemList;
    }
}
