package Controlador;
import Vista.ModificarTrataJInternalFrame;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Modelo.Tratamientos;
import java.sql.PreparedStatement;

/**
 *
 * @author Guerrero
 */
public class ControlTrataModificar {
    public String url;
    ModificarTrataJInternalFrame trataVista;
    Conexion conexion=new Conexion();
    Tratamientos trata=new Tratamientos();
    
    public ControlTrataModificar(ModificarTrataJInternalFrame trataVista){
        
        this.trataVista=trataVista;
        
    }
    
    public void ConsultarTratamiento(){
        
            conexion.getConexion();
            try {
            
                String numero= trataVista.txtNumero.getText();
                url="jdbc:mysql://127.0.0.1:3306/citas";
                Connection conexion=DriverManager.getConnection(url,"root","");
                Statement sentencia =conexion.createStatement();
                String consulta="Select TraFechaAsignada,TraDescripcion,TraFechaInicio,TraFechaFin,TraObservacion,TraPaciente from TRATAMIENTOS where TraNumero= '"+numero+"'";
                ResultSet rs=sentencia.executeQuery(consulta);  
                if(rs.next()){
                  do
                   {
                     trataVista.txtFechaAsig.setText(rs.getString(1));                              
                     trataVista.tADescripcion.setText(rs.getString(2));
                     trataVista.txtFechaIni.setText(rs.getString(3));
                     trataVista.txtFechaFin.setText(rs.getString(4)); 
                     trataVista.tAObservaciones.setText(rs.getString(5));
                     trataVista.txtPaciente.setText(rs.getString(6));
                
                  }while(rs.next()); 
                }else{
                    JOptionPane.showMessageDialog(null,"El número de Cita no existe");
                }
           
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }
    }
    
    public void ModificarTratamiento(){
        
            trata.setFechaAsignada(trataVista.txtFechaAsig.getText());
            trata.setDescripcion(trataVista.tADescripcion.getText());
            trata.setFechaInicio(trataVista.txtFechaIni.getText());
            trata.setFechaFin(trataVista.txtFechaFin.getText());
            trata.setObservaciones(trataVista.tAObservaciones.getText());
            trata.setPaciente(trataVista.txtPaciente.getText());
            
            try{
                  url="jdbc:mysql://127.0.0.1:3306/citas";
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("UPDATE TRATAMIENTOS SET TRAFECHAASIGNADA=?,TRADESCRIPCION=?,TRAFECHAINICIO=?,TRAFECHAFIN=?,TRAOBSERVACION=?,TRAPACIENTE=? WHERE TRANUMERO ='"+trataVista.txtNumero.getText()+"'");
                  pst.setString(1, trata.getFechaAsignada());
                  pst.setString(2, trata.getDescripcion());
                  pst.setString(3, trata.getFechaInicio());
                  pst.setString(4, trata.getFechaFin());
                  pst.setString(5, trata.getObservaciones());
                  pst.setString(6, trata.getPaciente());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Tratamiento Modificado");
                  
                  conexion.close();
                
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error en el Procedimiento"+e); 
                
            } 
    }
}
