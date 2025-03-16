package src.GUI;
import javax.swing.*;

import src.Pilas.Articulo;
import src.Pilas.PilaArticulos;
import src.Pilas.Ticket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CajaRegistradoraGUI extends JFrame {

    private final JTextField txtNombre;
    private final JTextField txtCantidad;
    private final JTextField txtPrecio;
    private final JTextArea txtTicket;
    private PilaArticulos pila;

    public CajaRegistradoraGUI() {
        setTitle("PRACTICA 2");//Cabecera
        setSize(380, 560); //Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cerrar ventana=Fin del programa
        setLayout(new FlowLayout());//Diseño de la ventana

        pila = new PilaArticulos();//Crea la pila de los articulos

        add(new JLabel("Nombre del producto:"));// Muestra: Nombre del producto
        txtNombre = new JTextField(20);// Tamaño del recuadro de texto
        add(txtNombre);// Agrega el recuadro de texto

        add(new JLabel("\tCantidad:"));// Muestra: Cantidad 
        txtCantidad = new JTextField(12);
        add(txtCantidad);

        add(new JLabel("\tPrecio:"));// Muestra: Precio
        txtPrecio = new JTextField(12);
        add(txtPrecio);

        JButton btnAgregar = new JButton("\nAgregar");// Boton de agregar
        JButton btnEliminar = new JButton("Eliminar");// Boton de eliminar
        JButton btnGenerarTicket = new JButton("Generar Ticket");// Boton de GENERAR TICKET

        add(btnAgregar);    //Agrega boton
        add(btnEliminar);
        add(btnGenerarTicket);

        txtTicket = new JTextArea(27, 40);// Recuadro de texto para el ticket
        txtTicket.setEditable(false);// No se puede editar
        add(new JScrollPane(txtTicket));// Lo agrega

        btnAgregar.addActionListener(new ActionListener() {// Define la accion del boton
            @Override
            public void actionPerformed(ActionEvent e) {//Accion del boton
                agregarArticulo();//Metodo para agregar articulo
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//Accion del boton
                eliminarArticulo();// Metodo para eliminar articulo
            }
        });

        btnGenerarTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// Accion del boton
                generarTicket();// Metodo para generar Ticket
            }
        });
    }

    private void agregarArticulo() {// Metodo para agregar articulo
        try {
            String nombre = txtNombre.getText();// Obtiene el nombre del articulo
            int cantidad = Integer.parseInt(txtCantidad.getText());// Obtiene la cantidad del articulo
            double precio = Double.parseDouble(txtPrecio.getText());// Obtiene el precio del articulo

            Articulo articulo = new Articulo(nombre, cantidad, precio);// Crea un articulo 
            pila.agregarArticulo(articulo);// Lo agrega a la pila

            txtNombre.setText("");// Limpia el recuadro de texto de nombre del producto
            txtCantidad.setText("");// Limpia el recuadro de texto de cantidad
            txtPrecio.setText("");// Limpia el recuadro de texto de precio
        } catch (NumberFormatException ex) {//Verifica la entrada correcta de datos
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos.");
        }
    }

    private void eliminarArticulo() {// Metodo para eliminar articulo
        pila.eliminarArticulo();// Elimina el articulo de la pila
    }

    private void generarTicket() {// Metodo generar ticket
        Ticket ticket = new Ticket(pila);// Crea el ticket con la pila
        txtTicket.setText(ticket.generarTicket());// Muestra el ticket
    }
 
}
