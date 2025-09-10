package Reportes;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import Recurso.Conexion;


/**
 *
 * @author Guerrero
 */
public class GestorReportes {
    
    Conexion conexion=new Conexion();
    
    public GestorReportes(){     
              
    }
    
    public void EjecutarReporte(String archivo){
        
        try{
             String reporte = System.getProperty("user.dir") + "/src/Reportes/" +archivo;
             JasperReport masterReport = (JasperReport)JRLoader.loadObject(reporte);
             JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, conexion.getConexion());
             JasperViewer jviewer = new JasperViewer(jasperPrint, false);
             jviewer.setVisible(true);
        }
        catch(Exception ex){
            
        }
    }
    
       
}
