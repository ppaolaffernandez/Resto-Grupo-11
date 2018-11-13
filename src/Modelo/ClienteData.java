package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteData 
{
    private Connection connection = null;
    private Conexion conexion;

    public ClienteData(Conexion conexion)
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
    
//    el id en guardar incrementea automaticamente
    public void guardarCliente(Cliente cliente)
    {
        try
        {
            
            String sql = "INSERT INTO cliente (dni, nombre, activo) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cliente.getDni());
            statement.setString(2, cliente.getNombre());
            statement.setBoolean(3, cliente.getActivo());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) 
            {
                cliente.setIdCliente(rs.getInt(1));
            }
            else 
            {
                System.out.println("No se pudo obtener el id luego de insertar un cliente");//acaaaaaa
            }
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al guardar un cliente: " + ex.getMessage());
        }
    }
    
    public List<Cliente> obtenerClientes()
    {
        List<Cliente> clientes = new ArrayList<Cliente>();
            
        try
        {
//            String sql = "SELECT * FROM cliente;";
            String sql = "SELECT * FROM cliente WHERE activo = 1;";//lista solo los meseros que estan activos
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            
            while(resultSet.next())
            {
                cliente = new Cliente();
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                
                cliente.setActivo(resultSet.getBoolean("activo"));

                clientes.add(cliente);
            }      
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error al obtener los cliente: " + ex.getMessage());
        }
 
        return clientes;
    }

    public void borrarCliente(int id) //cLAUDIA LLO HIZO LO COPIE DE MESA DATA
    {
    try 
        {
            
          //     String sql = "DELETE FROM mesero WHERE idMesero =?;"; //  ELIMNA EL ACTIVO todo lo elimna completamente
             String sql =  "UPDATE cliente SET activo = false WHERE idCliente = ?;";//  eSTE MODIFICA EL ACTIVO, no borra
             

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);

            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un cliente: " + ex.getMessage());
        }
        }
    
    public void actualizarCliente(Cliente cliente)
    {
        try 
        {
            
            String sql = "UPDATE cliente SET dni = ?, nombre = ? , activo =? WHERE idCliente = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, cliente.getDni());
            statement.setString(2, cliente.getNombre());    
            statement.setBoolean(3, cliente.getActivo());
            statement.setInt(4, cliente.getIdCliente());
            
            statement.executeUpdate();
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al actualizar un cliente: " + ex.getMessage());
        }
    
    }
    
    public Cliente buscarCliente(int id)
    {
      Cliente cliente=null;
        try
        {
            
            String sql = "SELECT * FROM cliente WHERE idCliente =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                cliente = new Cliente();
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));              
                cliente.setActivo(resultSet.getBoolean("activo"));
     
            }      
            statement.close();        
        }catch (SQLException ex){
            System.out.println("Error al buscar un cliente: " + ex.getMessage());
        }
        
        return cliente;
    }
    //Cliente buscar por dni q me lo pide la clase pedido
   

//    _____________________________________NUEVO_________________________________________________
//    
    
     public List<Cliente> obtenerClientesDeReservas()
    {
        List<Cliente> clientes = new ArrayList<Cliente>();
            
        try {
            String sql = "SELECT * FROM cliente;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            
            while(resultSet.next()){
                cliente= new Cliente();
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                
                cliente.setActivo(resultSet.getBoolean("activo"));

                clientes.add(cliente);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los cliente: " + ex.getMessage());
        }
              
        return clientes;
    }
     
     
     
     public Cliente buscarClienteNombre(String nombre)
      {
        Cliente cliente=null;
         try
         {
            
            String sql = "SELECT * FROM cliente WHERE nombre =?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombre);
                  
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));              
                cliente.setActivo(resultSet.getBoolean("activo"));
    
            }      
            statement.close();
        } 
         catch (SQLException ex)
         {
            System.out.println("Error al buscar un cliente: " + ex.getMessage());//claudia
        }   
        return cliente;
    } 
     
     public List<Cliente> obtenerClientesPorNombre(String nombre)//LO HICE CLAUDIA
    {
        List<Cliente> clientes = new ArrayList<Cliente>();
            
        try 
        {
            String sql = "SELECT * FROM cliente WHERE nombre = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            
            while(resultSet.next())
            {
                cliente = new Cliente();
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));              
                cliente.setActivo(resultSet.getBoolean("activo"));
                clientes.add(cliente);
            }      
            statement.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener las mesas: " + ex.getMessage());
        } 
        return clientes;
    }

     //_______________________________________BUSCAR POR DNI_____________________________________________
     
    //________________________________________BUSCAR POR NOMBRE___________________________________________
    
     public Cliente buscarClienteXNombre(String nom)
    {
      Cliente cliente=null;
        try
        {
            
            String sql = "SELECT * FROM cliente WHERE nombre =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nom);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));              
                cliente.setActivo(resultSet.getBoolean("activo"));
     
            }      
            statement.close();        
        }catch (SQLException ex){
            System.out.println("Error al buscar un cliente: " + ex.getMessage());
        }
        
        return cliente;
    }
     public Cliente buscarClienteXDni(int dni)
    {
      Cliente cliente=null;
        try
        {
            
            String sql = "SELECT * FROM cliente WHERE dni =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                cliente = new Cliente();

                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));              
                cliente.setActivo(resultSet.getBoolean("activo"));             
                    
            }      
            statement.close();        
        }catch (SQLException ex){
            System.out.println("Error al insertar un cliente: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar un cliente");
        }
        
        return cliente;
    }
     
     
     
     
     
     
     
     
     
     
     
     
public List<Cliente> obtenerClientePorDni(int dni)
    {
        List<Cliente> clientes = new ArrayList<Cliente>();
            
        try 
        {
            String sql = "SELECT * FROM cliente WHERE dni =?;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dni);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            
            while(resultSet.next())
            {
                cliente = new Cliente();
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));                

                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setActivo(resultSet.getBoolean("activo"));

                clientes.add(cliente);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los cliente: " + ex.getMessage());
        }
              
        return clientes;
    }  
   
   public List<Cliente> obtenerClientePorDesactivado()
    {
        List<Cliente> clientes = new ArrayList<Cliente>();
            
        try 
        {
            String sql = "SELECT * FROM cliente WHERE activo =0;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            
            while(resultSet.next())
            {
                cliente = new Cliente();
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setDni(resultSet.getInt("dni"));                

                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setActivo(resultSet.getBoolean("activo"));

                clientes.add(cliente);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los cliente: " + ex.getMessage());
        }
              
        return clientes;
    }  
   
   
}
 /*______________________________________________________________________________________________________
    ___________________________________  PARA LISTAR POR SUS ATRIBUTOS(DATOS)______________________________________________________________
    __________________________________________________________________________________________
    _________________________________________________________________________________*/

    
    
    
    
    
  