package src.Pilas;

import java.util.Stack;//Importa la clase Stack de pilas

public class Ticket {// Define la clase Ticket
    private final PilaArticulos pila;// Crea la pila

    public Ticket(PilaArticulos pila) {// Constructor
        this.pila = pila;// Inicializa la pila
    }

    public String generarTicket() {// Metodo genera tickets
        StringBuilder sb = new StringBuilder();
        sb.append("<------------------------------------------------------------------------------------->\n");
    sb.append("\t\tJoséJosé SHOP\n");
        sb.append("\t                   Libertad esq Hidalgo           \n");
        sb.append("\t                    Tel: 01800 09110\n");
        sb.append("<------------------------------------------------------------------------------------->\n");
        sb.append("\t                    Recibo de Compra            \n");
        sb.append("<------------------------------------------------------------------------------------->\n");
        sb.append("Producto\tCantidad\tPrecio\tResultado\tDescuento\n\n");
        double total = 0;
        
        Stack<Articulo> articulos = pila.obtenerArticulos();
        for (Articulo articulo : articulos) {
            double subtotal = articulo.getResultado();
            
            if (articulo.getCantidad() > 5) {
                subtotal *= 0.8;  // Aplica 20% de descuento
                sb.append(articulo.toString()).append("\t  20%*\n");
            } else {
                sb.append(articulo.toString()).append("\n");
            }
            total += subtotal;
        }

        sb.append("\n*****************************************************************************\n");
        sb.append("\n   Total\t\t\t\t$").append(String.format("%.2f\n", total));
        sb.append("\n*****************************************************************************\n");
        sb.append("\n\t                ¡Gracias por su compra!\n\n");
        sb.append("*****************************************************************************");                
        return sb.toString();
    }
}
