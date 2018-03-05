/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_17130854_proyecto_01;

/**
 *
 * @author josea
 */
class Cuerpo {
    
    // Atrubutos privados 
    private String nombre;
    private double masa; // velocidad del cuerpo
    private double velocidad; // velocidad del cuerpo en m/s
    private double energia; // energia del cuerpo en Nw
    private final double c = 3.0 * Math.pow(10, 8); // velocidad de la luz ( constante )
    // c está dado en m/s
    
    // constructor vacio con valores en cero
    public Cuerpo(){
        this.nombre     = "No id";
        this.masa       = 0;
        this.velocidad  = 0;
        this.energia    = 0;
    }
    
    // constructor con inicialización especifica
    public Cuerpo(String nombre, double velocidad , double energia) {
        this.nombre     = nombre;
        this.velocidad  = velocidad;
        this.energia    = energia;
        calcularMasa();
    }
    
    // calculo de la masa con energia y velocidad
    public double calcularMasa() {
        double numerador = this.energia * Math.sqrt(1 - (Math.pow(this.velocidad, 2) / Math.pow(this.c, 2)));
        masa = (numerador / Math.pow(this.c, 2) );
        return masa;
    }
    
    // getter y setters
    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }
    
    
    // método toString
    @Override
    public String toString() {
        return this.nombre + ", Masa: " + this.calcularMasa();
    }
}
