
package Modelo;

public class Categoria
{
    private int idCategoria=-1;
    private String nombre;
    private String descripcion;
    private boolean activo;

    public Categoria(int idCategoria, String nombre, String descripcion, boolean activo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }
    public Categoria(String nombre, String descripcion, boolean activo)
    {
        this.idCategoria = -1;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo=activo;
    }
    public Categoria()
    {
        this.idCategoria = -1;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
    
}
