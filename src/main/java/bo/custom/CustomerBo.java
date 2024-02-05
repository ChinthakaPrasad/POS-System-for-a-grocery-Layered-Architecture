package bo.custom;

import bo.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo<T> extends SuperBo {
    boolean saveCustomer(T dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(T dto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String value) throws SQLException, ClassNotFoundException;
    List<T> allCustomer() throws SQLException, ClassNotFoundException;
}
