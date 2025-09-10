package Controlador;
import Vista.ModificarCitaJInternalFrame;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Modelo.Citas;
import java.sql.PreparedStatement;
/**
 *
 * @author Guerrero
 */
public class ControlCitaModificar {
    public String url;
    Conexion conexion=new Conexion();
    ModificarCitaJInternalFrame CitaVista;
    Citas citas=new Citas();
    
    public ControlCitaModificar(ModificarCitaJInternalFrame CitaVista){
        
        this.CitaVista=CitaVista;  
    }
    
    public void ConsultarCita(){
            conexion.getConexion();
            try {
            
            String numero= CitaVista.txtNumCita.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select CITAFECHA,CITAHORA,CITAPACIENTE,CITAMEDICO,CITACONSULTORIO,CITAESTADO,CITAOBSERVACIONES from CITAS where CITANUMERO = '"+numero+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
              do
              {
                CitaVista.txtFecha.setText(rs.getString(1));                              
                CitaVista.txtHora.setText(rs.getString(2));
                CitaVista.txtDocPaciente.setText(rs.getString(3));
                CitaVista.txtDocMedico.setText(rs.getString(4)); 
                CitaVista.txtConsultorio.setText(rs.getString(5));
                CitaVista.txtEstado.setText(rs.getString(6));
                CitaVista.tAObservaciones.setText(rs.getString(7));                
              }while(rs.next());
        
            }else{
                JOptionPane.showMessageDialog(null,"El número de la Cita no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
    }
    public void ModificarCita(){
            
            citas.setFecha(CitaVista.txtFecha.getText());
            citas.setHora(CitaVista.txtHora.getText());
            citas.setPaciente(CitaVista.txtDocPaciente.getText());
            citas.setMedico(Integer.parseInt(CitaVista.txtDocMedico.getText()));
            citas.setConsultorio(Integer.parseInt(CitaVista.txtConsultorio.getText()));
            citas.setEstado(CitaVista.txtEstado.getText());
            citas.setObservaciones(CitaVista.tAObservaciones.getText());
            try{
                  url="jdbc:mysql://127.0.0.1:3306/citas";
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("UPDATE CITAS SET CITAFECHA=?,CITAHORA=?,CITAPACIENTE=?,CITAMEDICO=?,CITACONSULTORIO=?,CITAESTADO=?,CITAOBSERVACIONES=? WHERE CITANUMERO ='"+CitaVista.txtNumCita.getText()+"'");
                  pst.setString(1, citas.getFecha());
                  pst.setString(2, citas.getHora());
                  pst.setString(3, citas.getPaciente());
                  pst.setInt(4, citas.getMedico());
                  pst.setInt(5, citas.getConsultorio());
                  pst.setString(6, citas.getEstado());
                  pst.setString(7, citas.getObservaciones());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Cita Modificada");
                  
                  conexion.close();
                
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error en el Procedimiento"+e); 
                
            }
        
    }
            
    
}
