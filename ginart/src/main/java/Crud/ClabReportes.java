/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gonzalo
 */
public class ClabReportes {
    
    public void BuscarFacturaMostrarDatosCliente(JTextField numeroFactura, JLabel numeroFacturaEncontrado, JLabel fechaFacturaEntrado, JLabel nombrecliente,JLabel apellido,JLabel domicilio){
    
        Configuracion.CConexion objetoCConexion = new Configuracion.CConexion();
        
        try {
            
            String consulta="SELECT factura.idfactura, factura.fechaFactura, cliente.nombre,cliente.apellido,cliente.domicilio from factura INNER JOIN cliente ON cliente.idcliente = factura.fkcliente WHERE factura.idfactura = ?;";
                            
            
            PreparedStatement ps = objetoCConexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, Integer.parseInt(numeroFactura.getText()));
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                numeroFacturaEncontrado.setText(String.valueOf(rs.getInt("idfactura")));
                fechaFacturaEntrado.setText(rs.getDate("fechaFactura").toString());
                nombrecliente.setText(rs.getString("nombre"));
                apellido.setText(rs.getString("apellido"));
                domicilio.setText(rs.getString("domicilio"));
            }
            
            else
            {
                numeroFacturaEncontrado.setText("");
                fechaFacturaEntrado.setText("");
                nombrecliente.setText("");
                apellido.setText("");
                domicilio.setText("");
            
                JOptionPane.showMessageDialog(null, "No se encontró la factura");
            
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la factura:"+ e.toString());
        } 
        finally {
            objetoCConexion.cerrarConexion();
        }
    
    }
    
    public void BuscarFacturaMostrarDatosProductos(JTextField numeroFactura, JTable tablaProductos, JLabel IVA, JLabel total){
    
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("N.Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("PrecioVenta");
        modelo.addColumn("Subtotal");
        
        tablaProductos.setModel(modelo);
        
        try {
            
            String consulta = "Select producto.nombre, detalle.cantidad, detalle.precioVenta from detalle " +
                                "INNER JOIN factura ON factura.idfactura = detalle.fkfactura " +
                                "INNER JOIN producto ON producto.idproducto = detalle.fkproducto " +
                                "Where factura.idfactura= ?;";
            
            
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, Integer.parseInt(numeroFactura.getText()));
            
            ResultSet rs = ps.executeQuery();
            
            double totalFactura =0.0;
            double valorIVA = 0.18;
            
            DecimalFormat formato = new DecimalFormat("#.##");
            
            while (rs.next()) {

                String nombreProducto = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                double precioVenta = rs.getDouble("precioVenta");
                double subtotal = cantidad* precioVenta;
                
                totalFactura = Double.parseDouble(formato.format(totalFactura+subtotal));
                
                modelo.addRow(new Object[]{nombreProducto,cantidad,precioVenta,subtotal});     
            }
            
            
            double totalIVA = Double.parseDouble(formato.format(totalFactura*valorIVA));
            
            IVA.setText(String.valueOf(totalIVA));
            
            total.setText(String.valueOf(totalFactura));
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al mostrar los productos de la factura: "+ e.toString());
        } 
        finally {
            
            objetoConexion.cerrarConexion();
        }

    }
    
    
    public void mostrarTotalVentaPorFecha (JDateChooser desde, JDateChooser hasta, JTable tablaVentas, JLabel totalGeneral){
        
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idFactura");
        modelo.addColumn("FechaFactura");
        modelo.addColumn("NProducto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("PrecioVenta");
        modelo.addColumn("Subtotal");
        
        tablaVentas.setModel(modelo);
        
        try {
            
            String consulta = "Select factura.idfactura, factura.fechaFactura, producto.nombre, detalle.cantidad,detalle.precioVenta from detalle " +
                                "INNER JOIN factura ON factura.idfactura = detalle.fkfactura " +
                                "INNER JOIN producto ON producto.idproducto = detalle.fkproducto " +
                                "Where factura.fechaFactura Between ? AND ?;";
            
            
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            
            java.util.Date fechaDesde = desde.getDate();
            java.util.Date fechaHasta = hasta.getDate();
            
            java.sql.Date fechaDesdeSQL = new java.sql.Date(fechaDesde.getTime());
            java.sql.Date fechaHastaSQL = new java.sql.Date(fechaHasta.getTime());
            
            ps.setDate(1, fechaDesdeSQL);
            ps.setDate(2, fechaHastaSQL);
            
            ResultSet rs = ps.executeQuery();
            
            double totalFactura = 0.0;
            
            DecimalFormat formato = new DecimalFormat("#.##");
            
            while (rs.next()) {                
                
                int idFactura = rs.getInt("idFactura");
                Date fechaFactura = rs.getDate("fechaFactura");
                String nombreProducto = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                double precioVenta  = rs.getDouble("precioVenta");
                
                double subtotal = cantidad* precioVenta;
                
                totalFactura = Double.parseDouble(formato.format(totalFactura+subtotal));
                
                modelo.addRow(new Object[] {idFactura,fechaFactura, nombreProducto, cantidad,precioVenta,subtotal});  
            }
            
            totalGeneral.setText(String.valueOf(totalFactura));
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar los ingresos por fechas: "+ e.toString());
        }
        finally {
            objetoConexion.cerrarConexion();
        }
        
        for (int column = 0; column < tablaVentas.getColumnCount(); column++) {
            
            Class<?> columClass = tablaVentas.getColumnClass(column);
            tablaVentas.setDefaultEditor(columClass, null);
        }
                

    
    }
    
    
    
}
