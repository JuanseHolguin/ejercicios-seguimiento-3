import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;

    private JLabel lblNota1, lblNota2, lblNota3, lblNota4, lblNota5;
    private JLabel lblPromedio, lblDesviacion, lblMayor, lblMenor;

    private JTextField txtNota1, txtNota2, txtNota3, txtNota4, txtNota5;

    private JButton btnCalcular, btnBorrar;

    public VentanaPrincipal() {

        iniciar();
    }

    public void iniciar() {

        setTitle("Notas");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        contenedor = getContentPane();
        contenedor.setLayout(null);

        lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(40, 30, 100, 30);
        contenedor.add(lblNota1);

        txtNota1 = new JTextField();
        txtNota1.setBounds(120, 30, 100, 30);
        contenedor.add(txtNota1);

        lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(40, 70, 100, 30);
        contenedor.add(lblNota2);

        txtNota2 = new JTextField();
        txtNota2.setBounds(120, 70, 100, 30);
        contenedor.add(txtNota2);

        lblNota3 = new JLabel("Nota 3:");
        lblNota3.setBounds(40, 110, 100, 30);
        contenedor.add(lblNota3);

        txtNota3 = new JTextField();
        txtNota3.setBounds(120, 110, 100, 30);
        contenedor.add(txtNota3);

        lblNota4 = new JLabel("Nota 4:");
        lblNota4.setBounds(40, 150, 100, 30);
        contenedor.add(lblNota4);

        txtNota4 = new JTextField();
        txtNota4.setBounds(120, 150, 100, 30);
        contenedor.add(txtNota4);

        lblNota5 = new JLabel("Nota 5:");
        lblNota5.setBounds(40, 190, 100, 30);
        contenedor.add(lblNota5);

        txtNota5 = new JTextField();
        txtNota5.setBounds(120, 190, 100, 30);
        contenedor.add(txtNota5);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(60, 250, 130, 35);
        btnCalcular.addActionListener(this);
        contenedor.add(btnCalcular);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(220, 250, 130, 35);
        btnBorrar.addActionListener(this);
        contenedor.add(btnBorrar);

        lblPromedio = new JLabel("Promedio:");
        lblPromedio.setBounds(40, 310, 300, 25);
        contenedor.add(lblPromedio);

        lblDesviacion = new JLabel("Desviación:");
        lblDesviacion.setBounds(40, 335, 300, 25);
        contenedor.add(lblDesviacion);

        lblMayor = new JLabel("Nota mayor:");
        lblMayor.setBounds(40, 360, 300, 25);
        contenedor.add(lblMayor);

        lblMenor = new JLabel("Nota menor:");
        lblMenor.setBounds(40, 385, 300, 25);
        contenedor.add(lblMenor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnCalcular) {

            try {

                double n1 = Double.parseDouble(txtNota1.getText());
                double n2 = Double.parseDouble(txtNota2.getText());
                double n3 = Double.parseDouble(txtNota3.getText());
                double n4 = Double.parseDouble(txtNota4.getText());
                double n5 = Double.parseDouble(txtNota5.getText());

                double[] arregloNotas = {n1, n2, n3, n4, n5};

                Notas notas = new Notas(arregloNotas);

                lblPromedio.setText(
                        "Promedio: " +
                                String.format("%.2f",
                                        notas.calcularPromedio())
                );

                lblDesviacion.setText(
                        "Desviación: " +
                                String.format("%.2f",
                                        notas.calcularDesviacion())
                );

                lblMayor.setText(
                        "Nota mayor: " +
                                notas.calcularMayor()
                );

                lblMenor.setText(
                        "Nota menor: " +
                                notas.calcularMenor()
                );

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(null,
                        "Ingrese valores válidos");
            }
        }

        if(e.getSource() == btnBorrar) {

            txtNota1.setText("");
            txtNota2.setText("");
            txtNota3.setText("");
            txtNota4.setText("");
            txtNota5.setText("");

            lblPromedio.setText("Promedio:");
            lblDesviacion.setText("Desviación:");
            lblMayor.setText("Nota mayor:");
            lblMenor.setText("Nota menor:");
        }
    }
}