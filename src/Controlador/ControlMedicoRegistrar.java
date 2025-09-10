package Controlador;
import Modelo.Medico;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Vista.RegMedicoJInternalFrame;

/**
 *
 * @author Guerrero
 */
public class ControlMedicoRegistrar {
    
    Medico medico;
    Conexion conexion;
    public String url="";
    RegMedicoJInternalFrame medicoVista;
    
    public ControlMedicoRegistrar(RegMedicoJInternalFrame medicoVista){
        
        this.medicoVista=medicoVista;        
        
    }
    
    public void RegistrarMedico(){
        
               medico = new Medico();
               conexion=new Conexion();
               medico.setIdentificacion(Integer.parseInt(medicoVista.txtIdentificacion.getText()));
               medico.setNombres(medicoVista.txtNombres.getText());
               medico.setApellidos(medicoVista.txtApellidos.getText());
               medico.setEspecialidad(medicoVista.txtEspecialidad.getText());
               
               try
                 {
                  conexion.getConexion();
                  url="jdbc:mysql://127.0.0.1:3306/citas";  
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("Insert into MEDICO(MEDIDENTIFICACION,MEDNOMBRES,MEDAPELLIDOS,MEDESPECIALIDAD) values(?,?,?,?)");
                  pst.setInt(1, medico.getIdentificacion());
                  pst.setString(2, medico.getNombres());
                  pst.setString(3, medico.getApellidos());
                  pst.setString(4, medico.getEspecialidad());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Médico registrado");
                  
                  conexion.close();
                 }
               catch(Exception e)
                {
                 JOptionPane.showMessageDialog(null,"Error en el procedimiento"+e); 
                }
    }
    
}
