package Modelo;

/**
 *
 * @author Guerrero
 */
public class Consultorio {
    public int numero;
    public String nombre;
    
    public Consultorio(int numero, String nombre){
        this.numero=numero;
        this.nombre=nombre;
        
    }
    public Consultorio(){
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
