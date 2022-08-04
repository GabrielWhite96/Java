package classes;

public class quadrado {
    private Ponto pt[];
    private double area;
    private double perimetro;
    private double f;
    private double j;
    private double t;
    private double q;

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
        return aux;
    }

    //Funçoes pedidas
    public boolean verificaQuadrado(){
        this.f = pt[0].distancia(pt[1]);
        this.j = pt[1].distancia(pt[2]);
        this.t = pt[2].distancia(pt[3]);
        this.q = pt[3].distancia(pt[0]);
        if(f==j && j==t && t==q && q==f){
            return true;
        }else{
            return false;
        }
    }

    public String areaQ(){
        if(this.verificaQuadrado()==true){
            double aux = pt[0].distancia(pt[1]);
            this.area = aux*aux;
            String str = Double.toString(this.area);
            return str;
        }else{
            return "tudo errado faz denovo";
        }
    }

    public String perimetro(){
        if(this.verificaQuadrado()==true){
            double aux = pt[0].distancia(pt[1]);
            this.perimetro = aux*4;
            String str = Double.toString(this.perimetro);
            return str;
        }else{
            return "tudo errado faz denovo";
        }
    } 
}
