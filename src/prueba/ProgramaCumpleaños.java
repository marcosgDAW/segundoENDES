package prueba;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramaCumpleaños {

    private JFrame frame;
    private JLabel label;
    private JButton boton;

    private String[] mensajes = {
            "Re",
            "Re",
            "Reina",
            "Mi amor yo te extraño",
            "BB",
            "Que hpta",
            "Chimba",
            "Seria vernos otra vez"
    };

    private int indiceMensaje = 0;

    public ProgramaCumpleaños() {
        frame = new JFrame("¡Mensajes Ferxxo!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Aumenté el tamaño
        frame.setLayout(new BorderLayout());

        // Configuración del label
        label = new JLabel(new ImageIcon("/C:\\\\Users\\\\Marcos\\\\Desktop\\\\FERx.jpg"));
        frame.add(label, BorderLayout.CENTER);

        // Configuración del botón
        boton = new JButton("Diselo ferxxo");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSiguienteMensaje();
            }
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(boton);
        frame.add(panelBoton, BorderLayout.SOUTH);

        // Centrar la ventana en la pantalla
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - frame.getSize().width) / 2;
        int y = (dim.height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
    }

    private void mostrarSiguienteMensaje() {
        if (indiceMensaje < mensajes.length) {
            // Mostrar el mensaje
            String mensajeActual = mensajes[indiceMensaje];
            JOptionPane.showMessageDialog(frame, mensajeActual, "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            // Incrementar el índice para el próximo mensaje
            indiceMensaje++;

            // Mostrar automáticamente el siguiente mensaje si hay más
            if (indiceMensaje < mensajes.length) {
                mostrarSiguienteMensaje();
            } else {
                // Cerrar el programa cuando no hay más mensajes
                frame.dispose();
            }
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProgramaCumpleaños programa = new ProgramaCumpleaños();
            programa.mostrarVentana();
        });
    }
}
