
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
public class ProductoData 
{
     private Connection connection = null;
     private Conexion conexion;

    public ProductoData(Conexion conexion)
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
    
    
    public void guardarProducto(Producto producto)
    {
        try
        {
            
            String sql = "INSERT INTO producto (idCategoria, codigo, nombre, cantidad, precio, activo) VALUES ( ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, producto.getCategoria().getIdCategoria());
            statement.setInt(2, producto.getCodigo());
            statement.setString(3, producto.getNombre());
            statement.setInt(4, producto.getCantidad());
            statement.setDouble(5, producto.getPrecio());
            statement.setBoolean(6, producto.getActivo());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
            {
                producto.setIdProducto(rs.getInt(1));
            } 
            else
            {
                System.out.println("No se pudo obtener el id luego de insertar un producto");
            }
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un producto: " + ex.getMessage());
        }
    }
    
    public List<Producto> obtenerProductos()
    {
        List<Producto> productos = new ArrayList<Producto>();
            

        try 
        {
            String sql = "SELECT * FROM producto;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            
            while(resultSet.next())
            {
                producto = new Producto();
                
                producto.setIdProducto(resultSet.getInt("idProducto"));
                
                Categoria c=buscarCategoria(resultSet.getInt("idCategoria"));
                producto.setCategoria(c);
                
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setActivo(resultSet.getBoolean("activo"));
               
                productos.add(producto);
            }      
            statement.close();
        }catch (SQLException ex) {
            System.out.println("Error al obtener los productos: " + ex.getMessage());
        }    
        return productos;
    }
    public void borrarProducto(int id){
    try{           
//            String sql = "DELETE FROM producto WHERE idProducto =?;";
            String sql = "UPDATE producto SET  activo =0 WHERE idProducto = ?;";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
                       
            statement.executeUpdate();       
            statement.close();
    
        }catch (SQLException ex) {
            System.out.println("Error al eliminar un producto: " + ex.getMessage());
        }
    }
    public void actualizarProducto(Producto producto)
    {
        try 
        {
             System.out.println("Error" );
            String sql = "UPDATE producto SET idCategoria = ?, codigo = ? , nombre = ? , cantidad = ? , precio = ? ,  activo =? WHERE idProducto = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, producto.getCategoria().getIdCategoria());
            statement.setInt(2, producto.getCodigo());
            statement.setString(3, producto.getNombre());
            statement.setInt(4, producto.getCantidad());
            statement.setDouble(5, producto.getPrecio());
            statement.setBoolean(6, producto.getActivo());
            statement.setInt(7, producto.getIdProducto());
          
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex)
        {
            System.out.println("Error al insertar un producto: " + ex.getMessage());
        }
    
    }
    
    public Producto buscarProducto(int id)
    {
    Producto producto=null;
    try
    {
            
            String sql = "SELECT * FROM producto WHERE idProducto =? and activo = 1;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                producto = new Producto();
            
                
                producto.setIdProducto(resultSet.getInt("IdProducto"));
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setActivo(resultSet.getBoolean("activo"));
                Categoria c = buscarCategoria(resultSet.getInt("idCategoria"));
                producto.setCategoria(c);
            }      
            statement.close();

        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un producto: " + ex.getMessage());
        }
        
        return producto;
    }
    public Categoria buscarCategoria(int id){
    
        CategoriaData cd=new CategoriaData(conexion);
        return cd.buscarCategoria(id);
    
    }
    
//    public Producto buscarProductoXCategodia(int id)
//    {
//    Producto producto=null;
//    try
//    {
//            
//            String sql = "SELECT * FROM producto WHERE idCategoria =? and activo=1;";
//
//            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            statement.setInt(1, id);
//           
//            
//            ResultSet resultSet=statement.executeQuery();
//            
//            while(resultSet.next())
//            {
//                producto = new Producto();
//            
//                Categoria c = buscarCategoria(resultSet.getInt("idCategoria"));
//                producto.setCategoria(c);
//                
//                producto.setCodigo(resultSet.getInt("codigo"));
//                producto.setNombre(resultSet.getString("nombre"));
//                producto.setCantidad(resultSet.getInt("cantidad"));
//                producto.setPrecio(resultSet.getDouble("precio"));
//                producto.setActivo(resultSet.getBoolean("activo"));
//            }      
//            statement.close();
//
//        } 
//        catch (SQLException ex)
//        {
//            System.out.println("Error al insertar un producto: " + ex.getMessage());
//        }
//        
//        return producto;
//    }
//    
     public List<Producto> obtenerProductosXCategoria(int id)
    {
        List<Producto> productos = new ArrayList<Producto>();
        try 
        {
            String sql = "SELECT * FROM producto WHERE idCategoria = ? and activo=1;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            
            while(resultSet.next())
            {
                producto = new Producto();
                
                producto.setIdProducto(resultSet.getInt("idProducto"));
                
                Categoria c=buscarCategoria(resultSet.getInt("idCategoria"));
                producto.setCategoria(c);
                
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setActivo(resultSet.getBoolean("activo"));
               
                productos.add(producto);
            }      
            statement.close();
        }catch (SQLException ex) {
            System.out.println("Error al obtener los productos: " + ex.getMessage());
        }    
        return productos;
    }
}
    
