
package Modelo;


public class Mesa 
{
    private int idMesa=-1;                                   
    private int cantidad;
    private String estado;
    private boolean activo;

    public Mesa(int idMesa, int cantidad, String estado,boolean activo)
    {
        this.idMesa = idMesa;
        this.cantidad = cantidad;
        this.estado = estado;
        this.activo=activo;
    }
     public Mesa(int cantidad,String estado,boolean activo)
    {
        this.idMesa =-1;
        this.cantidad = cantidad;
        this.estado=estado;
        this.activo=activo;
    }
    public Mesa()
    {
        this.idMesa=-1;
    }
      
      
      
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
