package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservaData 
{
    private Connection connection = null;
    private Conexion conexion;

    public ReservaData (Conexion conexion)
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
    
    
   public void guardarReserva(Reserva reserva)
   {
        try
        {
            
            String sql = "INSERT INTO reserva (idCliente, idMesa, hora, fecha, activo) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, reserva.getCliente().getIdCliente());
            statement.setInt(2, reserva.getMesa().getIdMesa());
            statement.setString(3, reserva.getHora());
            statement.setDate(4, (Date) reserva.getFecha());
            statement.setBoolean(5, reserva.getActivo());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
            {
                reserva.setIdReserva(rs.getInt(1));
            }
            else 
            {
                System.out.println("No se pudo obtener el id luego de insertar un reserva");
            }
            statement.close();
    
        }
        catch (SQLException ex)
        {
            System.out.println("Error al insertar una reserva: " + ex.getMessage());
        }
    }
    
    public List<Reserva> obtenerReservas()
    {
        List<Reserva> reservas = new ArrayList<Reserva>();
            

        try
        {
            String sql = "SELECT * FROM reserva;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Reserva reserva;
            
            while(resultSet.next())
            {
                reserva = new Reserva();
                
                reserva.setIdReserva(resultSet.getInt("idReserva"));
                
                Cliente c=buscarCliente(resultSet.getInt("idCliente"));
                reserva.setCliente(c);
                
                Mesa m=buscarMesa(resultSet.getInt("idMesa"));
                reserva.setMesa(m);
                
                reserva.setHora(resultSet.getString("hora"));                
                reserva.setFecha(resultSet.getDate("fecha"));
                reserva.setActivo(resultSet.getBoolean("activo"));
             

                reservas.add(reserva);
            }      
            statement.close();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al obtener los reserva: " + ex.getMessage());
        }
                
        return reservas;
    }
    public void borrarReserva(int id)
    {
        try
        { 
            String sql = "DELETE FROM reserva WHERE idReserva =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();  
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un reserva: " + ex.getMessage());
        }            
    }
    
    public void actualizarReserva(Reserva reserva)
    {
      try
        {
            
            String sql = "UPDATE reserva SET idCliente = ?, idMesa = ? , hora = ? , fecha = ? , activo =? WHERE idReserva = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, reserva.getCliente().getIdCliente());
            statement.setInt(2, reserva.getMesa().getIdMesa());
            statement.setString(3, reserva.getHora());
            statement.setDate(4, (Date) reserva.getFecha());
            statement.setBoolean(5, reserva.getActivo());
            statement.setInt(6, reserva.getIdReserva());
            statement.executeUpdate();
            
          
            statement.close();
    
        }
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un reserva: " + ex.getMessage());
        }
    
    }
    public Reserva buscarReserva(int id)
    {
    Reserva reserva=null;
    
        try 
        {         
            String sql = "SELECT * FROM reserva WHERE idReserva =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next())
            {
                reserva = new Reserva();
                
                reserva.setIdReserva(resultSet.getInt("idReserva"));
                
                Cliente c=buscarCliente(resultSet.getInt("idCliente"));
                reserva.setCliente(c);
                
                Mesa m=buscarMesa(resultSet.getInt("idMesa"));
                reserva.setMesa(m);
                
                reserva.setHora(resultSet.getString("hora"));                
                reserva.setFecha(resultSet.getDate("fecha"));
                reserva.setActivo(resultSet.getBoolean("activo"));
      
            }      
            statement.close();

        }
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un reserva: " + ex.getMessage());
        } 
        return reserva;
    } 
    public Cliente buscarCliente(int id)
    {   
        ClienteData cd=new ClienteData(conexion);     
        return cd.buscarCliente(id);     
    }
    public Mesa buscarMesa(int id)
    {          
        MesaData md=new MesaData(conexion);        
        return md.buscarMesa(id);       
    } 
//    ____________________________________NUEVO_____________________________________
    public List<Reserva> obtenerReservasXCliente(int id)
    {
        List<Reserva> reservas = new ArrayList<Reserva>();
        try 
        {
            String sql = "SELECT * FROM reserva WHERE idCLiente = ? and activo=1;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            
            while(resultSet.next())
            {
                reserva = new Reserva();
                
                reserva.setIdReserva(resultSet.getInt("idReserva"));
                
                Cliente c=buscarCliente(resultSet.getInt("idCliente"));
                reserva.setCliente(c);
                
                Mesa m=buscarMesa(resultSet.getInt("idMesa"));
                reserva.setMesa(m);
                
                reserva.setHora(resultSet.getString("hora"));                
                reserva.setFecha(resultSet.getDate("fecha"));
                reserva.setActivo(resultSet.getBoolean("activo"));
               
                reservas.add(reserva);
            }      
            statement.close();
        }catch (SQLException ex) {
            System.out.println("Error al obtener los reservas: " + ex.getMessage());
        }    
        return reservas;
    }
  }


    

