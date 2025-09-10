package Controlador;
import Vista.RegCitasJInternalFrame;
import Modelo.Citas;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

/**
 *
 * @author Guerrero
 */
public class ControlCitaRegistrar {
    
    Citas citas=new Citas();
    RegCitasJInternalFrame citasVista;
    Conexion conexion=new Conexion();
    public String url;
    
    public ControlCitaRegistrar(RegCitasJInternalFrame citasVista){
        
        this.citasVista=citasVista;
    }
    
    public void RegistrarCitas(){
        
        try
              {
                  SimpleDateFormat formato = new SimpleDateFormat();
                  String fecha = formato.format(citasVista.jDateCh1.getDate());
                  citas.setFecha(fecha);
                  citas.setHora(citasVista.txtHora.getText());
                  citas.setPaciente(citasVista.txtPaciente.getText());
                  citas.setMedico(Integer.parseInt(citasVista.txtMedico.getText()));
                  citas.setConsultorio(Integer.parseInt(citasVista.txtConsultorio.getText()));
                  citas.setEstado(citasVista.txtEstado.getText());
                  citas.setObservaciones(citasVista.tAObservaciones.getText());
                  conexion.getConexion();
                  url="jdbc:mysql://127.0.0.1:3306/citas";  
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("Insert into CITAS(CITAFECHA,CITAHORA,CITAPACIENTE,CITAMEDICO,CITACONSULTORIO,CITAESTADO,CITAOBSERVACIONES) values(?,?,?,?,?,?,?)");
                  pst.setString(1, citas.getFecha());
                  pst.setString(2, citas.getHora());
                  pst.setString(3, citas.getPaciente());
                  pst.setInt(4, citas.getMedico());
                  pst.setInt(5, citas.getConsultorio());
                  pst.setString(6, citas.getEstado());
                  pst.setString(7, citas.getObservaciones());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Cita registrada");
                  
                  conexion.close();
              }
              catch(Exception ex)
              {
                 JOptionPane.showMessageDialog(null,"Error en el procedimiento"+ex); 
              }
    
}
    
}
