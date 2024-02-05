package dao.util;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudUtil {
    public static <T>T execute(String sql, Object ...args) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        if(sql.startsWith("SELECT") || sql.startsWith("select")){
            if(args.length!=0){
                for(int i =0; i< args.length; ++i){
                    pstm.setObject((i+1),args[i]);
                }
                return (T)pstm.executeQuery();
            }else if(args.length==0){
                return (T)pstm.executeQuery();
            }
        }
        for(int i =0; i< args.length; ++i){
            pstm.setObject((i+1),args[i]);
        }
        return (T)(Boolean)(pstm.executeUpdate()>0);
    }
}
