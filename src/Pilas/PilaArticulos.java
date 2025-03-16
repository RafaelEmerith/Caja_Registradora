package src.Pilas;

import java.util.Stack;

public class PilaArticulos {
    private final Stack<Articulo> pila;

    public PilaArticulos() {
        pila = new Stack<>();
    }

    public void agregarArticulo(Articulo articulo) {
        pila.push(articulo);
    }

    public void eliminarArticulo() {
        if (!pila.isEmpty()) {
            pila.pop();
        }
    }

    public Stack<Articulo> obtenerArticulos() {
        return pila;
    }
}
