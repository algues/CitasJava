package Controlador;
import Modelo.Tratamientos;
import Recurso.Conexion;
import Vista.RegistrarTrataJInternalFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
/**
 *
 * @author Guerrero
 */
public class ControlTrataRegistrar {
    public String url;
    Conexion conexion=new Conexion();
    RegistrarTrataJInternalFrame tratamientoVista;
    Tratamientos tratamiento=new Tratamientos();
    
    public ControlTrataRegistrar(RegistrarTrataJInternalFrame tratamientoVista){
        
        this.tratamientoVista=tratamientoVista;
    
    }
          
    public void RegistrarTratamientos(){
        
        try
              {
                  SimpleDateFormat formato = new SimpleDateFormat();
                  String fechaA = formato.format(tratamientoVista.jDateFechaA.getDate());
                  tratamiento.setFechaAsignada(fechaA);
                  tratamiento.setDescripcion(tratamientoVista.tADescripcion.getText());                  
                  String fechaI = formato.format(tratamientoVista.jDateFechaI.getDate());
                  tratamiento.setFechaInicio(fechaI);
                  String fechaF = formato.format(tratamientoVista.jDateFechaF.getDate());
                  tratamiento.setFechaFin(fechaF);
                  tratamiento.setObservaciones(tratamientoVista.tAObservaciones.getText());
                  tratamiento.setPaciente(tratamientoVista.txtPaciente.getText());
                  conexion.getConexion();
                  url="jdbc:mysql://127.0.0.1:3306/citas";  
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("Insert into TRATAMIENTOS(TRAFECHAASIGNADA,TRADESCRIPCION,TRAFECHAINICIO,TRAFECHAFIN,TRAOBSERVACIONES,TRAPACIENTE) values(?,?,?,?,?,?)");
                  pst.setString(1, tratamiento.getFechaAsignada());
                  pst.setString(2, tratamiento.getDescripcion());
                  pst.setString(3, tratamiento.getFechaInicio());
                  pst.setString(4, tratamiento.getFechaFin());
                  pst.setString(5, tratamiento.getObservaciones());
                  pst.setString(6, tratamiento.getPaciente());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Tratamiento registrado");
                  
                  conexion.close();
              }
              catch(Exception ex)
              {
                 JOptionPane.showMessageDialog(null,"Error en el procedimiento"+ex); 
              }
    }
}
