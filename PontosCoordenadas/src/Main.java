import classes.quadrado;
import classes.triangulo;

public class Main {
    public static void main(String[] args) {
        quadrado q1 = new quadrado();
        q1.preencher();
        System.out.println(q1.area());
        System.out.println(q1.perimetro());
        System.out.println(q1);
        
        triangulo t1 = new triangulo();
        t1.preencher();
        t1.distancias();
        System.out.println(t1.perimetro());
        System.out.println(t1.areaTriangulo());
        t1.tipo();
    }
}
