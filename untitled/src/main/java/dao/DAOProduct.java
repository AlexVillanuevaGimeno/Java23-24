package dao;

import beans.Product;
import connection.MotorSQL;


public class DAOProduct {

    private MotorSQL motorSQL;

    private final String tableName = "producto";
    private final String SQL_INSERT = "INSERT INTO " + tableName + " \" (Id_Producto, Nombre_Producto, Precio_Producto, " +
            "Marca_Producto, Fecha_Subida_Producto, Descripcion_Producto, Imagen_Producto, Id_Usuario)  VALUES ";

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

}
