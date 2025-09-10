package Controlador;
import Modelo.Consultorio;
import Vista.RegistrarConJInternalFrame;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Guerrero
 */
public class ControlConRegistrar {
    
    Consultorio consultorio=new Consultorio();
    Conexion conexion=new Conexion();
    RegistrarConJInternalFrame consultorioVista;
    public String url="";
    
    public ControlConRegistrar(RegistrarConJInternalFrame consultorioVista){
        
        this.consultorioVista=consultorioVista;        
        
    }
    
    public void RegistrarConsultorio(){
        
        try
              {
                  consultorio.setNombre(consultorioVista.txtNombre.getText());
                  conexion.getConexion();
                  url="jdbc:mysql://127.0.0.1:3306/citas";  
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("Insert into CONSULTORIOS(CONNOMBRE) values(?)");
                  pst.setString(1, consultorio.getNombre());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Consultorio registrado");
                  
                  conexion.close();
              }
              catch(Exception ex)
              {
                 JOptionPane.showMessageDialog(null,"Error en el procedimiento"+ex); 
              }
      

        
    }
    
    
}
