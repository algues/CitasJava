package Controlador;
import Modelo.Paciente;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Vista.ModificarPJInternalFrame;


/**
 *
 * @author Guerrero
 */
public class ControlPacienteModificar {
    
    ModificarPJInternalFrame pacienteVista;
    Paciente paciente=new Paciente();
    Conexion conexion=new Conexion();
    public String url;
   
    
    
    public ControlPacienteModificar(ModificarPJInternalFrame pacienteVista){
        
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
                pacienteVista.txtCedula.setText(rs.getString(1));                              
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
    public void ModificarPaciente(){
        
            paciente.setIdentificacion(pacienteVista.txtIdentificacion.getText());
            paciente.setNombres(pacienteVista.txtNombres.getText());
            paciente.setApellidos(pacienteVista.txtApellidos.getText());
            paciente.setFechaNacimiento(pacienteVista.txtFecha.getText());
            paciente.setSexo(pacienteVista.txtSexo.getText());
            try{
                  url="jdbc:mysql://127.0.0.1:3306/citas";
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("UPDATE PACIENTE SET PACIDENTIFICACION=?,PACNOMBRES=?,PACAPELLIDOS=?,PACFECHANACIMIENTO=?,PACSEXO=? WHERE PACIDENTIFICACION ='"+pacienteVista.txtIdentificacion.getText()+"'");
                  pst.setString(1, paciente.getIdentificacion());
                  pst.setString(2, paciente.getNombres());
                  pst.setString(3, paciente.getApellidos());
                  pst.setString(4, paciente.getFechaNacimiento());
                  pst.setString(5, paciente.getSexo());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Paciente Modificado");
                  
                  conexion.close();
                
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error en el Procedimiento"+e); 
                
            }
    }
}
