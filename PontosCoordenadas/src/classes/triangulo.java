package classes;

public class triangulo {
    private Ponto pn[];
    private double area;
    private double perimetro;
    private double f;
    private double j;
    private double t;

    //construtor
    public triangulo(){
        this.pn = new Ponto[3];
        for(int i=0; i<=2; i++){
            this.pn[i] = new Ponto();
        }
    }

    //gets e sets
    public void setPn(Ponto pn[]){
        this.pn = pn;
    }

    public Ponto[] getPn(){
        return this.pn;
    }

    //funçoes principais
    public void preencher(){
        System.out.println("Preencha os pontos.");
        for(int i=0; i<=2; i++){
            this.pn[i].preencher();
        }
    }

    @Override
    public String toString(){
        String aux = "";
        for(int i=0; i <= 2; i++){
            aux += this.pn[i];
        }
        return aux + "\nÁrea: " +this.area() + "\nPerimetro: " + this.perimetro();
    }

    //funções pedidas
    public boolean isColinear(){
        if(pn[0].determinante(pn[0], pn[1]) == 0){
            return true;
        }else{
            return false;
        }
    }

    public void distancias(){
        this.f = pn[0].distancia(pn[1]);
        this.j = pn[1].distancia(pn[2]);
        this.t = pn[2].distancia(pn[0]);
    }

    public double area(){
        double det2 = pn[0].determinante(pn[1], pn[2]);
        this.area = 0;
        if(det2 != 0){
            area = det2/2;
        }if(area < 0){
            area*=(-1);
        }if(area == 0){
            System.out.println("O triangulo não existe");
        }
        return area;
    }

    public double perimetro(){
        this.perimetro = this.f + this.j + this.t;
        return perimetro;
    }

    public boolean tipoEquilatero(){
        if(this.f == this.j && this.f == this.t && this.j == this.t){
            return true;
        }else{
            return false;
        }
    }

    public boolean tipoIsosceles(){
        if(this.f==this.j && this.f!=this.t || this.f==this.t && this.f!=this.j){
            return true;
        }else{
            return false;
        }
    }

    public boolean tipoEscaleno(){
        if(this.f!=this.j && this.f!=this.t && this.j!=this.t){
            return true;
        }else{
            return false;
        }
    }

    public void tipo(){
        if(this.tipoEquilatero()==true){
            System.out.println("O triangulo é Equilátero.");
        }if(this.tipoIsosceles()==true){
            System.out.println("O triangulo é Isósceles.");
        }if(this.tipoEscaleno()==true){
            System.out.println("O triangulo é Escaleno.");
        }
    }
    







}
