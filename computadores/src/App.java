import classes.computador;

public class App {

    public static void main(String[] args){
        computador pc1 = new computador();
        pc1.preencherPc();
        System.out.println(pc1.toString());

        computador pc2 = new computador();
        pc2.copiar(pc1);
        pc2.setProcessador("i5");
        System.out.println(pc2.toString());
    }
}
