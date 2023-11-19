package dao;

import bean.Product;
import motor.MotorDerby;

public class DaoProduct {
    private final String tableName = "Producto";

    //INSERT INTO Producto (Id_Producto, Nombre_Producto, Precio_Producto, Marca_Producto, Fecha_Subida_Producto, Descripcion_Producto, Imagen_Producto, Id_Usuario)
    private String INSERT_SQL = "INSERT INTO " + tableName + " (Id_Producto, Nombre_Producto, Precio_Producto, Marca_Producto, " +
            "Fecha_Subida_Producto, Descripcion_Producto, Imagen_Producto, Id_Usuario) VALUES ";
    private String FIND_ALL_SQL = "SELECT * FROM " + tableName + " WHERE 1=1";

    private MotorDerby motorDerby;


    public DaoProduct(){
        motorDerby = new MotorDerby();
    }
public void add(Product bean){
    motorDerby.connect();
//        INSERT INTO PRODUCT (NOMBRE, CATEGORIA) VALUES('NOMBRE_PRODUCTO', 'CAFE')
    String sql = INSERT_SQL;
    sql += "('" + bean.getIdProducto() + "', '" + bean.getNombreProducto() +
            "', '" + bean.getPrecioProducto() + "', '" + bean.getMarcaProducto() +
            "', '" + bean.getFechaSubidaProducto() + "', '" + bean.getDescripcionProducto() +
            "', '" + bean.getImagenProducto() +  "', '" + bean.getIdUsuario() + "')";
    System.out.println(sql);
    System.out.println("Columnas modificadas: " + motorDerby.executeUpdate(sql));
    motorDerby.close();
}
}
