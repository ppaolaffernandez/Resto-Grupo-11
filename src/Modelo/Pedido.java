
package Modelo;

import java.util.Date;


public class Pedido//nombre de la clase
{
    //atributos
    private int idPedido=-1;
    private Mesero mesero;
    private Mesa mesa;
    private Date fecha;
    private String hora;   
    private boolean activo;
    private boolean pendiente;
    private boolean entregado;
    
//constructores
    public Pedido(int idPedido,Mesero mesero,Mesa mesa, Date fecha, String  hora, boolean activo,boolean pendiente,boolean entregado)
    {
        this.idPedido = idPedido;
        this.mesero = mesero;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;       
        this.activo = activo;
        this.pendiente=pendiente;
        this.entregado=entregado;
    }
    public Pedido(Mesero mesero,Mesa mesa, Date fecha, String  hora, boolean activo,boolean pendiente,boolean entregado){
        this.idPedido = -1;
        this.mesero = mesero;
        this.mesa = mesa;
        this.fecha=fecha;
        this.hora=hora;
        this.activo=activo;
        this.pendiente=pendiente;
        this.entregado=entregado;
        
    }
    public Pedido()
    {      
        this.idPedido = -1;
    }

    
    
    //Metodos

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    public boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
   
    
}
