package src.Main;
import src.GUI.CajaRegistradoraGUI;
public class Controlador {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CajaRegistradoraGUI().setVisible(true);
            }
        });
    }
}
