import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class FiguraGeometrica {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> resultados = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {"CÍRCULO", "RECTANGULO","PENTAGONO", "CUADRADO","TRIANGULO", "POTENCIA"};

            System.out.println("\n   LISTA DE OPCIONES \n");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }

            int seleccionFigura;
            while (true) {
                System.out.print("\nSeleccione el número de la figura: ");
                try {
                    seleccionFigura = scanner.nextInt();
                    if (seleccionFigura > opciones.length || seleccionFigura < 1) {
                        System.out.println("¡Error! Por favor, seleccione un número válido de la lista.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("¡Error! Por favor, ingrese un número válido.");
                    scanner.nextLine();
                }
            }

            System.out.println("----------------------------------------------");

            int seleccionOperacion;
            while (true) {
                System.out.println("\n   LISTA DE OPCIONES ");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.print("\nSeleccione un número: ");
                try {
                    seleccionOperacion = scanner.nextInt();
                    if (seleccionOperacion != 1 && seleccionOperacion != 2) {
                        System.out.println("¡Error! Por favor, seleccione 1 para Área o 2 para Perímetro.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("¡Error! Por favor, ingrese un número válido.");
                    scanner.nextLine();
                }
            }
            System.out.println("----------------------------------------------");

            double resultado = 0;
            switch (seleccionFigura) {
                case 1: // Círculo
                    System.out.print("Ingrese el radio del círculo: ");
                    double radioCirculo = scanner.nextDouble();
                    Circulo circulo = new Circulo(radioCirculo);
                    resultado = seleccionOperacion == 1 ? circulo.calcularArea() : circulo.calcularPerimetro();
                    break;

                case 2: // RECTANGULO
                    System.out.print("Ingrese la base del rectángulo: ");
                    double baseRectangulo = scanner.nextDouble();
                    System.out.print("Ingrese la altura del rectángulo: ");
                    double alturaRectangulo = scanner.nextDouble();
                    Rectangulo rectangulo = new Rectangulo(baseRectangulo, alturaRectangulo);
                    resultado = seleccionOperacion == 1 ? rectangulo.calcularArea() : rectangulo.calcularPerimetro();
                    break;

                case 3: // PENTAGONO
                    System.out.print("Ingrese la longitud de un lado del pentágono: ");
                    double ladoPentagono = scanner.nextDouble();
                    Pentagono pentagono = new Pentagono(ladoPentagono);
                    resultado = seleccionOperacion == 1 ? pentagono.calcularArea() : pentagono.calcularPerimetro();
                    break;

                case 4: // CUADRADO
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double ladoCuadrado = scanner.nextDouble();
                    Cuadrado cuadrado = new Cuadrado(ladoCuadrado);
                    resultado = seleccionOperacion == 1 ? cuadrado.calcularArea() : cuadrado.calcularPerimetro();
                    break;

                case 5: // TRIANGULO
                    System.out.print("Ingrese la base del triángulo: ");
                    double baseTriangulo = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double alturaTriangulo = scanner.nextDouble();
                    Triangulo triangulo = new Triangulo(baseTriangulo, alturaTriangulo);
                    resultado = seleccionOperacion == 1 ? triangulo.calcularArea() : triangulo.calcularPerimetro();
                    break;

                case 6: // POTENCIA
                    System.out.print("Ingrese la base para calcular la potencia: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese el exponente para calcular la potencia: ");
                    double exponente = scanner.nextDouble();
                    double resultadoPotencia = Math.pow(base, exponente);
                    System.out.println("El resultado de la potencia es: " + resultadoPotencia);
                    break;



                default:
                    System.out.println("Selección inválida. Por favor, elija una opción válida.");
            }

            resultados.add(resultado);

            System.out.println("\nResultado:");
            System.out.println("El resultado es: " + resultado);

            System.out.print("\n¿Desea ingresar nuevos datos? (si/no): ");
            String respuesta = scanner.next();

            if (!respuesta.equalsIgnoreCase("si")) {
                continuar = false;
                System.out.println("¡Adiosito dijo Monchito!");
            }
        }

        System.out.println("\nResultados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i + 1) + ". " + resultados.get(i));
        }
    }
}