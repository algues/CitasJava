package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Recurso.Conexion;
import Vista.ConsultaMJInternalFrame;
/**
 *
 * @author Guerrero
 */
public class ControlMedicoConsultar {
    
    DefaultTableModel modelo;
    Conexion conexion=new Conexion();
    public String url="";
    ConsultaMJInternalFrame medicoVista;
    
    public ControlMedicoConsultar(ConsultaMJInternalFrame medicoVista){
        
        this.medicoVista=medicoVista;
    }
    
    public void ConsultarMedico(){
        
        conexion.getConexion();
        modelo=new DefaultTableModel();
        modelo.addColumn("Identificacion");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Especialidad");
        
        String datos[]= new String[4];
        medicoVista.tabla.setModel(modelo);
        try {
            
            String documento=medicoVista.txtIdentificacion.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select * from MEDICO where MEDIDENTIFICACION = '"+documento+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
              do
               {
                datos[0]=rs.getString(1);                              
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);                 
                modelo.addRow(datos);
                
               }while(rs.next());
                medicoVista.tabla.setModel(modelo);
            }else{
              JOptionPane.showMessageDialog(null,"El documento no existe");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }  
            
    }
    
}
