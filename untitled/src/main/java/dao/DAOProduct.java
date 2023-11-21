package dao;

import beans.Product;
import beans.User;
import connection.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOProduct {

    private MotorSQL motorSQL;

    private final String tableName = "producto";
    private final String SQL_INSERT = "INSERT INTO " + tableName + " \" (Id_Producto, Nombre_Producto, Precio_Producto, " +
            "Marca_Producto, Fecha_Subida_Producto, Descripcion_Producto, Imagen_Producto, Id_Usuario)  VALUES ";
    private final String SQL_FINDALL = "SELECT * FROM " + tableName + " WHERE 1=1";

    public DAOProduct(){
        motorSQL = MotorSQL.getMotorSQL();
    }

    public String add(Product bean){
        String sql = "";
        sql = SQL_INSERT;
        sql += "('" + bean.getIdProducto() + "', '" + bean.getNombreProducto() +
                "', '" + bean.getPrecioProducto() + "', '" + bean.getMarcaProducto() +
                "', '" + bean.getFechaSubidaProducto() + "', '" + bean.getDescripcionProducto() +
                "', '" + bean.getImagenProducto() +  "', '" + bean.getIdUsuario() + "')";
        System.out.println(sql);
        motorSQL.connect();
        motorSQL.executeUpdate(sql);
        motorSQL.close();
        return "";
    }

//    public ArrayList<Product> findAll(Product product){
//        String sql = "";
//        sql = SQL_FINDALL;
//        sql += " AND Id_Producto = '" + product.getIdProducto() + "' AND Nombre_Producto = '" + product.getNombreProducto()
//                + "' AND Precio_Producto = '" + product.getPrecioProducto() + "' AND Marca_Producto = '" + product.getMarcaProducto()
//                + "' AND Fecha_Subida_Producto = '" + product.getFechaSubidaProducto() + "' AND Descripcion_Producto = '" + product.getDescripcionProducto()
//                + "'' AND Imagen_Producto = '" + product.getImagenProducto();
//        System.out.println(sql);
//        ArrayList<Product> lstProducts = new ArrayList<>();
//        motorSQL.connect();
//        ResultSet resultSet = motorSQL.executeQuery(sql);
//        try {
//            System.out.println("TRY findall usuario");
//            while(resultSet.next()){
//                User userAux = new User();
//                userAux.setIdUsuario(resultSet.getInt(1));
//                System.out.println("resultSet.getInt(1)");
//                System.out.println(resultSet.getInt(1));
//                userAux.setUsername(resultSet.getString(7));
//                System.out.println("resultSet.getString(7)");
//                System.out.println(resultSet.getString(7));
//                userAux.setPassword(resultSet.getString(8));
//                System.out.println("resultSet.getString(8)");
//                System.out.println(resultSet.getString(8));
//                listUser.add(userAux);
//                System.out.println(userAux.toString());
////                usuarioAux.setId(resultSet.getInt(1));
////                usuarioAux.setUsername(resultSet.getString(2));
////                usuarioAux.setPassword(resultSet.getString(3));
////                System.out.println("im here 2.0");
////                listUsuario.add(usuarioAux);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        motorSQL.close();
//        return listUser;
//    }

}
