package Recurso;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

   public class Conexion {
      private String usuario="root";
      private static String url="jdbc:mysql://127.0.0.1:3306/citas";
      private static String password="";
           
      public Connection getConexion(){
          Connection conexion=null;
          try{
              Class.forName("com.mysql.jdbc.Driver");
              conexion= (Connection)DriverManager.getConnection(url, usuario, password); 
              JOptionPane.showMessageDialog(null,"Conectado a la Bade de Datos");
              }
          catch (Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error de conexion" + e.getMessage());
      }
   return conexion;
   }
   }
      

    
    

