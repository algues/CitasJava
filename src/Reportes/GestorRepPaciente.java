package Reportes;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Guerrero
 */
public class GestorRepPaciente {
   
    private Connection conexion;
    private String driver;
    private String url;
    
    public GestorRepPaciente() 
    {
        driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql://127.0.0.1:3306/citas";
        try
        {
            Class.forName(driver).newInstance();
            conexion=DriverManager.getConnection(url, "root", "");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos");
        }
        
    }
    public void ejecutarReporte(String archivo) throws JRException
    {
            String Reporte=System.getProperty("user.dir") + "/src/reportes/"+archivo;
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(Reporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, conexion);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
    }    
}
