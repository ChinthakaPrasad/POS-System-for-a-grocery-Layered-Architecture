package bo.custom.impl;

import bo.custom.ItemBo;
import dao.DaoFactory;
import dao.custom.ItemDao;
import dao.custom.impl.ItemDaoImpl;
import dao.util.DaoType;
import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo {
    private ItemDao itemDao = DaoFactory.getInstance().getDao(DaoType.ITEM);
    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        boolean bool = itemDao.save(new Item(
                dto.getId(),
                dto.getDesc(),
                dto.getUnitPrice(),
                dto.getQty()
        ));
        return bool;
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                dto.getId(),
                dto.getDesc(),
                dto.getUnitPrice(),
                dto.getQty()
        ));
    }

    @Override
    public boolean deleteItem(String value) throws SQLException, ClassNotFoundException {
        return itemDao.delete(value);
    }

    @Override
    public List<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        List<ItemDto> itemDtoList = new ArrayList<>();
        List<Item> itemList = itemDao.getAll();

        for(Item item: itemList){
            itemDtoList.add(new ItemDto(
                    item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand()
            ));
        }
        return itemDtoList;
    }
}
