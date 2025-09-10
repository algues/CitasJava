package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Recurso.Conexion;
import java.sql.PreparedStatement;
import Vista.EliminarPJInternalFrame;

/**
 *
 * @author Guerrero
 */
public class ControlPacienteEliminar {
    Conexion conexion=new Conexion();
    public String url="";
    EliminarPJInternalFrame pacienteVista;
    
    public ControlPacienteEliminar(EliminarPJInternalFrame pacienteVista){
        
        this.pacienteVista=pacienteVista;        
        
    }
    public void ConsultarPaciente(){
        
            conexion.getConexion();
            try {
            
            String documento= pacienteVista.txtIdentificacion.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select * from PACIENTE where PACIDENTIFICACION = '"+documento+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
              do
               {
                 pacienteVista.txtDocumento.setText(rs.getString(1));                              
                 pacienteVista.txtNombres.setText(rs.getString(2));
                 pacienteVista.txtApellidos.setText(rs.getString(3));
                 pacienteVista.txtFecha.setText(rs.getString(4)); 
                 pacienteVista.txtSexo.setText(rs.getString(5));
                                
            }while(rs.next());
            }else{
                JOptionPane.showMessageDialog(null,"Paciente no registrado");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
        
    }
    public void EliminarPaciente(){
        
        try {            
            String documento= pacienteVista.txtIdentificacion.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            PreparedStatement pst =conexion.prepareStatement("DELETE FROM PACIENTE where PACIDENTIFICACION = '"+documento+"'");
            pst.executeUpdate();                                                   
            JOptionPane.showMessageDialog(null,"Paciente Eliminado");      
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        } 
    }
    
    
}
