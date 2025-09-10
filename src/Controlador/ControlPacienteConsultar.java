package Controlador;
import Modelo.Paciente;
import Recurso.Conexion;
import Vista.ConsultaPInternalFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Guerrero
 */
public class ControlPacienteConsultar {
    
    ConsultaPInternalFrame pacienteVista;
    Paciente paciente=new Paciente();
    Conexion conexion=new Conexion();
    public String url;
    public String sexo="";
    DefaultTableModel modelo;
    
    
    public ControlPacienteConsultar(ConsultaPInternalFrame pacienteVista){
        
        this.pacienteVista=pacienteVista;
    }
    
    public void ConsultarPaciente(){
        
        conexion.getConexion();
        modelo=new DefaultTableModel();
        modelo.addColumn("Identificacion");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("FechaNacimiento");
        modelo.addColumn("Sexo");
        String datos[]= new String[5];
        pacienteVista.tabla.setModel(modelo);
        try {
            
            String documento= pacienteVista.txtDocumento.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select * from PACIENTE where PACIDENTIFICACION = '"+documento+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
              do
              {
                datos[0]=rs.getString(1);                              
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4); 
                datos[4]=rs.getString(5);
                modelo.addRow(datos);
                
              }while(rs.next());
             pacienteVista.tabla.setModel(modelo);
        }else{
               JOptionPane.showMessageDialog(null,"El documento no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }     
        
    }
    
}
