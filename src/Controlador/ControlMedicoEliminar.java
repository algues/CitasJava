package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Recurso.Conexion;
import java.sql.PreparedStatement;
import Vista.EliminarMJInternalFrame;
/**
 *
 * @author Guerrero
 */
public class ControlMedicoEliminar {
   EliminarMJInternalFrame medicoVista;
   Conexion conexion=new Conexion();
   public String url="";
   
   public ControlMedicoEliminar(EliminarMJInternalFrame medicoVista){
       
       this.medicoVista=medicoVista;       
       
   }
   
   public void ConsultarMedico(){
       
            conexion.getConexion();
            try {
            
            String documento= medicoVista.txtIdentificacion.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select * from MEDICO where MEDIDENTIFICACION = '"+documento+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            
            while(rs.next())
            {
                medicoVista.txtDocumento.setText(rs.getString(1));                              
                medicoVista.txtNombres.setText(rs.getString(2));
                medicoVista.txtApellidos.setText(rs.getString(3));
                medicoVista.txtEspecialidad.setText(rs.getString(4)); 
                                                
            }
        
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
   }
   public void EliminarMedico(){
       
       try {            
            String documento= medicoVista.txtIdentificacion.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            PreparedStatement pst =conexion.prepareStatement("DELETE FROM MEDICO where MEDIDENTIFICACION = '"+documento+"'");
            pst.executeUpdate();                                                   
            JOptionPane.showMessageDialog(null,"Médico Eliminado");      
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        } 
    }
}


