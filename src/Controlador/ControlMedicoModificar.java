package Controlador;
import Modelo.Medico;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Vista.ModificarPJInternalFrame;
import javax.swing.table.DefaultTableModel;
import Vista.ModificarMJInternalFrame;
/**
 *
 * @author Guerrero
 */
public class ControlMedicoModificar {
    
    ModificarMJInternalFrame medicoVista;
    Medico medico=new Medico();
    Conexion conexion=new Conexion();
    public String url;
   
    
    public ControlMedicoModificar(ModificarMJInternalFrame medicoVista){
        
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
            if(rs.next()){
              do
               {
                  medicoVista.txtCedula.setText(rs.getString(1));                              
                  medicoVista.txtNombres.setText(rs.getString(2));
                  medicoVista.txtApellidos.setText(rs.getString(3));
                  medicoVista.txtEspecialidad.setText(rs.getString(4)); 
                                                
               }while(rs.next());
          }else{
                JOptionPane.showMessageDialog(null,"Médico no registrado");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
        
    }
    public void ModificarMedico(){
        
            medico.setIdentificacion(Integer.parseInt(medicoVista.txtCedula.getText()));
            medico.setNombres(medicoVista.txtNombres.getText());
            medico.setApellidos(medicoVista.txtApellidos.getText());
            medico.setEspecialidad(medicoVista.txtEspecialidad.getText());
            
            try{
                  url="jdbc:mysql://127.0.0.1:3306/citas";
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("UPDATE MEDICO SET MEDIDENTIFICACION=?,MEDNOMBRES=?,MEDAPELLIDOS=?,MEDESPECIALIDAD=? WHERE MEDIDENTIFICACION ='"+medicoVista.txtIdentificacion.getText()+"'");
                  pst.setInt(1, medico.getIdentificacion());
                  pst.setString(2, medico.getNombres());
                  pst.setString(3, medico.getApellidos());
                  pst.setString(4, medico.getEspecialidad());
                  
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Médico Modificado");
                  
                  conexion.close();
                
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error en el Procedimiento"+e); 
                
            }
        
    }
    
    
}
