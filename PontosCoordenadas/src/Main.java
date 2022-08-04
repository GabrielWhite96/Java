import classes.quadrado;
import classes.triangulo;

public class Main {
    public static void main(String[] args) {
        quadrado q1 = new quadrado();
        q1.preencher();
        q1.area();
        q1.perimetro();
        System.out.println(q1);
        
        System.out.println("-----------------------------------------------------");    

        triangulo t1 = new triangulo();
        t1.preencher();
        t1.distancias();
        t1.area();
        t1.perimetro();
        t1.tipo();
        System.out.println(t1);
    }
}
