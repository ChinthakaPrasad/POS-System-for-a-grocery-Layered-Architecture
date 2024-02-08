package dao.custom;

import dao.CrudDao;
import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao extends CrudDao<Item> {
//    boolean updateItm(ItemDto dto) throws SQLException, ClassNotFoundException;
//    boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException;
//    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
         ItemDto searchItem();
//    List<ItemDto> allItems() throws SQLException, ClassNotFoundException;
}
