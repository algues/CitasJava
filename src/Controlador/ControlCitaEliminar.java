package Controlador;
import Vista.EliminarCitaJInternalFrame;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Guerrero
 */
public class ControlCitaEliminar {
    public String url;
    Conexion conexion=new Conexion();
    EliminarCitaJInternalFrame CitaVista;
    
    public ControlCitaEliminar(EliminarCitaJInternalFrame CitaVista){
        
        this.CitaVista=CitaVista;
    }
    
    public void ConsultarCita(){
        
        conexion.getConexion();
            try {
            
            String numero= CitaVista.txtNumero.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select CitaFecha,CitaHora,CitaPaciente,PacNombres,PacApellidos from CITAS Inner Join Paciente on Paciente.PacIdentificacion=Citas.CitaPaciente where CitaNumero = '"+numero+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
              do
               {
                 CitaVista.txtFecha.setText(rs.getString(1));                              
                 CitaVista.txtHora.setText(rs.getString(2));
                 CitaVista.txtDocumento.setText(rs.getString(3));
                 CitaVista.txtNombres.setText(rs.getString(4)); 
                 CitaVista.txtApellidos.setText(rs.getString(5)); 
            }while(rs.next());
            }else{
                JOptionPane.showMessageDialog(null,"El número de Cita no existe");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
    }
    public void EliminarCita(){
        
        try {            
            String numero= CitaVista.txtNumero.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            PreparedStatement pst =conexion.prepareStatement("DELETE FROM CITAS where CITANUMERO = '"+numero+"'");
            pst.executeUpdate();                                                   
            JOptionPane.showMessageDialog(null,"Cita Eliminada");      
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        } 
    }
}
