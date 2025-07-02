import java.util.Scanner;

public class Restaurante {
    enum Menu{
        PIZZA, HAMBURGUESA, ENSALADA
    }

    public static final double[] PRECIOS = {8.5, 7.0, 5.5};
    public static double total = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do{
            System.out.println("Menu:");
            for(Menu item : Menu.values()){
                System.out.println("- " + item);
            }

            System.out.println("Qué desea ordenar?");
            try{
                Menu pedido = Menu.valueOf(scanner.next().toUpperCase());
                total += PRECIOS[pedido.ordinal()];
                System.out.println("Agregado: " + pedido + " $" + PRECIOS[pedido.ordinal()]);

            }catch (IllegalArgumentException e ){
                System.out.println("Opción no válida");
            }

            System.out.println("Desea pedir algo más? (s/n)");
            opcion = scanner.next();

        } while(opcion.equals("s"));

        System.out.println("Total a pagar: $" +total);
        System.out.println("Gracias por visitar");
    }
}
