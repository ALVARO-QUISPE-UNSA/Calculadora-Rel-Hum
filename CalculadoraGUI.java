import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculadoraGUI extends JFrame  implements ActionListener  {
    private JTextField pantalla;
    private JButton [] botonesNumeros;
    private JButton bsuma, bresta, bigual, 
                blimpiar, bdivision, bmultiplicacion, 
                bborrar, bblanco;
    private ArrayList<JButton> AllButtons = new ArrayList<>();
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

        for(JButton s : AllButtons) {
            s.setBackground(new Color(0, 0, 0));
            s.setForeground(new Color(250, 250, 250));
            Font newfont = new Font("Century Gothic", Font.BOLD, 18);
            s.setFont(newfont);

        }


        // panel de Operaciones y cero
        JPanel paneloperaciones = new JPanel();
        paneloperaciones.setLayout(new GridLayout(6, 3, 1, 1));
        for (int i = 1; i <= 9; i++) paneloperaciones.add(botonesNumeros[i]);
        paneloperaciones.add(botonesNumeros[0]);
        paneloperaciones.add(bborrar);
        paneloperaciones.add(blimpiar);
        paneloperaciones.add(bsuma);
        paneloperaciones.add(bresta);
        paneloperaciones.add(bmultiplicacion);
        paneloperaciones.add(bdivision);
        paneloperaciones.add(bblanco);
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
