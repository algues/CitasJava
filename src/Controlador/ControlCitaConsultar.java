package Controlador;
import Vista.ConsultaCitasJInternalFrame;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Guerrero
 */
public class ControlCitaConsultar {
    
    public String url;
    Conexion conexion=new Conexion();
    ConsultaCitasJInternalFrame citasVista;
    
    public ControlCitaConsultar(ConsultaCitasJInternalFrame citasVista){
        
        this.citasVista=citasVista;
    }
    
    public void ConsultarCitas(){
        
            conexion.getConexion();
            try {
            
            String numero= citasVista.txtNumero.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select CitaNumero,CitaFecha,CitaHora,CitaPaciente,PacNombres,CitaMedico,MedNombres,CitaConsultorio,ConNombre,CitaEstado,CitaObservaciones from CITAS Inner Join Paciente on Paciente.PacIdentificacion=Citas.CitaPaciente Inner Join Medico on Medico.MedIdentificacion=Citas.CitaMedico Inner Join Consultorios on Consultorios.ConNumero=Citas.CitaConsultorio where CitaNumero = '"+numero+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
               do
                {
                  citasVista.txtNumeroCi.setText(rs.getString(1));                              
                  citasVista.txtFecha.setText(rs.getString(2));
                  citasVista.txtHora.setText(rs.getString(3));
                  citasVista.txtPaciente.setText(rs.getString(4)); 
                  citasVista.txtNombresP.setText(rs.getString(5));
                  citasVista.txtMedico.setText(rs.getString(6));
                  citasVista.txtNombresM.setText(rs.getString(7)); 
                  citasVista.txtNumeroCo.setText(rs.getString(8));
                  citasVista.txtConsultorio.setText(rs.getString(9));
                  citasVista.txtEstado.setText(rs.getString(10));
                  citasVista.tAObservaciones.setText(rs.getString(11));
                }while(rs.next());
            }else{
                JOptionPane.showMessageDialog(null,"El número de la Cita no existe");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
    }
    
}
