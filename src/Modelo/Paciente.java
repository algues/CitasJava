package Modelo;

public class Paciente{
    public String identificacion;
    public String nombres;
    public String apellidos;
    public String fechaNacimiento;
    public String sexo;
    
    public Paciente(String identificacion, String nombres, String apellidos,String fechaNacimiento, String sexo )
    {
        this.identificacion= identificacion;
        this.nombres= nombres;
        this.apellidos= apellidos;
        this.fechaNacimiento= fechaNacimiento;
        this.sexo=sexo;
    }
    public Paciente()
    {
        
    }

       public String getIdentificacion() {
        return identificacion;
    }

       public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

        public String getNombres() {
        return nombres;
    }

        public void setNombres(String nombres) {
        this.nombres = nombres;
    }

        public String getApellidos() {
        return apellidos;
    }

        public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

        public String getFechaNacimiento() {
        return fechaNacimiento;
    }

       public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

       public String getSexo() {
        return sexo;
    }

       public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}

