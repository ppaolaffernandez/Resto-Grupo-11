package Modelo;


import java.util.Date;

public class Reserva
{
    private int idReserva=-1;
    private Cliente cliente;
    private Mesa mesa;
    private String hora;
    private Date fecha;   
    private boolean activo;

    public Reserva(int idReserva,Cliente cliente,Mesa mesa, String hora, Date fecha,boolean activo)
    {
        this.idReserva=idReserva;
        this.cliente = cliente;
        this.mesa=mesa;
        this.hora = hora;
        this.fecha = fecha;
        this.activo=activo;
    }
    public Reserva( Cliente cliente,Mesa mesa,String hora, Date fecha, boolean activo) 
    {
        this.idReserva = -1;
        this.cliente = cliente;
        this.mesa=mesa;
        this.hora=hora;
        this.fecha = fecha;
        this.activo = activo;
    }
    public Reserva()
    {
        this.idReserva = -1;
    }
    
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

  
    
}
   