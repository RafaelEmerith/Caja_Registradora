package src.Pilas;
//Clase Articulo
public class Articulo {
    private String nombre;
    private int cantidad;
    private double precio;
    private double resultado;
//Constructor
    public Articulo(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.resultado = cantidad * precio;
    }
//Getters
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public double getResultado() { return resultado; }
    @Override
    public String toString() {//Convierte a string
        return nombre + "\t" + cantidad + "\t$" + precio + "\t" + resultado;
    }
}