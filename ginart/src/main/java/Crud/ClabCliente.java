package Crud;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author blood
 */
public class ClabCliente {
    
    
    public void MostrarClientes(JTable tablaTotalClientes){
    
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        
        Tablas.TablaCliente objetoCliente = new Tablas.TablaCliente();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql ="";
        
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Correo");
        
        
        tablaTotalClientes.setModel(modelo);
        
        sql ="select cliente.idcliente,cliente.nombre,cliente.apellido,cliente.domicilio,cliente.correo from cliente";
        
        try {
            Statement st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                
                objetoCliente.setIdCliente(rs.getInt("idcliente"));
                objetoCliente.setNombre(rs.getString("nombre"));
                objetoCliente.setApellido(rs.getString("apellido"));
                objetoCliente.setDomicilio(rs.getString("domicilio"));
                objetoCliente.setCorreo(rs.getString("correo"));
                
                
                modelo.addRow(new Object[]{objetoCliente.getIdCliente(),objetoCliente.getNombre(),objetoCliente.getApellido(),objetoCliente.getDomicilio(),objetoCliente.getCorreo()});
                
            }
            tablaTotalClientes.setModel(modelo);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al mostrar usuarios," +e.toString());
        } 
        finally {
            
            objetoConexion.cerrarConexion();
        }
    
    }
    
    
    public void AgregarCliente (JTextField nombre, JTextField apellido, JTextField domicilio, JTextField correo){
        
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Tablas.TablaCliente objetoCliente = new Tablas.TablaCliente();
        
        String consulta = "insert into cliente (nombre,apellido,domicilio,correo) values (?,?,?,?);";
        
        try {
            
            objetoCliente.setNombre(nombre.getText());
            objetoCliente.setApellido(apellido.getText());
            objetoCliente.setDomicilio(domicilio.getText());
            objetoCliente.setCorreo(correo.getText());
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, objetoCliente.getNombre());
            cs.setString(2, objetoCliente.getApellido());
            cs.setString(3, objetoCliente.getDomicilio());
            cs.setString(4, objetoCliente.getCorreo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se guardó correctamente");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al guardar: " +e.toString());
        } 
        finally {
            objetoConexion.cerrarConexion();
        }
    
    
    }
    
    
    public void Seleccionar (JTable totalcliente, JTextField id, JTextField nombre, JTextField apellido, JTextField domicilio, JTextField correo){
    
        int fila = totalcliente.getSelectedRow();
        try {
            if (fila>=0) {
                
                id.setText(totalcliente.getValueAt(fila, 0).toString());
                nombre.setText(totalcliente.getValueAt(fila, 1).toString());
                apellido.setText(totalcliente.getValueAt(fila, 2).toString());
                domicilio.setText(totalcliente.getValueAt(fila, 3).toString());
                correo.setText(totalcliente.getValueAt(fila, 4).toString());
                
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al seleccionar:"+ e.toString());
        }
    
    }
    
    
    public void ModificarCliente (JTextField id, JTextField nombre, JTextField apellido, JTextField domicilio, JTextField correo){
    
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Tablas.TablaCliente objetoCliente = new Tablas.TablaCliente();
        
        String consulta = "UPDATE cliente SET cliente.nombre=?, cliente.apellido=?, cliente.domicilio=?, cliente.correo=? where cliente.idcliente=?";
        
        try {
            objetoCliente.setIdCliente(Integer.parseInt(id.getText()));
            objetoCliente.setNombre(nombre.getText());
            objetoCliente.setApellido(apellido.getText());
            objetoCliente.setDomicilio(domicilio.getText());
            objetoCliente.setCorreo(correo.getText());
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1, objetoCliente.getNombre());
            cs.setString(2, objetoCliente.getApellido());
            cs.setString(3, objetoCliente.getDomicilio());
            cs.setString(4, objetoCliente.getCorreo());
            cs.setInt(5, objetoCliente.getIdCliente());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al modificar"+ e.toString());
        } 
        
        finally {
            objetoConexion.cerrarConexion();
        }
    
    }
    
    public void limpiarCamposClientes (JTextField id ,JTextField nombre, JTextField apellido, JTextField domicilio, JTextField correo){
    
        id.setText("");
        nombre.setText("");
        apellido.setText("");
        domicilio.setText("");
        correo.setText("");
    
    }
    
    public void EliminarClientes (JTextField id){
    
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Tablas.TablaCliente objetoCliente = new Tablas.TablaCliente();
        
        String consulta = "delete from cliente where cliente.idcliente=?;";
        
        try {
            
            objetoCliente.setIdCliente(Integer.parseInt(id.getText()));
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, objetoCliente.getIdCliente());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No se pudo eliminar"+ e.toString());
        } 
        finally {
            objetoConexion.cerrarConexion();
        }
    
    }
    
    
    
    
}
