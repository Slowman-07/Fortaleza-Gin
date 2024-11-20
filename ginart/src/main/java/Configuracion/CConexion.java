package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class CConexion {
    
    Connection conectar = null;
    
    String usuario="root";
    String contrasenia="Stargate#7";
    String bd="ginart";
    String ip="localhost";
    String puerto="3306";
    
    String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null,"Conexion correcta a BD");
        } 
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Conexion fallida: "+e.getMessage());
        }
    
    return conectar;
        
    }
    
    public void cerrarConexion() {
        
        try {
            if (conectar!= null && !conectar.isClosed()) {
                conectar.close();
                }
                
                //JOptionPane.showMessageDialog(null,"Se cerro la conexion");
                
            }catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"La conexion no pudo cerrarse");
            
            }
                
    }

}

//conectar!=null && !conectar.isClosed()) {
                //conectar.close();
                
                