package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPiramide extends JFrame
        implements ActionListener {

    private Container contenedor;

    private JLabel base;
    private JLabel altura;
    private JLabel apotema;
    private JLabel volumen;
    private JLabel superficie;

    private JTextField campoBase;
    private JTextField campoAltura;
    private JTextField campoApotema;

    private JButton calcular;

    public VentanaPiramide() {

        inicio();

        setTitle("Piramide");
        setSize(280, 240);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {

        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cms):");
        base.setBounds(20, 20, 135, 23);

        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);

        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        apotema = new JLabel("Apotema (cms):");
        apotema.setBounds(20, 80, 135, 23);

        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 140, 220, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 170, 220, 23);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {

        boolean error = false;

        try {

            double base =
                    Double.parseDouble(
                            campoBase.getText());

            double altura =
                    Double.parseDouble(
                            campoAltura.getText());

            double apotema =
                    Double.parseDouble(
                            campoApotema.getText());

            Piramide piramide =
                    new Piramide(
                            base,
                            altura,
                            apotema
                    );

            volumen.setText(
                    "Volumen (cm3): "
                            + String.format("%.2f",
                            piramide.calcularVolumen()));

            superficie.setText(
                    "Superficie (cm2): "
                            + String.format("%.2f",
                            piramide.calcularSuperficie()));

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
