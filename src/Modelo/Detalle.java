
package Modelo;

public class Detalle
{
    private int idDetalle=-1;
    private Producto producto;
    private Pedido pedido;
    private int cantidad;
    private double total;
    private boolean activo;

    public Detalle(int idDetalle,Producto producto, Pedido pedido, int cantidad, double total,boolean activo) 
    {
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.total = total;
        this.activo=activo;
    }
    public Detalle(Producto producto, Pedido pedido, int cantidad, double total,boolean activo)
    {
        this.idDetalle=idDetalle;
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.total = total;
        this.activo=activo;
    }

    public Detalle() 
    {
        this.idDetalle=-1;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
  
    
}
