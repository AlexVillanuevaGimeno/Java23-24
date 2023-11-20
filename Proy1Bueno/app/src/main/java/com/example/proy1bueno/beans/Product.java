package com.example.proy1bueno.beans;

public class Product {
    private int idProducto;
    private String nombreProducto;
    private Double precioProducto;
    private String marcaProducto;

    //NO ES STRING ES DATE PERO FALLA EN EL CONSTRUCTOR DEL ACTION
    private String fechaSubidaProducto;
    private String descripcionProducto;
    private String imagenProducto;
    private int idUsuario;

    public Product() {
    }

    public Product(String nombreProducto, Double precioProducto, String marcaProducto, String fechaSubidaProducto,
                   String descripcionProducto, String imagenProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.marcaProducto = marcaProducto;
        this.fechaSubidaProducto = fechaSubidaProducto;
        this.descripcionProducto = descripcionProducto;
        this.imagenProducto = imagenProducto;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", marcaProducto='" + marcaProducto + '\'' +
                ", fechaSubidaProducto='" + fechaSubidaProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", imagenProducto='" + imagenProducto + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
