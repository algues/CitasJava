package Controlador;

import Recurso.Conexion;
import Modelo.Consultorio;
import Vista.ModificarConJInternalFrame;
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
public class ControlConModificar {
    Conexion conexion=new Conexion();
    public String url;
    Consultorio consultorio=new Consultorio();
    ModificarConJInternalFrame consultorioVista;
    
    public ControlConModificar(ModificarConJInternalFrame consultorioVista){
        
        this.consultorioVista=consultorioVista;
        
    }
    
    public void ConsultarConsultorio(){
        
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
                consultorioVista.txtNumero1.setEditable(false);
                consultorioVista.txtNombre.setText(rs.getString(2));
                                                
              } while(rs.next());
            
            }else{
               JOptionPane.showMessageDialog(null,"Consultorio no registrado");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
    }
    
    public void ModificarConsultorio(){
        
            consultorio.setNombre(consultorioVista.txtNombre.getText());
            
            try{
                  url="jdbc:mysql://127.0.0.1:3306/citas";
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("UPDATE CONSULTORIOS SET CONNOMBRE=? WHERE CONNUMERO ='"+consultorioVista.txtNumero.getText()+"'");
                  pst.setString(1, consultorio.getNombre());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Consultorio Modificado");
                  
                  conexion.close();
                
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error en el Procedimiento"+e); 
                
            }
    }
}
