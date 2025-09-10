package Modelo;

/**
 *
 * @author Guerrero
 */
public class Tratamientos {
    public String numero;
    public String fechaAsignada;
    public String descripcion;
    public String fechaInicio;
    public String fechaFin;
    public String observaciones;
    public String paciente;
    
    public Tratamientos(String numero, String fechaAsignada, String descripcion, String fechaInicio, String fechaFin, String observaciones, String paciente){
        this.numero=numero;
        this.fechaAsignada=fechaAsignada;
        this.descripcion=descripcion;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.observaciones=observaciones;
        this.paciente=paciente;
    }
    public Tratamientos(){
        
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(String fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    
    
    
    
}
