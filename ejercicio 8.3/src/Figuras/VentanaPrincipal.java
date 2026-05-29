package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame
        implements ActionListener {

    private Container contenedor;

    private JButton cilindro;
    private JButton esfera;
    private JButton piramide;

    public VentanaPrincipal() {

        inicio();

        setTitle("Figuras");
        setSize(350, 160);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );
    }

    private void inicio() {

        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton("Cilindro");
        cilindro.setBounds(20, 50, 80, 23);
        cilindro.addActionListener(this);

        esfera = new JButton("Esfera");
        esfera.setBounds(125, 50, 80, 23);
        esfera.addActionListener(this);

        piramide = new JButton("Piramide");
        piramide.setBounds(225, 50, 100, 23);
        piramide.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(piramide);
    }

    public void actionPerformed(ActionEvent evento) {

        if(evento.getSource() == esfera) {

            VentanaEsfera esfera =
                    new VentanaEsfera();

            esfera.setVisible(true);
        }

        if(evento.getSource() == cilindro) {

            VentanaCilindro cilindro =
                    new VentanaCilindro();

            cilindro.setVisible(true);
        }

        if(evento.getSource() == piramide) {

            VentanaPiramide piramide =
                    new VentanaPiramide();

            piramide.setVisible(true);
        }
    }
}