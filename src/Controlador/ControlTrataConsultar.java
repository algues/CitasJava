package Controlador;
import Recurso.Conexion;
import Vista.ConsultarTrataJInternalFrame;
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
public class ControlTrataConsultar {
    public String url;
    Conexion conexion=new Conexion();
    ConsultarTrataJInternalFrame trataVista;
    
    public ControlTrataConsultar(ConsultarTrataJInternalFrame trataVista){
        
        this.trataVista=trataVista;
    }
    
    public void ConsultarTratamiento(){
        
            conexion.getConexion();
            try {
            
                String numero= trataVista.txtNumero.getText();
                url="jdbc:mysql://127.0.0.1:3306/citas";
                Connection conexion=DriverManager.getConnection(url,"root","");
                Statement sentencia =conexion.createStatement();
                String consulta="Select TraFechaAsignada,TraDescripcion,TraFechaInicio,TraFechaFin,TraObservaciones,TraPaciente,PacApellidos,PacNombres from TRATAMIENTOS Inner Join PACIENTE on Paciente.PacIdentificacion=Tratamientos.TraPaciente where TraNumero= '"+numero+"'";
                ResultSet rs=sentencia.executeQuery(consulta);  
                if(rs.next()){
                  do
                   {
                     trataVista.txtFecha.setText(rs.getString(1));                              
                     trataVista.tADescripcion.setText(rs.getString(2));
                     trataVista.txtFechaIni.setText(rs.getString(3));
                     trataVista.txtFechaFin.setText(rs.getString(4)); 
                     trataVista.tAObservaciones.setText(rs.getString(5));
                     trataVista.txtPaciente.setText(rs.getString(6));
                     trataVista.txtApellidos.setText(rs.getString(7)); 
                     trataVista.txtNombres.setText(rs.getString(8));                
                 }while(rs.next());
             }else{
                   JOptionPane.showMessageDialog(null,"Tratamiento no Registrado");
                }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
    }
    
}
