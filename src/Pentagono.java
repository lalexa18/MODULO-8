public class Pentagono extends FiguraGeometrica {
    private double lado;

    public Pentagono(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        // Implementación del cálculo del área de un pentágono
        return 0;
    }

    @Override
    public double calcularPerimetro() {
        return 5 * lado;
    }
}
