
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
public class DetalleData 
{
     private Connection connection = null;
     private Conexion conexion;

    public DetalleData(Conexion conexion)
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
    
    
    public void guardarDetalle(Detalle detalle)
    {
        try
        {
            
            String sql = "INSERT INTO detalle (idProducto, idPedido, cantidad, total, activo) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, detalle.getProducto().getIdProducto());
            statement.setInt(2, detalle.getPedido().getIdPedido());
            statement.setInt(3, detalle.getCantidad());
            statement.setDouble(4, detalle.getTotal());
            statement.setBoolean(5, detalle.getActivo());
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
            {
                detalle.setIdDetalle(rs.getInt(1));
            } 
            else
            {
                System.out.println("No se pudo obtener el id luego de insertar un detallr");
            }
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un detalle: " + ex.getMessage());
        }
    }
    
    public List<Detalle> obtenerDetalles()
    {
        List<Detalle> detalles = new ArrayList<Detalle>();
            

        try 
        {
//            String sql = "SELECT * FROM detalle;";
            String sql = "SELECT * FROM detalle WHERE activo = 1;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Detalle detalle;
            
            while(resultSet.next())
            {
                detalle = new Detalle();
                
                detalle.setIdDetalle(resultSet.getInt("idDetalle"));
                
                Producto pro=buscarProducto(resultSet.getInt("idProducto"));
                detalle.setProducto(pro);
                
                Pedido ped=buscarPedido(resultSet.getInt("idPedido"));
                detalle.setPedido(ped);
                
                detalle.setCantidad(resultSet.getInt("cantidad"));
                detalle.setTotal(resultSet.getInt("total"));
                detalle.setActivo(resultSet.getBoolean("activo"));

                detalles.add(detalle);
            }      
            statement.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al obtener los detalle: " + ex.getMessage());
        }
        
        
        return detalles;
    }
    
    
    public Detalle buscarDetalle(int id){
    Detalle detalle=null;
    try {
            System.out.println(id);
            String sql = "SELECT * FROM detalle WHERE idDetalle =?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){

                detalle = new Detalle();
                detalle.setCantidad(resultSet.getInt("cantidad"));
                detalle.setTotal(resultSet.getInt("total"));
                detalle.setActivo(resultSet.getBoolean("activo"));
                detalle.setIdDetalle(resultSet.getInt("idDetalle"));
                Producto pro=buscarProducto(resultSet.getInt("idProducto"));
                detalle.setProducto(pro);
                Pedido ped=buscarPedido(resultSet.getInt("idPedido"));
                detalle.setPedido(ped);
    
            }      
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un detalle: " + ex.getMessage());
        }
        
        return detalle;
    }
      
 
    public Pedido buscarPedido(int id)
    {
        PedidoData pd=new PedidoData(conexion);   
        return pd.buscarPedido(id);    
    }
    
    public Producto buscarProducto(int id)
    {
        ProductoData md=new ProductoData(conexion);
        return md.buscarProducto(id);
    }
    
    
    
    //De profe trapixprog
    
    
    
   
    
    public List<Detalle> obtenerDetalle(int  idPedido){
        List<Detalle> detalles = new ArrayList<Detalle>();
            

        try {
            String sql = "SELECT * "+ "FROM detalle "+ "WHERE idPedido = ? and activo = 1;";//si 1, no 0
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,idPedido);
//            statement.setInt(2,idPedido);
         
            ResultSet resultSet = statement.executeQuery();
            Detalle detalle;
            
            while(resultSet.next()){
               detalle = new Detalle();
               
               detalle.setCantidad(resultSet.getInt("cantidad"));
               detalle.setTotal(resultSet.getDouble("total"));
               detalle.setActivo(resultSet.getBoolean("activo"));
               detalle.setIdDetalle(resultSet.getInt("idDetalle"));
               
               Producto pro = buscarProducto(resultSet.getInt("idProducto"));
               detalle.setProducto(pro);
               
               Pedido pe = buscarPedido(resultSet.getInt("idPedido"));
               detalle.setPedido(pe);
               
//               buscarMesa(resultSet.getInt("p.idMesa"));
               
                
               detalles.add(detalle);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Detalles: " + ex.getMessage());
        }
        
        
        return detalles;
    }
    
    
////    se lo puse preguntar a trapix el actualizar va en detalle
    public void actualizarDetalle(Detalle detalle)
    {
    
        try {
            
            String sql = "UPDATE detalle SET idProducto = ?, idPedido = ? , cantidad = ? , total = ? , activo = ? WHERE idDetalle = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
            statement.setInt(1, detalle.getProducto().getIdProducto());
            statement.setInt(2, detalle.getPedido().getIdPedido());
            statement.setInt(3, detalle.getCantidad());
            statement.setDouble(4, detalle.getTotal());
            statement.setBoolean(5, detalle.getActivo());
            statement.setInt(6, detalle.getIdDetalle());
            statement.executeUpdate();
            
            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error al actualizar un detalle: " + ex.getMessage());
        }
    
    }
    
}
