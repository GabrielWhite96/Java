package projetoescola;

import gui.FrStudant;
import gui.FrTeacher;

public class SchoolProject {
    public static void main(String[] args) {
        
        FrTeacher screenProf = new FrTeacher();
        screenProf.setVisible(true);
        
        FrStudant screenAluno = new FrStudant();
        screenAluno.setVisible(true);
    }   
}