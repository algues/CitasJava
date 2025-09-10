package Vista;
import Recurso.Conexion;
import Modelo.Paciente;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Recurso.Conexion;
import Controlador.ControlPacienteRegistrar;
import java.sql.SQLException;

/**
 *
 * @author Guerrero
 */
public class RegPacienteInternalJFrame extends javax.swing.JInternalFrame 
{   
    public String url="";
    public String opc="";
    Paciente paciente;
    Conexion conexion;
    public RegPacienteInternalJFrame()
    {
        initComponents();        
            
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NombresTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ApellidosTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        RegistrarBtn = new javax.swing.JButton();
        NuevoBtn = new javax.swing.JButton();
        CerrarBtn = new javax.swing.JButton();
        MasculinoOpt = new javax.swing.JRadioButton();
        FemeninoOpt = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jDateCh1 = new com.toedter.calendar.JDateChooser();
        txtIdentificacion = new javax.swing.JTextField();

        setTitle("REGISTRO DE PACIENTES");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Identificacion:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombres:");

        NombresTxt.setName("NombresTxt"); // NOI18N
        NombresTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombresTxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos");

        ApellidosTxt.setName("ApellidosTxt"); // NOI18N
        ApellidosTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosTxtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de Nacimiento:");

        RegistrarBtn.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        RegistrarBtn.setText("Registrar");
        RegistrarBtn.setName("RegistrarBtn"); // NOI18N
        RegistrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarBtnActionPerformed(evt);
            }
        });

        NuevoBtn.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        NuevoBtn.setText("Nuevo");
        NuevoBtn.setName("NuevoBtn"); // NOI18N
        NuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoBtnActionPerformed(evt);
            }
        });

        CerrarBtn.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        CerrarBtn.setText("Cerrar");
        CerrarBtn.setName("CerrarBtn"); // NOI18N
        CerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarBtnActionPerformed(evt);
            }
        });

        MasculinoOpt.setText("M");

        FemeninoOpt.setText("F");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Sexo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombresTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApellidosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateCh1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MasculinoOpt)
                        .addGap(31, 31, 31)
                        .addComponent(FemeninoOpt)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(RegistrarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NuevoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(CerrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ApellidosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombresTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateCh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MasculinoOpt)
                            .addComponent(FemeninoOpt))))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrarBtn)
                    .addComponent(CerrarBtn)
                    .addComponent(NuevoBtn))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApellidosTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosTxtActionPerformed

    private void NombresTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombresTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombresTxtActionPerformed

    private void RegistrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarBtnActionPerformed
        Controlador.ControlPacienteRegistrar registra=new Controlador.ControlPacienteRegistrar(this);
        registra.RegistrarPaciente();
    }//GEN-LAST:event_RegistrarBtnActionPerformed

    private void CerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarBtnActionPerformed
          dispose();
    }//GEN-LAST:event_CerrarBtnActionPerformed

    private void NuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoBtnActionPerformed
               txtIdentificacion.setText(null);
               NombresTxt.setText(null);
               ApellidosTxt.setText(null);
               jDateCh1.setDate(null);
               MasculinoOpt.setSelected(false);
               FemeninoOpt.setSelected(false);
               
    }//GEN-LAST:event_NuevoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ApellidosTxt;
    public javax.swing.JButton CerrarBtn;
    public javax.swing.JRadioButton FemeninoOpt;
    public javax.swing.JRadioButton MasculinoOpt;
    public javax.swing.JTextField NombresTxt;
    public javax.swing.JButton NuevoBtn;
    public javax.swing.JButton RegistrarBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    public com.toedter.calendar.JDateChooser jDateCh1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JTextField txtIdentificacion;
    // End of variables declaration//GEN-END:variables
}
