
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
            
            String sql = "INSERT INTO mesa (cantidad, estado, activo) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            
            statement.setInt(1, mesa.getCantidad());
            statement.setString(2, mesa.getEstado());
            statement.setBoolean(3, mesa.getActivo());
            
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
            String sql = "SELECT * FROM mesa;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Mesa mesa;
            
            while(resultSet.next())
            {
                mesa = new Mesa();
                
                mesa.setIdMesa(resultSet.getInt("idMesa"));
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
    public void borrarMesa(int id){
    try {
            
            String sql = "DELETE FROM mesa WHERE idMesa =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);

            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una mesa: " + ex.getMessage());
        }
    }
    
    public void actualizarMesa(Mesa mesa){
    
        try {
            
            String sql = "UPDATE mesa SET cantidad = ?, estado = ? , activo =? WHERE idMesa = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesa.getCantidad());
            statement.setString(2, mesa.getEstado());
            statement.setBoolean(3, mesa.getActivo());
            statement.setInt(4, mesa.getIdMesa());
            statement.executeUpdate();
            
          
            statement.close();
    
        }
        catch (SQLException ex)
        {
            System.out.println("Error al insertar una mesa: " + ex.getMessage());
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
                mesa.setCantidad(resultSet.getInt("cantidad"));
                mesa.setEstado(resultSet.getString("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));

                
            }      
            statement.close();

        }
    catch (SQLException ex)
    {
            System.out.println("Error al insertar una mesa: " + ex.getMessage());
        }
        
        return mesa;
    }
    
}
  

