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
    private int idUser;

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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getFechaSubidaProducto() {
        return fechaSubidaProducto;
    }

    public void setFechaSubidaProducto(String fechaSubidaProducto) {
        this.fechaSubidaProducto = fechaSubidaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
                ", idUsuario=" + idUser +
                '}';
    }
}
