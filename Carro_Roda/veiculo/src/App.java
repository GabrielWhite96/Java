
import classes.Carro;

public class App {
    public static void main(String[] args){
        Carro c1 = new Carro();
        Carro cc = new Carro();
        c1.preencher();
        System.out.println(c1);
        cc.copiar(c1);
        System.out.println(cc);
    }
}
