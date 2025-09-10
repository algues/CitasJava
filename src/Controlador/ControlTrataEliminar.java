package Controlador;
import Recurso.Conexion;
import Vista.EliminarTrataJInternalFrame;
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
public class ControlTrataEliminar {
    public String url;
    Conexion conexion=new Conexion();
    EliminarTrataJInternalFrame trataVista;
    
    
    public ControlTrataEliminar(EliminarTrataJInternalFrame trataVista){
        
        this.trataVista=trataVista;
    } 

    public void ConsultarTratamiento(){
        
        conexion.getConexion();
            try {
            
                String numero= trataVista.txtNumero.getText();
                url="jdbc:mysql://127.0.0.1:3306/citas";
                Connection conexion=DriverManager.getConnection(url,"root","");
                Statement sentencia =conexion.createStatement();
                String consulta="Select TraFechaAsignada,TraDescripcion,TraPaciente,PacNombres,PacApellidos from TRATAMIENTOS INNER JOIN PACIENTE ON Paciente.PacIdentificacion = Tratamientos.TraPaciente where TraNumero= '"+numero+"'";
                ResultSet rs=sentencia.executeQuery(consulta);  
                if(rs.next()){
                  do
                    {
                       trataVista.txtFecha.setText(rs.getString(1));                              
                       trataVista.tADescripcion.setText(rs.getString(2));
                       trataVista.txtDocumento.setText(rs.getString(3));
                       trataVista.txtNombres.setText(rs.getString(4)); 
                       trataVista.txtApellidos.setText(rs.getString(5));                
                
                    }while(rs.next());
                }else{
                    JOptionPane.showMessageDialog(null,"Tratamiento no registrado");
                }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
    }
    
    public void EliminarTratamiento(){
        
         try {            
            String numero= trataVista.txtNumero.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            PreparedStatement pst =conexion.prepareStatement("DELETE FROM TRATAMIENTOS where TRANUMERO = '"+numero+"'");
            pst.executeUpdate();                                                   
            JOptionPane.showMessageDialog(null,"Tratamiento Eliminado");      
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        } 
    }
   
    
}
