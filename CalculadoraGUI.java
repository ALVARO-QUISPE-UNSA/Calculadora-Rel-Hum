import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {
    private JTextField pantalla;
    private JButton[] botonesNumeros;
    private JButton bsuma, bresta, bigual, blimpiar, bdivision, bmultiplicacion, bborrar, bblanco;
    private ArrayList<JButton> AllButtons = new ArrayList<>();
    private double NumeroTemporal;
    private char operacion;

    public CalculadoraGUI() {
        // Opciones de pantalla general
        setTitle("Calculadora - Rel. Hum.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Crear campo de texto
        pantalla = new JTextField();
        pantalla.setEditable(true);
        pantalla.setFont(new Font("Times New Roman", Font.ITALIC, 24));

        // Crear los botones de los números
        botonesNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botonesNumeros[i] = new JButton(String.valueOf(i));
            AllButtons.add(botonesNumeros[i]);
            botonesNumeros[i].addActionListener(this);
        }

        // Crear botones para las operaciones
        bsuma = new JButton("+");
        AllButtons.add(bsuma);
        bsuma.addActionListener(this);

        bresta = new JButton("-");
        AllButtons.add(bresta);
        bresta.addActionListener(this);

        bigual = new JButton("=");
        AllButtons.add(bigual);
        bigual.addActionListener(this);

        blimpiar = new JButton("C");
        AllButtons.add(blimpiar);
        blimpiar.addActionListener(this);

        bdivision = new JButton("÷");
        AllButtons.add(bdivision);
        bdivision.addActionListener(this);

        bmultiplicacion = new JButton("x");
        AllButtons.add(bmultiplicacion);
        bmultiplicacion.addActionListener(this);

        bborrar = new JButton("⌂ DEL");
        AllButtons.add(bborrar);
        bborrar.addActionListener(this);

        bblanco = new JButton("");
        AllButtons.add(bblanco);

        // Interfaz de todos los botones
        for (JButton s : AllButtons) {
            s.setBackground(new Color(0, 0, 0));
            s.setForeground(new Color(250, 250, 250));
            Font newfont = new Font("Century Gothic", Font.BOLD, 18);
            s.setFont(newfont);
        }

        // Panel de Operaciones y cero
        JPanel paneloperaciones = new JPanel();
        paneloperaciones.setLayout(new GridLayout(6, 3, 1, 1));
        for (int i = 1; i <= 9; i++)
            paneloperaciones.add(botonesNumeros[i]);
        paneloperaciones.add(botonesNumeros[0]);
        paneloperaciones.add(bborrar);
        paneloperaciones.add(blimpiar);
        paneloperaciones.add(bsuma);
        paneloperaciones.add(bresta);
        paneloperaciones.add(bmultiplicacion);
        paneloperaciones.add(bdivision);
        paneloperaciones.add(bblanco);
        paneloperaciones.add(bigual);

        // Panel principal
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
    //private double dividir(double num1, double num2) {
      //  if (num2 != 0) {
        //    return num1 / num2;
        //} else {
          //  JOptionPane.showMessageDialog(null, "Error: No DEFINIDO");
            //return 0;
        //}
    //}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        String textoActual = pantalla.getText();
        // funcion suma
        if (presionado == bsuma) {
            operacion = '+';
            NumeroTemporal += Double.parseDouble(pantalla.getText());
            pantalla.setText("");
        } else if (presionado == bresta) {
            operacion = '-';
            NumeroTemporal = Double.parseDouble(pantalla.getText());
            pantalla.setText("");
        } else if (presionado == bigual) {
            double numeroActual = Double.parseDouble(pantalla.getText());
            if (operacion == '+') {
                NumeroTemporal += numeroActual;
            } else if (operacion == '-') {
                NumeroTemporal -= numeroActual;
            }
            pantalla.setText(String.valueOf(NumeroTemporal));
        } else if (presionado == blimpiar) {
            NumeroTemporal = 0;
            operacion = ' ';
            pantalla.setText("");
        } else {
            // Escribir si se presiona un número o cualquier otro botón
            String numero = ((JButton) presionado).getText();
            pantalla.setText(textoActual + numero);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	CalculadoraGUI calculadora = new CalculadoraGUI();
            calculadora.setVisible(true);
        });
    }
}
