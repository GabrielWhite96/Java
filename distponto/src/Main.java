import classes.quadrado;

public class Main {
    public static void main(String[] args) {
        quadrado q1 = new quadrado();
        q1.preencher();
        System.out.println(q1.areaQ());
        System.out.println(q1.perimetro());
        System.out.println(q1);
    }
}
