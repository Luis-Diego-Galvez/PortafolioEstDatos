/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formsejercicio02;

import Classes.Truck;
import Classes.Camionero;
import Classes.Entrega;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author LuisD
 */
public class CaminoEntrega extends javax.swing.JFrame {

    //Variables
    public Truck Camion = new Truck(0,0,0,0,false);
    Thread hilo;
    Object obj = new Object();
    Date fecha = new Date();
    public int distancia = 0;
    Format formato = new SimpleDateFormat("dd/MM/yyyy");
    public double ganancias = 0;
    public static Camionero camionero = new Camionero("Benito", 300, 0);
    public Entrega ruta = new Entrega(ganancias, "", fecha);
    Entregas Registro = new Entregas();
    /**
     * Creates new form CaminoEntrega
     */
    public void Estacionar() {
        Camion.setVelocidad(0);
        lblEstado.setText("Estacionado");
        sldVel.setEnabled(true);
        btnChargeGas.setEnabled(true);
        if (pbDestino.getValue() <= 0) {
            btnGestionc.setEnabled(true);
            btnProgramar.setEnabled(true);
            cbbDestino.setEnabled(true);
            btnChargeProd.setEnabled(true);
        }
    }
    
    public void ActualizarPantalla() {
        lblVel.setText(String.valueOf(sldVel.getValue()) + " km/h");
        lblGanancias.setText("$" + String.format("%.2f",ganancias));
        lblCostos.setText("$" + String.format("%.2f",camionero.getGastos()));
        pbPeso.setValue((int) Math.round(Camion.getPeso()));
        pbGas.setValue((int) Math.round(Camion.getGas()));
    }
    
    
    public void IniciarCamion() {
        if (hilo == null) {
            hilo = new ThreadCarga();
            hilo.start();
        }
    }
    
    public void DetenerCamion() {
        btnChargeGas.setEnabled(true);
        synchronized(obj) {
            obj.notify();
        }
    }
    
    class ThreadCarga extends Thread {
        @Override
        public void run() {
            pbDestino.setMaximum(distancia);
            double kilomt = Camion.getVelocidad()/Camion.getPeso();
            int km = (int) Math.round(kilomt) + 1;
            int kmgas = 0;
            for (int i = pbDestino.getValue(); i <= distancia; i += km) {
                kmgas   +=  km;
                if (kmgas >= 12) {
                    Camion.setGas(Camion.getGas() - 1);
                    kmgas = 0;
                }
                Camion.setRecorrido(i);
                pbDestino.setValue(i);
                synchronized(obj) {
                    if (btnStartStop.getText() != "Detener Camión" || !Camion.getStatus() || Camion.getGas() <= 0) {
                        JOptionPane.showMessageDialog(null,"Te has quedado sin combustible, recarga unos galones para continuar", "Fuera de Combustible", JOptionPane.WARNING_MESSAGE);
                        btnStartStop.setText("Iniciar Camión");
                        Estacionar();
                        break;
                    }
                    
                    try {
                        obj.wait(100);
                    }catch (InterruptedException e) {     }
                }
                ActualizarPantalla(); 
            }
            
            if (Camion.getRecorrido() >= pbDestino.getMaximum()) {
                ganancias -= (camionero.getGastos() + camionero.getSalario()/20); 
                ruta.setGanancias(ganancias);
                pbDestino.setValue(0);
                Camion.setPeso(0);
                camionero.setGastos(0);
                btnStartStop.setText("Iniciar Ruta");
                Estacionar();
                ActualizarPantalla();
                JOptionPane.showMessageDialog(null, "¡Entrega Realizada con Exito! Las ganancias fueron: $" + String.format("%.2f",ganancias), "Entrega Completada", JOptionPane.INFORMATION_MESSAGE);
                Registro.fecha = formato.format(ruta.getFecha());
                Registro.ganancias = ruta.getGanancias();
                Registro.destino = ruta.getDestino();
                Registro.setVisible(true);
            }
            
            hilo = null;
            
        }
    }
    
    public CaminoEntrega() {
        initComponents();
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
        pbDestino = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        pbPeso = new javax.swing.JProgressBar();
        pbGas = new javax.swing.JProgressBar();
        lblPeso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        btnChargeProd = new javax.swing.JButton();
        btnChargeGas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbbDestino = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        sldVel = new javax.swing.JSlider();
        lblVel = new javax.swing.JLabel();
        btnStartStop = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblGanancias = new javax.swing.JLabel();
        lblCostos = new javax.swing.JLabel();
        btnProgramar = new javax.swing.JButton();
        btnGestionc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Truck.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Goal.jpg"))); // NOI18N

        pbPeso.setMaximum(70);
        pbPeso.setOrientation(1);

        pbGas.setMaximum(60);
        pbGas.setOrientation(1);

        lblPeso.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblPeso.setText("Peso");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Gas");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Estado:");

        lblEstado.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblEstado.setText("Estacionado");

        btnChargeProd.setText("Cargar Producto");
        btnChargeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChargeProdActionPerformed(evt);
            }
        });

        btnChargeGas.setText("Cargar Gas");
        btnChargeGas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChargeGasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Destino:");

        cbbDestino.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Santa Ana (60 km)", "San Salvador (170 km)", "La Libertad (210 km)", "Sonsonate (60 km)" }));
        cbbDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDestinoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Velocidad:");

        sldVel.setMaximum(120);
        sldVel.setValue(0);
        sldVel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldVelStateChanged(evt);
            }
        });

        lblVel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblVel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVel.setText("0 km/h");

        btnStartStop.setText("Iniciar Ruta");
        btnStartStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartStopActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Ganancias");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Costos");

        lblGanancias.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblGanancias.setText("$ 0");

        lblCostos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCostos.setText("$ 0");
        lblCostos.setToolTipText("");

        btnProgramar.setText("Programar Entregas");
        btnProgramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramarActionPerformed(evt);
            }
        });

        btnGestionc.setText("Gestionar Camionero");
        btnGestionc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestioncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pbPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPeso))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(pbGas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(23, 23, 23)
                                .addComponent(lblEstado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cbbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sldVel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnStartStop, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProgramar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChargeGas, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addComponent(lblCostos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblGanancias, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnChargeProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGestionc, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pbDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblEstado)
                    .addComponent(jLabel3)
                    .addComponent(lblPeso)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pbGas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGanancias))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVel)
                            .addComponent(jLabel6)
                            .addComponent(sldVel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblCostos))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnStartStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnProgramar)
                                    .addComponent(btnGestionc))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChargeProd)
                            .addComponent(btnChargeGas)))
                    .addComponent(pbPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChargeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChargeProdActionPerformed
        Peso Peso = new Peso(this,true);
        Double[] datos = Peso.getDatos();
        try {
            double peso = datos[0];
            double precio = datos[1];
            Camion.setPeso(Camion.getPeso() + peso);
            ganancias += peso * precio; 
            ActualizarPantalla(); 
        }catch (Exception e) {  JOptionPane.showMessageDialog(null, "Error en los datos ingresados","Datos no procesados", JOptionPane.WARNING_MESSAGE);    }
    }//GEN-LAST:event_btnChargeProdActionPerformed

    private void btnChargeGasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChargeGasActionPerformed
        Gas Gas = new Gas(this, true);
        double Gal = Gas.getDatos();
        Camion.setGas(Camion.getGas() + Gal);
        camionero.setGastos(camionero.getGastos()   + Camion.getGas() * 3.25 + camionero.getSalario()/31);
        ActualizarPantalla();
    }//GEN-LAST:event_btnChargeGasActionPerformed

    private void btnStartStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartStopActionPerformed
        //Camion listo
        if (Camion.getGas() > 0 && Camion.getPeso() > 0 && cbbDestino.getSelectedIndex() > -1 && btnStartStop.getText() != "Detener Camión") {
            //Calcular distancia
            int destino = cbbDestino.getSelectedIndex();
            switch (destino) {
                case 0:
                case 3:
                    distancia = 60;
                    break;
                case 2:
                    distancia = 210;
                    break;
                case 1:
                    distancia = 170;
                    break;
            }
            ruta.setDestino(String.valueOf(cbbDestino.getSelectedItem()));
            
            //Cambio de Variables
            pbDestino.setMaximum(distancia);
            btnStartStop.setText("Detener Camión");
            lblEstado.setText("En Movimiento");
            btnGestionc.setEnabled(false);
            cbbDestino.setEnabled(false);
            btnChargeProd.setEnabled(false);
            btnChargeGas.setEnabled(false);
            sldVel.setEnabled(false);
            btnProgramar.setEnabled(false);
            if (sldVel.getValue() == 0) {
                sldVel.setValue(60);
                Camion.setVelocidad(sldVel.getValue());
                lblVel.setText("60 km/h");
            }
            Camion.EnMovimiento();          
            
            //Ejecutar Camino
            IniciarCamion();
            
            
        //Detener Camion
        }else if (Camion.getStatus() && btnStartStop.getText() == "Detener Camión") {
            btnStartStop.setText("Iniciar Camión");
            Estacionar();
            DetenerCamion();
        
        //Camion no Listo
        }else {
            JOptionPane.showMessageDialog(null, "Revisa la Gasolina y la Carga del Camión antes de partir, parece que aún no estas listo para partir", "No listo para Partir", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnStartStopActionPerformed

    private void sldVelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldVelStateChanged
        if (Camion.getStatus() || btnStartStop.getText() != "Detener Camión") {
            Camion.setVelocidad(sldVel.getValue());
        }
        
        ActualizarPantalla();
    }//GEN-LAST:event_sldVelStateChanged

    private void cbbDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDestinoActionPerformed

    private void btnGestioncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestioncActionPerformed
        Conductorinf Conform = new Conductorinf(this, true);
        String[] data = Conform.getDatos();
        double salario = 0;
        try {
            salario = Double.parseDouble(data[1]);
            camionero.setNombre(data[0]);
            camionero.setSalario(salario);
            
        }catch (Exception e) {  JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la transferencia de datos", "Error", JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_btnGestioncActionPerformed

    private void btnProgramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramarActionPerformed
        Registro.setVisible(true);
    }//GEN-LAST:event_btnProgramarActionPerformed

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
            java.util.logging.Logger.getLogger(CaminoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaminoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaminoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaminoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaminoEntrega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChargeGas;
    private javax.swing.JButton btnChargeProd;
    private javax.swing.JButton btnGestionc;
    private javax.swing.JButton btnProgramar;
    private javax.swing.JButton btnStartStop;
    private javax.swing.JComboBox<String> cbbDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCostos;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblGanancias;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblVel;
    private javax.swing.JProgressBar pbDestino;
    private javax.swing.JProgressBar pbGas;
    private javax.swing.JProgressBar pbPeso;
    private javax.swing.JSlider sldVel;
    // End of variables declaration//GEN-END:variables
}


