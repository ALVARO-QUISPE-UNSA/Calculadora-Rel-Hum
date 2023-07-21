import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculadoraGUI extends JFrame  implements ActionListener  {
    private JTextField pantalla;
    private JButton [] botonesNumeros;
    private JButton bsuma, bresta, bigual, blimpiar;
    private double NumeroTemporal;
    private char operacion;

    public CalculadoraGUI() {
        //Opciones de pantalla general
        setTitle("Calculadora - Rel. Hum.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        //Crear campo de texto
        pantalla = new JTextField();
        pantalla.setEditable(true);
        pantalla.setFont(new Font("Times New Roman", Font.ITALIC, 24));

        // Crear los botones de los numeros
        botonesNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botonesNumeros[i] = new JButton(String.valueOf(i));
            botonesNumeros[i].addActionListener(this);
        }

        // Crear botones para las operaciones
        //botonSumar = 

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI calculadora = new CalculadoraGUI();
            calculadora.setVisible(true);
        });
    }
}
