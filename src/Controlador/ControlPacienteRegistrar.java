package Controlador;
import Modelo.Paciente;
import Recurso.Conexion;
import Vista.RegPacienteInternalJFrame;
import Vista.ConsultaPInternalFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class  ControlPacienteRegistrar{
    
    Paciente paciente=new Paciente();
    Conexion conexion=new Conexion();
    ConsultaPInternalFrame consultar;
    RegPacienteInternalJFrame pacienteVista;
    public String url;
    public String sexo="";
    
    
    
    public ControlPacienteRegistrar(RegPacienteInternalJFrame pacienteVista){
        
        this.pacienteVista=pacienteVista;       
    }
    
    public void RegistrarPaciente()            
    {   
        
         try
              {
                  paciente.setIdentificacion(pacienteVista.txtIdentificacion.getText());
                  paciente.setNombres(pacienteVista.NombresTxt.getText());
                  paciente.setApellidos(pacienteVista.ApellidosTxt.getText());
                  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");                  
                  String fechaNacimiento = formato.format(pacienteVista.jDateCh1.getDate());
                  paciente.setFechaNacimiento(fechaNacimiento);
                  if (pacienteVista.MasculinoOpt.isSelected()){
                      sexo="M";
                      paciente.setSexo(sexo);
                  }
                  else{
                      sexo="F";
                      paciente.setSexo(sexo);
                  }
                  conexion.getConexion();
                  url="jdbc:mysql://127.0.0.1:3306/citas";  
                  Connection conexion=DriverManager.getConnection(url,"root","");
                  PreparedStatement pst=conexion.prepareStatement("Insert into PACIENTE(PACIDENTIFICACION,PACNOMBRES,PACAPELLIDOS,PACFECHANACIMIENTO,PACSEXO) values(?,?,?,?,?)");
                  pst.setString(1, paciente.getIdentificacion());
                  pst.setString(2, paciente.getNombres());
                  pst.setString(3, paciente.getApellidos());
                  pst.setString(4, paciente.getFechaNacimiento());
                  pst.setString(5, paciente.getSexo());
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Paciente registrado");
                  
                  conexion.close();
              }
              catch(Exception ex)
              {
                 JOptionPane.showMessageDialog(null,"Error en el procedimiento"+ex); 
              }
      
    }
    

}
         
    
    
    

