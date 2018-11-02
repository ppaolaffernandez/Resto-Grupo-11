package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MeseroData
{
    private Connection connection = null;
    private Conexion conexion;
    
    public MeseroData(Conexion conexion)
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
    public void guardarMesero(Mesero mesero)
    {
        try 
        {           
            String sql = "INSERT INTO mesero (nombre, dni, activo) VALUES ( ? , ? , ? );";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            id se incrementa automaticamente en guardar
            statement.setString(1, mesero.getNombre());
            statement.setInt(2, mesero.getDni());
            statement.setBoolean(3, mesero.getActivo());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) 
            {
                mesero.setIdMesero(rs.getInt(1));
            } 
            else
            {
                System.out.println("No se pudo obtener el id luego de insertar un mesero");
            }
            statement.close();    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un mesero: " + ex.getMessage());
        }
    }
    
    public List<Mesero> obtenerMeseros()
    {
        List<Mesero> meseros = new ArrayList<Mesero>();
            
        try 
        {
            String sql = "SELECT * FROM mesero WHERE activo = 1;";//lista solo los meseros que estan activos
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            
            while(resultSet.next())
            {
                mesero = new Mesero();
                
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));
                mesero.setActivo(resultSet.getBoolean("activo"));

                meseros.add(mesero);
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener los mesero: " + ex.getMessage());
        }      
        return meseros;
    }
    
    
     public void borrarMesero(int id) 
    {
    try 
        {
            
//            String sql = "DELETE FROM mesa WHERE idMesa =?;";
             String sql =  "UPDATE mesero SET activo = false WHERE idMesero = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);

            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una mesero: " + ex.getMessage());
        }
        }
    
            
    
    public void actualizarMesero(Mesero mesero)
    {
    
        try {
            
            String sql = "UPDATE mesero SET nombre = ?, dni = ? , activo = ? WHERE idMesero = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
            statement.setString(1, mesero.getNombre());
            statement.setInt(2, mesero.getDni());           
            statement.setBoolean(3, mesero.getActivo());
            statement.setInt(4, mesero.getIdMesero());
            
            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error al actualizar un mesero: " + ex.getMessage());
        }
    
    }
    
    public Mesero buscarMesero(int id)
    {
        Mesero mesero=null;
         try 
         {
            
            String sql = "SELECT * FROM mesero WHERE idMesero =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
                  
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                mesero = new Mesero();
                
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));                
                mesero.setActivo(resultSet.getBoolean("activo"));
    
            }      
            statement.close();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al buscar un mesero: " + ex.getMessage());
        }   
        return mesero;
    } 
//    _______________________________________________________________________NUEVO_________________________________________________________
     
    
     public List<Mesero> obtenerCategoriasDeMeseros()
    {
        List<Mesero> meseros = new ArrayList<Mesero>();
            
        try 
        {
            String sql = "SELECT * FROM mesero;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            
            while(resultSet.next()){
                mesero = new Mesero();
                
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));                
                mesero.setActivo(resultSet.getBoolean("activo"));

                meseros.add(mesero);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesero: " + ex.getMessage());
        }
              
        return meseros;
    }
     //-------nuevo
      public Mesero buscarMeseroNombre(String nombre)
      {
        Mesero mesero=null;
         try
         {
            
            String sql = "SELECT * FROM mesero WHERE nombre =?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombre);
                  
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                mesero = new Mesero();
                
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));                
                mesero.setActivo(resultSet.getBoolean("activo"));
            }      
            statement.close();
        } 
         catch (SQLException ex)
         {
            System.out.println("Error al insertar un mesero: " + ex.getMessage());
        }   
        return mesero;
    }
      
      
     public List<Mesero> obtenerMeserosPorNombre(String nombre)
    {
        List<Mesero> meseros = new ArrayList<Mesero>();
            
        try 
        {
            String sql = "SELECT * FROM mesero WHERE nombre =?;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            
            while(resultSet.next())
            {
                mesero = new Mesero();
                
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));                
                mesero.setActivo(resultSet.getBoolean("activo"));

                meseros.add(mesero);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesero: " + ex.getMessage());
        }
              
        return meseros;
    }  
     
     
     
     
     
     
     
     
      /*______________________________________________________________________________________________________
    ___________________________________  PARA LISTAR POR SUS ATRIBUTOS(DATOS)______________________________________________________________
    ____________________________________________Cambiar depende de que quiera puede ser dni entero o string pero lo ______________________________________________
    __haremos entero*/
     
     
     
   public List<Mesero> obtenerMeserosPorDni(int dni)
    {
        List<Mesero> meseros = new ArrayList<Mesero>();
            
        try 
        {
            String sql = "SELECT * FROM mesero WHERE dni =?;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dni);
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            
            while(resultSet.next())
            {
                mesero = new Mesero();
                
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));                
                mesero.setActivo(resultSet.getBoolean("activo"));

                meseros.add(mesero);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesero: " + ex.getMessage());
        }
              
        return meseros;
    }  
   
   public List<Mesero> obtenerMeserosPorDesactivado()
    {
        List<Mesero> meseros = new ArrayList<Mesero>();
            
        try 
        {
            String sql = "SELECT * FROM mesero WHERE activo =0;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            
            while(resultSet.next())
            {
                mesero = new Mesero();
                
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));                
                mesero.setActivo(resultSet.getBoolean("activo"));

                meseros.add(mesero);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesero: " + ex.getMessage());
        }
              
        return meseros;
    }  
   
   
}
 /*______________________________________________________________________________________________________
    ___________________________________  PARA LISTAR POR SUS ATRIBUTOS(DATOS)______________________________________________________________
    __________________________________________________________________________________________
    _________________________________________________________________________________*/

