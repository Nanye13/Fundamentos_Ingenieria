/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 *
 * 
 */
package Ventanas;

import claseConectar.conectar;
import java.awt.JobAttributes;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nancy
 */
public class Productos_z extends javax.swing.JInternalFrame {
    DefaultTableModel tabla;
    

    /** Creates new form Productos */
    public Productos_z() {
        initComponents();
        
        
      
        cargarlistaproductos("");
        
    }
     public void calcular()
    {
        String pre;
        String can;
        double igv=0;
        double total=0;
        double subtotal=0;
        double precio;
        int cantidad;
        double imp=0.0;
        
            /*can=Integer.parseInt(cant);
            imp=pre*can;
            dato[4]=Float.toString(imp);*/
        
        for(int i=0;i<venta.tbdet.getRowCount();i++)
        {
            pre=venta.tbdet.getValueAt(i, 2).toString();
            can=venta.tbdet.getValueAt(i, 3).toString();
            precio=Double.parseDouble(pre);
            cantidad=Integer.parseInt(can);
            imp=precio*cantidad;
            subtotal=subtotal+imp;
            igv=subtotal*0.18;
            total=subtotal+igv;
            // txtcod.setText(""+Math.rint(c*100)/100)
            venta.tbdet.setValueAt(Math.rint(imp*100)/100, i, 4);
            
        }
        venta.txtsubtotal.setText(Double.toString(subtotal));
        //venta.txtigv.setText(""+Math.rint(igv*100)/100);
        venta.txttotal.setText(""+Math.rint(total*100)/100);
        
            
    }
     String comparar(String cod)
    {
        String cant="";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM producto WHERE cod_pro='"+cod+"'");
            while(rs.next())
            {
                cant=rs.getString(4);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Productos_z.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
        
    }
  
    void cargarlistaproductos(String dato){
        String [] Titulo = {"Codigo","Descripcion","Precio","Stock"};
        tabla=new DefaultTableModel(null,Titulo);
    String []Registro= new String[4];
    String mostrar="SELECT * FROM producto WHERE CONCAT (cod_pro,'',descripcion) LIKE '%"+dato+"%'"; 
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs =st.executeQuery(mostrar);
            while(rs.next())
            {
                Registro[0]=rs.getString("cod_pro");
                Registro[1]=rs.getString("Descripcion");
                Registro[2]=rs.getString("precio");
                Registro[3]=rs.getString("Stock");
                
                tabla.addRow(Registro);
            }
            tbprod.setModel(tabla);
        } catch (SQLException ex) {
            Logger.getLogger(Productos_z.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviarpro = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbprod = new javax.swing.JTable();
        txtprod = new javax.swing.JTextField();
        btnmostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        mnenviarpro.setText("Enviar a Factura");
        mnenviarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarproActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviarpro);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PRODUCTOS");

        tbprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprod.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tbprod);

        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });

        btnmostrar.setText("Mostrar todo");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar Productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnmostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnmostrar)
                    .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
// TODO add your handling code here:
    cargarlistaproductos("");
}//GEN-LAST:event_btnmostrarActionPerformed

private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
// TODO add your handling code here:
    cargarlistaproductos(txtprod.getText());
}//GEN-LAST:event_txtprodKeyReleased

private void mnenviarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarproActionPerformed
// TODO add your handling code here:
   
    try {
        
         DefaultTableModel tabladet = (DefaultTableModel) venta.tbdet.getModel();
         String[]  dato=new String[5];
   
         int  fila = tbprod.getSelectedRow();
       
         if(fila==-1)
         {
             JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
         }
         
         else
          {
          String codins=tbprod.getValueAt(fila, 0).toString();
          String desins=tbprod.getValueAt(fila, 1).toString();
          String preins=tbprod.getValueAt(fila, 2).toString();
          int c=0;
          int j=0;
           String  cant=JOptionPane.showInputDialog("ingrese cantidad");
         if((cant.equals("")) || (cant.equals("0")))
         {
             JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
         }
         else
         {
             
             int canting=Integer.parseInt(cant);
             int comp=Integer.parseInt(comparar(codins));
             if(canting>comp)
             {
                 JOptionPane.showMessageDialog(this,"Ud. no cuenta con el stock apropiado");
             }
             else
             {
                      for(int i=0;i<venta.tbdet.getRowCount();i++)
          {
            Object com=venta.tbdet.getValueAt(i,0);
            if(codins.equals(com))
            {
                j=i;
                venta.tbdet.setValueAt(cant, i, 3);
                c=c+1;
       
            }
   
          }
          if(c==0)
          {
           
            
      
            dato[0]=codins;
            dato[1]=desins;
            dato[2]=preins;
            dato[3]=cant;
            
            tabladet.addRow(dato);
        
            venta.tbdet.setModel(tabladet);
            calcular();
            //fac.calcular();
            
        }
             }
            //  fac.calcular();
         }
        
    }
      
    
    } catch (Exception e) {
    }
    
}//GEN-LAST:event_mnenviarproActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mnenviarpro;
    private javax.swing.JTable tbprod;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn = cc.conexion();
//Factura fac= new Factura();

}
