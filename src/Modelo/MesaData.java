
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
public class MesaData 
{
     private Connection connection = null;
     private Conexion conexion;

    public MesaData(Conexion conexion)
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
    
    
    public void guardarMesa(Mesa mesa)
    {
        try
        {
            
            String sql = "INSERT INTO mesa (nombre , cantidad, estado, activo) VALUES (? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, mesa.getNombre());
            statement.setInt(2, mesa.getCantidad());
            statement.setString(3, mesa.getEstado());
            statement.setBoolean(4, mesa.getActivo());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
            {
                mesa.setIdMesa(rs.getInt(1));
            }
            else
            {
                System.out.println("No se pudo obtener el id luego de insertar una mesa");
            }
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar una mesa: " + ex.getMessage());
        }
    }
    
    public List<Mesa> obtenerMesas()
    {
        List<Mesa> mesas = new ArrayList<Mesa>();
            
        try 
        {
//            String sql = "SELECT * FROM mesa;";
            String sql = "SELECT * FROM mesa WHERE activo = 1;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Mesa mesa;
            
            while(resultSet.next())
            {
                mesa = new Mesa();
                
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setNombre(resultSet.getString("nombre"));
                mesa.setCantidad(resultSet.getInt("cantidad"));
                mesa.setEstado(resultSet.getString("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));
                mesas.add(mesa);
            }      
            statement.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesas: " + ex.getMessage());
        } 
        return mesas;
    }

    public void borrarMesa(int id)
    {
    try 
        {
            
//            String sql = "DELETE FROM mesa WHERE idMesa =?;";
             String sql =  "UPDATE mesa SET activo = false WHERE idMesa = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);

            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una mesa: " + ex.getMessage());
        }
        }
    
    public void actualizarMesa(Mesa mesa){
    
        try {
            
            String sql = "UPDATE mesa SET nombre = ?, cantidad = ?, estado = ? , activo =? WHERE idMesa = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             statement.setString(1, mesa.getNombre());
            statement.setInt(2, mesa.getCantidad());
            statement.setString(3, mesa.getEstado());
            statement.setBoolean(4, mesa.getActivo());
            statement.setInt(5, mesa.getIdMesa());
            statement.executeUpdate();
            
          
            statement.close();
    
        }
        catch (SQLException ex)
        {
            System.out.println("Error al actualizar una mesa: " + ex.getMessage());
        }
    
    }
    
    public Mesa buscarMesa(int id){
    Mesa mesa=null;
    try
    {
            
            String sql = "SELECT * FROM mesa WHERE idMesa =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                mesa = new Mesa();
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setNombre(resultSet.getString("nombre"));
                mesa.setCantidad(resultSet.getInt("cantidad"));
                mesa.setEstado(resultSet.getString("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));

                
            }      
            statement.close();

        }
    catch (SQLException ex)
    {
            System.out.println("Error al buscar una mesa: " + ex.getMessage());
        }
        
        return mesa;
    }
//    _________________________________________BUSCAR_________________________________________________________
    
      //    lista nombres de mesas
    public List<Mesa> obtenerMesasPorNombre(String nombre)
    {
        List<Mesa> mesas = new ArrayList<Mesa>();
            
        try 
        {
            String sql = "SELECT * FROM mesa WHERE nombre = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            Mesa mesa;
            
            while(resultSet.next())
            {
                mesa = new Mesa();
                
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setNombre(resultSet.getString("nombre"));
                mesa.setCantidad(resultSet.getInt("cantidad"));
                mesa.setEstado(resultSet.getString("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));
                mesas.add(mesa);
            }      
            statement.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesas: " + ex.getMessage());
        } 
        return mesas;
    } 
     

     
   public List<Mesa> obtenerMesasPorCantidad(int cantidad)
    {
        List<Mesa> mesas = new ArrayList<Mesa>();
            
        try 
        {
            String sql = "SELECT * FROM mesa WHERE cantidad =?;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cantidad);
            ResultSet resultSet = statement.executeQuery();
            Mesa mesa;
            
            while(resultSet.next())
            {
                mesa = new Mesa();
                
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setNombre(resultSet.getString("nombre"));
                mesa.setCantidad(resultSet.getInt("cantidad"));
                mesa.setEstado(resultSet.getString("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));
                mesas.add(mesa);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los mesero: " + ex.getMessage());
        }
              
        return mesas;
    }  
   
   public List<Mesa> obtenerMesasPorDesactivado()
    {
        List<Mesa> mesas = new ArrayList<Mesa>();
            
        try 
        {
           String sql = "SELECT * FROM mesa WHERE activo =0;";// 0 desactivadas.....1 activadas
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            Mesa mesa;
            
            while(resultSet.next())
            {
                mesa = new Mesa();
                
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setNombre(resultSet.getString("nombre"));
                mesa.setCantidad(resultSet.getInt("cantidad"));
                mesa.setEstado(resultSet.getString("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));
                mesas.add(mesa);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener las mesas: " + ex.getMessage());
        }
              
        return mesas;
    }       
//    el botonn spinner  se usa asi
    public List<Mesa> obtenerCantidad()
    {
        List<Mesa> mesas = new ArrayList<Mesa>();
            
        try 
        {
           String sql = "SELECT distinct cantidad FROM mesa ;";// 0 desactivadas.....1 activadas
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            Mesa mesa;
            
            while(resultSet.next())
            {
                mesa = new Mesa();

                mesa.setCantidad(resultSet.getInt("cantidad"));
  
                mesas.add(mesa);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener las mesa: " + ex.getMessage());
        }
              
        return mesas;
    }       
    
    
    
    
    
}
  

