
/*int para  enteros (no van con comas)
  String para letras 
  Double para decimeales(Numeros con coma)
  Date para fechas
  time para horas(pero juan lo usa como String porque es mas dificil usarlo)
*/

package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaData
{
    private Connection connection = null;
    private Conexion conexion;
    //poner this this.conexion=conexion; SIEMPREEEEEEEE AVECES SE SALE CUANDO PASAMOS¡¡¡¡¡¡¡¡¡¡.

    
    public CategoriaData(Conexion conexion)
    {
        try 
        {
       //poner this this.conexion=conexion; SIEMPREEEEEEEE AVECES SE SALE CUANDO PASAMOS¡¡¡¡¡¡¡¡¡¡.
   
         this.conexion=conexion;
            connection = conexion.getConexion();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    /*/GUARGARRRRRR____________GUARDAR______________________________GUARDAR___________________
    ____________GUARDAR______________________________GUARDAR___________________
    ______________________________GUARDAR___________________ ______________________________GUARDAR___________________ */
    
    
    //    el id en guardar incrementea automaticamente

    public void guardarCategoria(Categoria categoria)
    {
        try 
        {           
         //*EN EL GUARDAR NUNCA LLEVA EL ID DE LA CLAVE PRINCIPAL,IDPRODCTO EN ESTE CASO

            String sql = "INSERT INTO categoria (nombre, descripcion, activo) VALUES ( ? , ? , ? );";
            
            //*EN EL GUARDAR NUNCA LLEVA EL ID DE LA CLAVE PRINCIPAL,IDPRODCTO EN ESTE CASO

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            statement.setString(1, categoria.getNombre());
            statement.setString(2, categoria.getDescripcion());
            statement.setBoolean(3, categoria.getActivo());
 
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) 
            {
                categoria.setIdCategoria(rs.getInt(1));
            } 
            else
            {
                System.out.println("No se pudo obtener el id luego de insertar un categoria");
            }
            statement.close();    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar una categoria: " + ex.getMessage());
        }
    }
    
    public List<Categoria> obtenerCategorias()//*cuadno vea rojo el metodo es porque me falta una llave arriba
    {
        List<Categoria> categorias = new ArrayList<Categoria>();
            
        try 
        {
//            String sql = "SELECT * FROM categoria;";
            String sql = "SELECT * FROM categoria WHERE activo = 1;";//lista solo los meseros que estan activos
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Categoria categoria;
            
            while(resultSet.next())
            {
                categoria = new Categoria();
                
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categoria.setActivo(resultSet.getBoolean("activo"));

                categorias.add(categoria);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los categoria: " + ex.getMessage());
        }
              
        return categorias;
    }
     public List<Categoria> obtenerCategoriasPorNombre(String nombre)
    {
        List<Categoria> categorias = new ArrayList<Categoria>();
            
        try 
        {
            String sql = "SELECT * FROM categoria WHERE nombre =?;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            Categoria categoria;
            
            while(resultSet.next())
            {
                categoria = new Categoria();
                
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categoria.setActivo(resultSet.getBoolean("activo"));

                categorias.add(categoria);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener las categoria: " + ex.getMessage());
        }
              
        return categorias;
    }
     
  /*/BUorrrar____________BORRAR______________________________BORRAR___________________
    ____________BORRAR______________________________BBUorrrar____________BORRAR______________________________BORRAR______________________________________
    ______________________________BORRAR___________________ ______________________________BORRAR___________________ */
        
     
     
    public void borrarCategoria(int id)
    {
         try
        {
           //     String sql = "DELETE FROM mesero WHERE idMesero =?;"; //  ELIMNA EL ACTIVO todo lo elimna completamente

            String sql =  "UPDATE categoria SET activo = false WHERE idCategoria = ?;";//Actualizamos el activo,si borra el activo queda en false y si no borra el true 0=false, 1=true
           
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            
            
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al borrar una Categoria: " + ex.getMessage());
        }
        
    
    }
    
    
    
     /*/ACTUALZAR____________ACTUALZAR______________________________ACTUALZARR___________________
    ____________ACTUALZARR______________________________ACTUALZARR___________________
    ______________________________ACTUALZARR___________________ ______________________________ACTUALZARR___________________ */
    
    
    
    
    
    public void actualizarCategoria(Categoria categoria)
    {
    
        try {
            
            String sql = "UPDATE categoria SET nombre = ?, descripcion = ? , activo =? WHERE idCategoria = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
            statement.setString(1, categoria.getNombre());
            statement.setString(2, categoria.getDescripcion());
            statement.setBoolean(3, categoria.getActivo());
            statement.setInt(4, categoria.getIdCategoria());
            
            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error al actualizar una categoria: " + ex.getMessage());
        }
    
    }
    
      /*/BUSCARRRRR____________BUSCARRRRR______________________________BUSCARRRRRARR___________________
    ____________BUSCARRRRR______________________________BUSCARRRRRARR___________________
    ______________________________BUSCARRRRR___________________ ______________________________BUSCARRRRRRR___________________ */
    
    
    public Categoria buscarCategoria(int id)
    {
        Categoria categoria=null;
         try 
         {
            
            String sql = "SELECT * FROM categoria WHERE idCategoria =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
                  
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                categoria = new Categoria();
                
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categoria.setActivo(resultSet.getBoolean("activo"));
    
            }      
            statement.close();
        } 
         catch (SQLException ex)
         {
            System.out.println("Error al buscar una categoria: " + ex.getMessage());
        }   
        return categoria;
    } 
    //....Nuevo..........
    
    
    /*/obtenerCategoriasDeProductos____________obtenerCategoriasDeProductos______________________________obtenerCategoriasDeProductos___________________
    ____________obtenerCategoriasDeProductos______________________________obtenerCategoriasDeProductos___________________
    ______________________________obtenerCategoriasDeProductos___________________ _____________________________obtenerCategoriasDeProductos___________________ */  
   
    
    
     public List<Categoria> obtenerCategoriasDeProductos()
    {
        List<Categoria> categorias = new ArrayList<Categoria>();
            
        try {
            String sql = "SELECT * FROM categoria;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Categoria categoria;
            
            while(resultSet.next()){
                categoria = new Categoria();
                
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categoria.setActivo(resultSet.getBoolean("activo"));

                categorias.add(categoria);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener las categoria: " + ex.getMessage());
        }
              
        return categorias;
    }
     
     
      /*/BUSCAR´POR NOMBRE____________BUSCAR´POR NOMBRER______________________________BUSCAR´POR NOMBRE___________________
    ____________BUSCAR´POR NOMBRE______________________________BUSCAR´POR NOMBRER___________________
    ______________________________BUSCAR´POR NOMBRE___________________ _____________________________BUSCAR´POR NOMBRE___________________ */
     
     
      public Categoria buscarCategoriaNombre(String nombre)
      {
        Categoria categoria=null;
         try {
            
            String sql = "SELECT * FROM categoria WHERE nombre =?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombre);
                  
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                categoria = new Categoria();
                
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categoria.setActivo(resultSet.getBoolean("activo"));
    
            }      
            statement.close();
        } 
         catch (SQLException ex)
         {
            System.out.println("Error al buscar una categoria: " + ex.getMessage());
        }   
        return categoria;
    } 
      
      
    public List<Categoria> obtenerCategoriasPorDesactivado()
    {
        List<Categoria> categorias = new ArrayList<Categoria>();
            
        try 
        {
            String sql = "SELECT * FROM categoria WHERE activo =0;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            Categoria categoria;
            
            while(resultSet.next())
            {
                categoria = new Categoria();
                
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categoria.setActivo(resultSet.getBoolean("activo"));

                categorias.add(categoria);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesero: " + ex.getMessage());
        }
              
        return categorias;
    }  
      
}
