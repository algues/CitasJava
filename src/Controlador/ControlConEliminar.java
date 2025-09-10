package Controlador;
import Vista.EliminarConJInternalFrame;
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
public class ControlConEliminar {
    public String url="";
    EliminarConJInternalFrame consultorioVista;
    Conexion conexion=new Conexion();
    
    public ControlConEliminar(EliminarConJInternalFrame consultorioVista){
        
        this.consultorioVista=consultorioVista;
        
    }
    
    public void ConsultorioConsultar(){
       conexion.getConexion();
            try {
            
            String  numero= consultorioVista.txtNumero.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select * from CONSULTORIOS where CONNUMERO = '"+numero+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
              do
               {
                  consultorioVista.txtNumero1.setText(rs.getString(1));  
                  consultorioVista.txtNombre.setText(rs.getString(2));
                                                
              }while(rs.next());
            }else{
                JOptionPane.showMessageDialog(null,"Consultorio no registrado");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        } 
        
    }
    public void ConsultorioEliminar(){
        try {            
            String numero= consultorioVista.txtNumero.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            PreparedStatement pst =conexion.prepareStatement("DELETE FROM CONSULTORIOS where CONNUMERO = '"+numero+"'");
            pst.executeUpdate();                                                   
            JOptionPane.showMessageDialog(null,"Consultorio Eliminado");      
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        } 
    }
}
