/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import java.text.DecimalFormat;

/**
 *
 * @author Gonzalo
 */
public class ClabProducto {
    
    public void MostrarProductos(JTable tablaTotalProductos){
    
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        
        Tablas.TablaProductos objetoProducto = new Tablas.TablaProductos();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql ="";
        
        modelo.addColumn("id");
        modelo.addColumn("NombreProd");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        
        tablaTotalProductos.setModel(modelo);
        
        sql ="select producto.idproducto, producto.nombre, producto.precioProducto,producto.stock from producto";
        
        try {
            Statement st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                
                objetoProducto.setIdProducto(rs.getInt("idproducto"));
                objetoProducto.setNombreProducto(rs.getString("nombre"));
                objetoProducto.setPrecioProducto(rs.getDouble("precioProducto"));
                objetoProducto.setStockProducto(rs.getInt("stock"));
                
                modelo.addRow(new Object[]{objetoProducto.getIdProducto(),objetoProducto.getNombreProducto(),objetoProducto.getPrecioProducto(),objetoProducto.getStockProducto()});
                
            }
            tablaTotalProductos.setModel(modelo);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al mostrar productos," +e.toString());
        } 
        finally {
            
            objetoConexion.cerrarConexion();
        }
    
    }
     
      public void AgregarProducto (JTextField nombre, JTextField precioProducto, JTextField stock){
        
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Tablas.TablaProductos objetoProducto = new Tablas.TablaProductos();
        
        String consulta = "insert into producto (nombre,precioProducto,stock)values (?,?,?)";
        
        try {
            
            objetoProducto.setNombreProducto(nombre.getText());
            objetoProducto.setPrecioProducto(Double.valueOf(precioProducto.getText()));
            objetoProducto.setStockProducto(Integer.parseInt(stock.getText()));
            
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, objetoProducto.getNombreProducto());
            cs.setDouble(2, objetoProducto.getPrecioProducto());
            cs.setInt(3, objetoProducto.getStockProducto());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se guardó correctamente");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al guardar: " +e.toString());
        } 
        finally {
            objetoConexion.cerrarConexion();
        }
    
    
    }
      
       public void Seleccionar (JTable totalProducto, JTextField id, JTextField nombre, JTextField precioProducto, JTextField stock){
    
        int fila = totalProducto.getSelectedRow();
        try {
            if (fila>=0) {
                
                id.setText(totalProducto.getValueAt(fila, 0).toString());
                nombre.setText(totalProducto.getValueAt(fila, 1).toString());
                precioProducto.setText(totalProducto.getValueAt(fila, 2).toString());
                stock.setText(totalProducto.getValueAt(fila, 3).toString());
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al seleccionar:"+ e.toString());
        }
    
    }
       
       public void ModificarProducto (JTextField id, JTextField nombre, JTextField precioProducto, JTextField stock){
    
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Tablas.TablaProductos objetoProducto = new Tablas.TablaProductos();
        
        String consulta = "UPDATE producto SET producto.nombre=?, producto.precioProducto=?, producto.stock =? where producto.idproducto=?";
        
        try {
            objetoProducto.setIdProducto(Integer.parseInt(id.getText()));
            objetoProducto.setNombreProducto(nombre.getText());
            objetoProducto.setPrecioProducto(Double.valueOf(precioProducto.getText()));
            objetoProducto.setStockProducto(Integer.parseInt(stock.getText()));
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1, objetoProducto.getNombreProducto());
            cs.setDouble(2, objetoProducto.getPrecioProducto());
            cs.setInt(3, objetoProducto.getStockProducto());
            cs.setInt(4, objetoProducto.getIdProducto());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se pudo modificar"+ e.toString());
        } 
        
        finally {
            objetoConexion.cerrarConexion();
        }
    
    }
    
       
          public void limpiarCamposProducto (JTextField id ,JTextField nombre, JTextField precioProducto, JTextField stock){
    
        id.setText("");
        nombre.setText("");
        precioProducto.setText("");
        stock.setText("");
    
    }
          
           public void EliminarProductos (JTextField id){
    
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Tablas.TablaProductos objetoProducto = new Tablas.TablaProductos();
        
        String consulta = "delete from producto where producto.idproducto=?";
        
        try {
            
            objetoProducto.setIdProducto(Integer.parseInt(id.getText()));
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, objetoProducto.getIdProducto());
            
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