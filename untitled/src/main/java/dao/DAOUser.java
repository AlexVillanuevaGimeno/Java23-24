package dao;

import connection.MotorSQL;
import beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUser {

    private MotorSQL motorSQL;

    private final String tableName = "usuario";
    private final String SQL_FINDALL = "SELECT * FROM " + tableName + " WHERE 1=1";

    public DAOUser(){
        motorSQL = MotorSQL.getMotorSQL();
    }

    public ArrayList<User> findAll(User user){
        String sql = "";
        sql = SQL_FINDALL;
        sql += " AND username = '" + user.getUsername() + "' AND password = '" + user.getPassword()+'\'';
        System.out.println(sql);
        ArrayList<User> listUser = new ArrayList<>();
        motorSQL.connect();
        ResultSet resultSet = motorSQL.executeQuery(sql);
        try {
            System.out.println("TRY findall usuario");
            while(resultSet.next()){
                User userAux = new User();
                userAux.setIdUser(resultSet.getInt(1));
                System.out.println("resultSet.getInt(1)");
                System.out.println(resultSet.getInt(1));
                userAux.setUsername(resultSet.getString(7));
                System.out.println("resultSet.getString(7)");
                System.out.println(resultSet.getString(7));
                userAux.setPassword(resultSet.getString(8));
                System.out.println("resultSet.getString(8)");
                System.out.println(resultSet.getString(8));
                listUser.add(userAux);
                System.out.println(userAux.toString());
//                usuarioAux.setId(resultSet.getInt(1));
//                usuarioAux.setUsername(resultSet.getString(2));
//                usuarioAux.setPassword(resultSet.getString(3));
//                System.out.println("im here 2.0");
//                listUsuario.add(usuarioAux);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        motorSQL.close();
        return listUser;
    }

}
