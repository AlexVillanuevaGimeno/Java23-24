package dao;

import connection.MotorSQL;
import beans.Usuario;

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

    public ArrayList<Usuario> findAll(Usuario usuario){
        String sql = "";
        sql = SQL_FINDALL;
        sql += " AND username = '" + usuario.getUsername() + "' AND password = '" + usuario.getPassword()+'\'';
        System.out.println(sql);
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        motorSQL.connect();
        ResultSet resultSet = motorSQL.executeQuery(sql);
        try {
            System.out.println("TRY findall usuario");
            while(resultSet.next()){
                Usuario usuarioAux = new Usuario();
                usuarioAux.setIdUsuario(resultSet.getInt(1));
                System.out.println("resultSet.getInt(1)");
                System.out.println(resultSet.getInt(1));
                usuarioAux.setUsername(resultSet.getString(2));
                System.out.println("resultSet.getString(2)");
                System.out.println(resultSet.getString(2));
                usuarioAux.setPassword(resultSet.getString(3));
                System.out.println("resultSet.getString(3)");
                System.out.println(resultSet.getString(3));
                listUsuario.add(usuarioAux);
                System.out.println(usuarioAux.toString());
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
        return listUsuario;
    }

}
