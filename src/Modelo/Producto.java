
package Modelo;

import java.time.LocalDate;


public class Producto
{
    private int idProducto=-1;
    private Categoria categoria;
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;
    private boolean activo;

    public Producto(int idProducto, Categoria categoria, int codigo, String nombre, int cantidad, double precio,boolean activo) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.activo=activo;
    }
    public Producto(Categoria categoria, int codigo, String nombre, int cantidad, double precio,boolean activo)
    {
        this.idProducto=-1;
        this.categoria=categoria;
        this.codigo=codigo;
        this.nombre = nombre;
        this.cantidad=cantidad;
        this.precio=precio;
        this.activo=activo;
    }
    public Producto()
    {
       
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }  
}

