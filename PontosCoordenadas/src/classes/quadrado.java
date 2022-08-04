package classes;

public class quadrado {
    private Ponto pt[];
    private double area;
    private double perimetro;
    private double lado;

    //construtor
    public quadrado(){
        this.pt = new Ponto[4];
        for(int i=0; i <= 3; i++){
            this.pt[i] = new Ponto();
        }
    }

    //get e set
    public void setPt(Ponto pt[]){
        this.pt = pt;
    }

    public Ponto[] getPt(){
        return this.pt;
    }

    //funções principais
    public void preencher(){
        System.out.println("Preencha os pontos.");
        for(int i=0; i <= 3; i++){
            this.pt[i].preencher();
        }
    }

    @Override
    public String toString(){
        String aux = "";
        for(int i=0; i <= 3; i++){
            aux += this.pt[i];
        }
        return aux + "\nÁrea: " +this.area() + "\nPerimetro: " + this.perimetro();
    }

    //Funçoes pedidas
    public boolean verificaQuadrado(){
        double contLado = 1;
        double contDiagonal = 0;
        double f = pt[0].distancia(pt[1]);
        double j = pt[1].distancia(pt[2]);
        double t = pt[2].distancia(pt[3]);
        double q = pt[3].distancia(pt[0]);
        double r = pt[0].distancia(pt[2]);
        double g = pt[1].distancia(pt[3]);
        double aux[] = {f, j, t, q, r, g};
        
        for(int i=1; i<=5; i++){
            if(aux[0]==aux[i]){
                contLado++;
            }else{
                contDiagonal++;
            }
        }
        if(contLado==4){
            this.lado = aux[0];
        }else{
            this.lado = aux[1];
        }
        if(contLado==4 && contDiagonal==2 || contLado==2 && contDiagonal==4){
            return true;
        }else{
            return false;
        }

    }

    public double area(){
        if(this.verificaQuadrado()==true){
            this.area = this.lado*this.lado;
            return this.area;
        }else{
            return 0;
        }
    }

    public double perimetro(){
        if(this.verificaQuadrado()==true){
            this.perimetro = this.lado*4;
            return this.perimetro;
        }else{
            return 0;
        }
    } 
}
