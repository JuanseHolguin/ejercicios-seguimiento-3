public class Notas {

    private double[] listaNotas;

    public Notas(double[] listaNotas) {
        this.listaNotas = listaNotas;
    }

    public double calcularPromedio() {

        double suma = 0;

        for(double nota : listaNotas) {
            suma += nota;
        }

        return suma / listaNotas.length;
    }

    public double calcularDesviacion() {

        double promedio = calcularPromedio();
        double suma = 0;

        for(double nota : listaNotas) {
            suma += Math.pow(nota - promedio, 2);
        }

        return Math.sqrt(suma / listaNotas.length);
    }

    public double calcularMayor() {

        double mayor = listaNotas[0];

        for(double nota : listaNotas) {
            if(nota > mayor) {
                mayor = nota;
            }
        }

        return mayor;
    }

    public double calcularMenor() {

        double menor = listaNotas[0];

        for(double nota : listaNotas) {
            if(nota < menor) {
                menor = nota;
            }
        }

        return menor;
    }
}