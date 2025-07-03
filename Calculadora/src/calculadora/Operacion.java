package calculadora;
import java.util.InputMismatchException;
import java.util.Scanner;


abstract public class Operacion {

    public Numero getNum1() {
        return num1;
    }

    public void setNum1(Numero num1) {
        this.num1 = num1;
    }

    public Numero getNum2() {
        return num2;
    }

    public void setNum2(Numero num2) {
        this.num2 = num2;
    }

    private Numero num1;
    private Numero num2;

    public Operacion(String num1, String num2){
        createNumeros(num1, num2);
        operar();
    }

    public void createNumeros(String num1, String num2){
        try{
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese " + num1);
            this.num1 = new Numero(sc.nextDouble());

            System.out.println("Ingrese " + num2);
            this.num2 = new Numero(sc.nextDouble());

            sc.close();
        } catch (InputMismatchException e){
            System.out.println("Debe ingresar un numero real");
        }

    }

    public abstract void operar();

}



class Suma extends Operacion{

    public Suma(){
        super("primer sumando", "segundo sumando");
    }

    @Override
    public void operar(){
        double resultado = this.getNum1().getNumero() + this.getNum2().getNumero();
        System.out.println("La sumatoria es: " + resultado);
    }
}



class Resta extends Operacion{

    public Resta(){
        super("minuendo", "sustraendo");
    }

    @Override
    public void operar(){
        double resultado = this.getNum1().getNumero() - this.getNum2().getNumero();
        System.out.println("La diferencia es: " + resultado);
    }
}



class Multiplicacion extends Operacion{

    public Multiplicacion(){
        super("primer factor", "segundo factor");
    }

    @Override
    public void operar(){
        double resultado = this.getNum1().getNumero() * this.getNum2().getNumero();
        System.out.println("La diferencia es: " + resultado);
    }
}



class Division extends Operacion{

    public Division(){
        super("dividendo", "divisor");
    }

    @Override
    public void operar(){
        try{
            if(getNum2().getNumero() == 0){
                throw new ArithmeticException("La division entre cero no esta permitida");
            }
            double resultado = this.getNum1().getNumero() / this.getNum2().getNumero();
            System.out.println("La división es: " + resultado);
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}



class Potencia extends Operacion{

    public Potencia(){
        super("base", "potencia");
    }

    @Override
    public void operar(){
        double resultado = Math.pow(this.getNum1().getNumero(), this.getNum2().getNumero());
        System.out.println("El resultado es: " + resultado);
    }
}



class Raiz extends Operacion{

    public Raiz(){
        super("base", "base");
    }

    @Override
    public void createNumeros(String num1, String num2) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese " + num1);
            setNum1(new Numero(sc.nextDouble()));

            // Raíz cuadrada solo necesita un número, así que dejamos num2 como null o sin asignar
            setNum2(null);

    }

    @Override
    public void operar(){
        try{
            double resultado = Math.sqrt(this.getNum1().getNumero());
            if (this.getNum1().getNumero() < 0) {
                throw new Exception("Se necesita un número mayor o igual a cero para obtener su raíz cuadrada");
            }
            System.out.println("El resultado es: " + resultado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}



