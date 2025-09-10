package Controlador;
import Recurso.Conexion;
import Vista.ConsultaConJInternalFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Guerrero
 */
public class ControlConConsultar {
    ConsultaConJInternalFrame consultorioVista;
    DefaultTableModel modelo;
    Conexion conexion=new Conexion();
    public String url="";
    
    public ControlConConsultar(ConsultaConJInternalFrame consultorioVista){
        this.consultorioVista=consultorioVista;        
        
    }
    
    public void ConsultarConsultorio(){
        
        conexion.getConexion();
        modelo=new DefaultTableModel();
        modelo.addColumn("Numero");
        modelo.addColumn("Nombre");
                
        String datos[]= new String[2];
        consultorioVista.tabla.setModel(modelo);
        try {
            
            String numero=consultorioVista.txtNumero.getText();
            url="jdbc:mysql://127.0.0.1:3306/citas";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement sentencia =conexion.createStatement();
            String consulta="Select * from CONSULTORIOS where CONNUMERO = '"+numero+"'";
            ResultSet rs=sentencia.executeQuery(consulta);  
            if(rs.next()){
              do
              {
                datos[0]=rs.getString(1);                              
                datos[1]=rs.getString(2);                              
                modelo.addRow(datos);
                
              }while(rs.next());
               consultorioVista.tabla.setModel(modelo);
            }else{
               JOptionPane.showMessageDialog(null,"Consultorio no registrado");
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error durante el procedimiento"+ex);
        }  
    }
    
    
}
