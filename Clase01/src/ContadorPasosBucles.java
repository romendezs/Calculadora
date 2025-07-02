public class ContadorPasosBucles {
    public static void main(String[] args) {
        for(int  i = 1; i<=5; i++){
            System.out.println("Paso " + i);
        }

        int pasos = 6;
        while(pasos <= 10){
            System.out.println("Paso "+ pasos);
            pasos++;
        }

        int pasoExtra = 11;
        do{
            System.out.println("Paso "+ pasoExtra);
            pasoExtra++;
        }while(pasoExtra<=12);

    }
}
