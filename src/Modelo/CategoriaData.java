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
    
    public CategoriaData(Conexion conexion)
    {
        try 
        {
         this.conexion=conexion;
            connection = conexion.getConexion();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    public void guardarCategoria(Categoria categoria)
    {
        try 
        {           
            String sql = "INSERT INTO categoria (nombre, descripcion, activo) VALUES ( ? , ? , ? );";
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
    
    public List<Categoria> obtenerCategorias()
    {
        List<Categoria> categorias = new ArrayList<Categoria>();
            
        try 
        {
            String sql = "SELECT * FROM categoria;";
            
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
            System.out.println("Error al obtener los categoria: " + ex.getMessage());
        }
              
        return categorias;
    }
    public void borrarCategoria(int id)
    {
         try
        {
            String sql =  "UPDATE categoria SET activo = false WHERE idCategoria = ?;";//Actualizamos el activo,si borra el activo queda en false y si no borra el true 0=false, 1=true
            
//            String sql = "DELETE FROM categoria WHERE idCategoria =?;";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            
            
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un Categoria: " + ex.getMessage());
        }
        
    
    }
    
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
            System.out.println("Error al insertar un categoria: " + ex.getMessage());
        }
    
    }
    
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
            System.out.println("Error al buscar un categoria: " + ex.getMessage());
        }   
        return categoria;
    } 
    //....Nuevo..........
    
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
            System.out.println("Error al obtener los categoria: " + ex.getMessage());
        }
              
        return categorias;
    }
     //-------nuevo
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
            System.out.println("Error al insertar un categoria: " + ex.getMessage());
        }   
        return categoria;
    } 
      
}
