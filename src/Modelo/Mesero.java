
package Modelo;


public class Mesero 
{
    private int idMesero=-1;
    private String nombre;
    private int dni;
    private boolean activo;

    public Mesero(int idMesero, String nombre, int dni, boolean activo)
    {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.dni = dni;
        this.activo = activo;
    }
    public Mesero( String nombre,int dni, boolean activo)
    {
        this.idMesero = -1;
        this.nombre = nombre;
        this.dni = dni;
        this.activo=activo;
        
    }
    public Mesero()
    {
        this.idMesero = -1;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
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

    public void setActivo(boolean estado) {
        this.activo = activo;
    }
    
}
