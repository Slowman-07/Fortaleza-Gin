/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package igu;

import Crud.ClabCliente;


/**
 *
 * @author Gonzalo
 */
public class FormClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormClientes
     */
    public FormClientes() {
        initComponents();
        Crud.ClabCliente objetoCliente = new Crud.ClabCliente();
        objetoCliente.MostrarClientes(tbclientes);
        txtidcliente.setEnabled(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombrecliente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtapellidocliente = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdomiciliocliente = new javax.swing.JTextField();
        txtcorreocliente = new javax.swing.JTextField();
        btnlimpiarcampos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        btnguardarclientes = new javax.swing.JButton();
        btnmodificarclientes = new javax.swing.JButton();
        btneliminarclientes = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Id:");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos:");

        jButton2.setText("Guardar");

        jButton3.setText("Modificar");

        jButton4.setText("Eliminar");

        jLabel4.setText("Correo:");

        btnlimpiarcampos.setText("Limpiar");
        btnlimpiarcampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarcamposActionPerformed(evt);
            }
        });

        jLabel5.setText("Domicilio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(88, 88, 88)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellidocliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdomiciliocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcorreocliente, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlimpiarcampos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidcliente)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtapellidocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdomiciliocliente)
                    .addComponent(txtcorreocliente)
                    .addComponent(btnlimpiarcampos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addGap(243, 243, 243)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbclientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbclientes);

        btnguardarclientes.setText("Guardar");
        btnguardarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarclientesActionPerformed(evt);
            }
        });

        btnmodificarclientes.setText("Modificar");
        btnmodificarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarclientesActionPerformed(evt);
            }
        });

        btneliminarclientes.setText("Eliminar");
        btneliminarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarclientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnguardarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(btnmodificarclientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneliminarclientes))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlimpiarcamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarcamposActionPerformed
        Crud.ClabCliente objetoCliente = new ClabCliente();
        objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrecliente, txtapellidocliente, txtdomiciliocliente, txtcorreocliente);
    }//GEN-LAST:event_btnlimpiarcamposActionPerformed

    private void btnguardarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarclientesActionPerformed
        Crud.ClabCliente objetoCliente = new ClabCliente();
        objetoCliente.AgregarCliente(txtnombrecliente, txtapellidocliente, txtdomiciliocliente, txtcorreocliente);
        objetoCliente.MostrarClientes(tbclientes);
        objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrecliente, txtapellidocliente, txtdomiciliocliente, txtcorreocliente);
    }//GEN-LAST:event_btnguardarclientesActionPerformed

    private void tbclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbclientesMouseClicked
        Crud.ClabCliente objetoCliente = new ClabCliente();
        objetoCliente.Seleccionar(tbclientes, txtidcliente, txtnombrecliente, txtapellidocliente, txtdomiciliocliente, txtcorreocliente);
    }//GEN-LAST:event_tbclientesMouseClicked

    private void btnmodificarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarclientesActionPerformed
        Crud.ClabCliente objetoCliente = new ClabCliente();
        objetoCliente.ModificarCliente(txtidcliente, txtnombrecliente, txtapellidocliente, txtdomiciliocliente, txtcorreocliente);
        objetoCliente.MostrarClientes(tbclientes);
        objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrecliente, txtapellidocliente, txtdomiciliocliente, txtcorreocliente);
    }//GEN-LAST:event_btnmodificarclientesActionPerformed

    private void btneliminarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarclientesActionPerformed
        Crud.ClabCliente objetoCliente = new ClabCliente();
        objetoCliente.EliminarClientes(txtidcliente);
        objetoCliente.MostrarClientes(tbclientes);
        objetoCliente.limpiarCamposClientes(txtidcliente, txtnombrecliente, txtapellidocliente, txtdomiciliocliente, txtcorreocliente);
    }//GEN-LAST:event_btneliminarclientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminarclientes;
    private javax.swing.JButton btnguardarclientes;
    private javax.swing.JButton btnlimpiarcampos;
    private javax.swing.JButton btnmodificarclientes;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtapellidocliente;
    private javax.swing.JTextField txtcorreocliente;
    private javax.swing.JTextField txtdomiciliocliente;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnombrecliente;
    // End of variables declaration//GEN-END:variables
}
