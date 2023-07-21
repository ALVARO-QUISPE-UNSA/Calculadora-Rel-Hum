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
        bsuma = new JButton("+");
        bsuma.addActionListener(this);
        
        bresta = new JButton("-");
        bresta.addActionListener(this);

        bigual = new JButton("=");
        bigual.addActionListener(this);

        blimpiar = new JButton("C");
        blimpiar.addActionListener(this);

        // Celdas para los botones (panel)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 10, 20));
        for (int i = 1; i <= 9; i++) panelBotones.add(botonesNumeros[i]);
        panelBotones.add(bsuma);
        panelBotones.add(bresta);
        panelBotones.add(botonesNumeros[0]);
        panelBotones.add(bigual);
        panelBotones.add(blimpiar);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(pantalla, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Agregar panel principal a la ventana
        setLayout(new BorderLayout());
        add(panelPrincipal);

        NumeroTemporal = 0;
        operacion = ' ';

        

    }
    @Override 
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI calculadora = new CalculadoraGUI();
            calculadora.setVisible(true);
        });
    }
}
