package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCilindro extends JFrame
        implements ActionListener {

    private Container contenedor;

    private JLabel radio;
    private JLabel altura;
    private JLabel volumen;
    private JLabel superficie;

    private JTextField campoRadio;
    private JTextField campoAltura;

    private JButton calcular;

    public VentanaCilindro() {

        inicio();

        setTitle("Cilindro");
        setSize(280, 210);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {

        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);

        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);

        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 80, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 110, 220, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 140, 220, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {

        boolean error = false;

        try {

            double radio =
                    Double.parseDouble(
                            campoRadio.getText());

            double altura =
                    Double.parseDouble(
                            campoAltura.getText());

            Cilindro cilindro =
                    new Cilindro(radio, altura);

            volumen.setText(
                    "Volumen (cm3): "
                            + String.format("%.2f",
                            cilindro.calcularVolumen()));

            superficie.setText(
                    "Superficie (cm2): "
                            + String.format("%.2f",
                            cilindro.calcularSuperficie()));

        } catch(Exception e) {

            error = true;

        } finally {

            if(error) {

                JOptionPane.showMessageDialog(
                        null,
                        "Campo nulo o error en formato de numero",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}