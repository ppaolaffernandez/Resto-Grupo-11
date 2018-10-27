package Modelo;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
public class PedidoData  
{
     private Connection connection = null;
     private Conexion conexion;

    public PedidoData(Conexion conexion)
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
    public void guardarPedido(Pedido pedido)
    {
        try
        {  
            String sql = "INSERT INTO pedido (idMesero, idMesa, fecha, hora, activo, pendiente, entregado) VALUES ( ? , ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, pedido.getMesero().getIdMesero());
            statement.setInt(2, pedido.getMesa().getIdMesa());
            statement.setDate(3, (Date) pedido.getFecha());
            statement.setString(4, pedido.getHora());
            statement.setBoolean(5, pedido.getActivo());
            statement.setBoolean(6, pedido.getPendiente());
            statement.setBoolean(7, pedido.getEntregado());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
            {
                pedido.setIdPedido(rs.getInt(1));
            }
            else
            {
                System.out.println("No se pudo obtener el id luego de insertar un pedido");
            }
            statement.close();
    
        }
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un pedido: " + ex.getMessage());
        }
    }
    
    public List<Pedido> obtenerPedidos()
    {
        List<Pedido> pedidos = new ArrayList<Pedido>();
            
        try
        {
            String sql = "SELECT * FROM pedido;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Pedido pedido;
            
            while(resultSet.next()) 
            {
                pedido = new Pedido();
                pedido.setIdPedido(resultSet.getInt("idPedido"));
                
                Mesero m=buscarMesero(resultSet.getInt("idMesero"));
                pedido.setMesero(m);
                
                Mesa mesa=buscarMesa(resultSet.getInt("idMesa"));
                pedido.setMesa(mesa);
                
                pedido.setFecha(resultSet.getDate("fecha"));
                pedido.setHora(resultSet.getString("hora"));             
                pedido.setActivo(resultSet.getBoolean("activo"));
                pedido.setPendiente(resultSet.getBoolean("pendiente"));
                pedido.setEntregado(resultSet.getBoolean("entregado"));

                pedidos.add(pedido);
            }      
            statement.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error al obtener los pedidos: " + ex.getMessage());
        } 
        return pedidos;
    }
    public void borrarPedido(int id)
    {
        try
        {  
            String sql = "DELETE FROM pedido WHERE idPedido =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
                      
            statement.executeUpdate();  
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un pedido: " + ex.getMessage());
        } 
    }
    
    public void actualizarPedido(Pedido pedido)
    {
        try
        {
            
            String sql = "UPDATE pedido SET idMesa = ?, idMesero = ?, fecha = ?, hora = ?, activo =?, pendiente =?, entregado =? WHERE idPedido = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, pedido.getMesa().getIdMesa());
            statement.setInt(2, pedido.getMesero().getIdMesero());
            statement.setDate(3, (Date) pedido.getFecha());
            statement.setString(4, pedido.getHora());        
            statement.setBoolean(5, pedido.getActivo());
            statement.setBoolean(6, pedido.getPendiente());
            statement.setBoolean(7, pedido.getEntregado());
            statement.executeUpdate();
            
          
            statement.close();
    
        }
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un pedido: " + ex.getMessage());
        }
    
    }
    public Pedido buscarPedido(int id)
    {
    Pedido pedido=null;
        try 
        {
            
            String sql = "SELECT * FROM pedido WHERE idPedido =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
 
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                pedido = new Pedido();
                pedido.setIdPedido(resultSet.getInt("idPedido"));
                
                Mesa mesa=buscarMesa(resultSet.getInt("idMesa"));
                pedido.setMesa(mesa);
                
                Mesero meser=buscarMesero(resultSet.getInt("idMesero"));
                pedido.setMesero(meser);
                                
                pedido.setFecha(resultSet.getDate("fecha"));
                pedido.setHora(resultSet.getString("hora"));
                pedido.setActivo(resultSet.getBoolean("activo"));
                pedido.setPendiente(resultSet.getBoolean("pendiente"));
                pedido.setEntregado(resultSet.getBoolean("entregado"));
                
            }      
            statement.close();            
                            
        }   
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un pedido: " + ex.getMessage());
        } 
        return pedido;
    }
   
    public Mesero buscarMesero(int id){    
        MeseroData mesed=new MeseroData(conexion);        
        return mesed.buscarMesero(id);     
    }
    
    public Mesa buscarMesa(int id){
        MesaData mesad=new MesaData(conexion);
        return mesad.buscarMesa(id); 
    } 
    
//nuevo de trapix
    public Pedido buscarPedidoMesa(int idMesa)
    {
    Pedido pedido=null;
        try 
        {
            
            String sql = "SELECT * FROM pedido WHERE idMesa =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idMesa);
 
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                pedido = new Pedido();
                pedido.setIdPedido(resultSet.getInt("idPedido"));
                
                Mesa mesa=buscarMesa(resultSet.getInt("idMesa"));
                pedido.setMesa(mesa);
                
                Mesero meser=buscarMesero(resultSet.getInt("idMesero"));
                pedido.setMesero(meser);
                                
                pedido.setFecha(resultSet.getDate("fecha"));
                pedido.setHora(resultSet.getString("hora"));
                pedido.setActivo(resultSet.getBoolean("activo"));
                pedido.setPendiente(resultSet.getBoolean("pendiente"));
                pedido.setEntregado(resultSet.getBoolean("entregado"));
                
            }      
            statement.close();            
                            
        }   
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un pedido: " + ex.getMessage());
        } 
        return pedido;
    }
   
}

