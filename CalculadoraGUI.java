import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculadoraGUI extends JFrame  implements ActionListener  {
    private JTextField pantalla;
    private JButton [] botonesNumeros;
    private JButton bsuma, bresta, bigual, blimpiar, bdivision, bmultiplicacion, bborrar;
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

        bdivision = new JButton("÷");
        bdivision.addActionListener(this);

        bmultiplicacion = new JButton("x");
        bmultiplicacion.addActionListener(this);

        bborrar = new JButton("⌂ DEL")
        bborrar.addActionListener(this);




        // panel de Operaciones y cero
        JPanel paneloperaciones = new JPanel();
        paneloperaciones.setLayout(new GridLayout(5, 3, 1, 1));
        for (int i = 1; i <= 9; i++) paneloperaciones.add(botonesNumeros[i]);
        paneloperaciones.add(botonesNumeros[0]);
        paneloperaciones.add(bsuma);
        paneloperaciones.add(bresta);
        paneloperaciones.add(bmultiplicacion);
        paneloperaciones.add(bdivision);
        paneloperaciones.add(bigual);

        
        

        //Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(pantalla, BorderLayout.NORTH);
        panelPrincipal.add(paneloperaciones, BorderLayout.CENTER);
        

        // Agregar panel a la ventana principal
        setLayout(new BorderLayout());
        add(panelPrincipal);

        NumeroTemporal = 0;
        operacion = ' ';

        

    }
    @Override 
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
    //Escribir si se presiona un boton
    String numero = ((JButton) presionado).getText();
    pantalla.setText(pantalla.getText() + numero);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI calculadora = new CalculadoraGUI();
            calculadora.setVisible(true);
        });
    }
}
