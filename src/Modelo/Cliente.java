package Modelo;


public class Cliente 
{
    private int idCliente=-1;
    private int dni;
    private String nombre;
    private boolean activo;

    public Cliente(int idCliente, int dni, String nombre,boolean activo)//busca ir(sobrecargo metodos)
    {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.activo=activo;
    }
    public Cliente(int dni,String nombre,boolean activo)//
    {
        this.idCliente = -1;
        this.nombre = nombre;
    }
    public Cliente()
    {
        this.idCliente = -1;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
