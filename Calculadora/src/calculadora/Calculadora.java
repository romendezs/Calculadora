package calculadora;
import java.util.Scanner;


public class Calculadora {

    public  enum Menu {
        SUMA("Suma", 1),
        RESTA("Resta", 2),
        MULTIPLICACION("Multiplicacion", 3),
        DIVISION("Division", 4),
        POTENCIA("Potencia", 5),
        RAIZ("Raiz", 6),
        SALIR("Salir", 7);

        private final String nombre;
        private final int op;

        Menu(String nombre, int op) {
            this.nombre = nombre;
            this.op = op;
        }

        public String getNombre() {
            return nombre;
        }

        public int getOp(){
            return op;
        }
    };

    Operacion operacion;


    public static void main(String[] args) {
        boolean seguir = true;
        do{
            try{
                Scanner sc = new Scanner(System.in);

                System.out.println("Seleccione una opción");
                for (Menu opcion : Menu.values()) {
                    System.out.println("(" + opcion.getOp() + ") " + opcion.getNombre());
                }

                int op = sc.nextInt();
                if (op <= 0 || op > 7) {
                    throw new Exception("Debe seleccionar un numero entre 1 y 7");
                } else if (op == 7) {
                    seguir = false;
                }

                Calculadora calculadora = new Calculadora(op);
                sc.close();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (seguir);

    }

    public Calculadora(int op){
        this.createOperacion(op);
    }

    public void createOperacion(int op){

        switch (op){

            case 1:
                operacion = new Suma();
                break;
            case 2:
                operacion = new Resta();
                break;
            case 3:
                operacion = new Multiplicacion();
                break;
            case 4:
                operacion = new Division();
                break;
            case 5:
                operacion = new Potencia();
                break;
            case 6:
                operacion = new Raiz();
                break;
            case 7:
                System.out.println("Fin");
                break;
        }
    }
}
