import java.util.Scanner;

public class Poten {
    public double poten(Scanner scanner) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        double exponente = scanner.nextDouble();
        return Math.pow(base, exponente);
    }
}
