/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import clases.Hotel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import memory.Write;

/**
 *
 * @author user
 */
public class View extends javax.swing.JFrame {
    
    private int realNumberRoom = 0;
    private int roomType = 0;
    
    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        super.setTitle("Hotel California");
        fillRoomListByType(1);
        fillRoomListByType(2);
        fillRoomListByType(3);
        fillRoomListByType(4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        luxuryDoubleRoomList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        singleDoubleRoomList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        luxurySingleRoomList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        SingleRoomList = new javax.swing.JList<>();
        javax.swing.JButton asignar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Hotel California");

        jLabel2.setText("Sencilla");

        jLabel3.setText("Dobles De Lujo");

        jLabel4.setText("Dobles");

        jLabel5.setText("Sencillas De Lujo");

        luxuryDoubleRoomList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        luxuryDoubleRoomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                luxuryDoubleRoomListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(luxuryDoubleRoomList);

        singleDoubleRoomList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        singleDoubleRoomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                singleDoubleRoomListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(singleDoubleRoomList);

        luxurySingleRoomList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        luxurySingleRoomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                luxurySingleRoomListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(luxurySingleRoomList);

        SingleRoomList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        SingleRoomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SingleRoomListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(SingleRoomList);

        asignar.setText("Asignar");
        asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(asignar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(asignar)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reservar Habitación", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ordenar Comida", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Liberar Habitación", jPanel3);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void luxuryDoubleRoomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luxuryDoubleRoomListMouseClicked
        if( evt.getClickCount() == 1){
            JList target = (JList) evt.getSource();
            int index = target.locationToIndex( evt.getPoint() );
            fillRoomListByType(2);
            fillRoomListByType(3);
            fillRoomListByType(4);
            this.realNumberRoom = index;
            this.roomType = 1;
        }
    }//GEN-LAST:event_luxuryDoubleRoomListMouseClicked

    private void singleDoubleRoomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singleDoubleRoomListMouseClicked
        if( evt.getClickCount() == 1){
            JList target = (JList) evt.getSource();
            int index = target.locationToIndex( evt.getPoint() );
            fillRoomListByType(1);
            fillRoomListByType(3);
            fillRoomListByType(4);
            this.realNumberRoom = index;
            this.roomType = 2;
        }
    }//GEN-LAST:event_singleDoubleRoomListMouseClicked

    private void luxurySingleRoomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luxurySingleRoomListMouseClicked
        if( evt.getClickCount() == 1){
            JList target = (JList) evt.getSource();
            int index = target.locationToIndex( evt.getPoint() );
            fillRoomListByType(1);
            fillRoomListByType(2);
            fillRoomListByType(4);
            this.realNumberRoom = index;
            this.roomType = 3;
        }
    }//GEN-LAST:event_luxurySingleRoomListMouseClicked

    private void SingleRoomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SingleRoomListMouseClicked
        if( evt.getClickCount() == 1){
            JList target = (JList) evt.getSource();
            int index = target.locationToIndex( evt.getPoint() );
            fillRoomListByType(1);
            fillRoomListByType(2);
            fillRoomListByType(3);
            this.realNumberRoom = index;
            this.roomType = 4;
        }
    }//GEN-LAST:event_SingleRoomListMouseClicked

    private void asignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarActionPerformed
        boolean guardar = true;
        System.out.println("Acción del botón");
        System.out.println("Número de la habitación es: " + this.realNumberRoom );
        System.out.println("Tipo de habitación: " + this.roomType );
//        Hotel.bookRoom( this.roomType, this.realNumberRoom );
        
        boolean isDoubleRoom = false;
        if( this.roomType == 1 || this.roomType == 2 ){
            isDoubleRoom = true;
        }

        final JDialog frame = new JDialog(this, "Reservar Habitación", true);
        frame.getContentPane().add( new Booking(isDoubleRoom, roomType, realNumberRoom) );
        frame.pack();
        frame.setVisible(true);
        
        fillRoomListByType(1);
        fillRoomListByType(2);
        fillRoomListByType(3);
        fillRoomListByType(4);
        guardar(false);
    }//GEN-LAST:event_asignarActionPerformed

    
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        this.guardar(true);
    }//GEN-LAST:event_guardarActionPerformed
        
    private void guardar(boolean showMessage){
        Write write = new Write( Hotel.getHolder() );
        Thread t = new Thread( write );
        t.start();
        if( showMessage )
            JOptionPane.showMessageDialog(this, "Información Guardada.");
    }
        
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }
    
    
    
    private void fillRoomListByType(int typeRoom){
        DefaultListModel model = new DefaultListModel();
        
        int count = 0;
        for( String aux : Hotel.getAvailableRooms(typeRoom) ){
            model.add( count, aux );
            count++;
        }
        switch (typeRoom) {
            case 1:
                this.luxuryDoubleRoomList.setModel( model );
                break;
            case 2:
                this.singleDoubleRoomList.setModel( model );
                break;
            case 3:
                this.luxurySingleRoomList.setModel( model );
                break;
            case 4:
                this.SingleRoomList.setModel( model );
                break;
            default:
                break;
        }
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> SingleRoomList;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> luxuryDoubleRoomList;
    private javax.swing.JList<String> luxurySingleRoomList;
    private javax.swing.JList<String> singleDoubleRoomList;
    // End of variables declaration//GEN-END:variables
}
