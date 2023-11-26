import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {
    private String path;
    private List<String> content;

    public File(String path){
        this.path = path;
        content = new ArrayList<String>();
        this.readFile();
    }
    
    private void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(this.path))){
            String text = br.readLine();
            while(text != null){
                this.content.add(text);
                text = br.readLine();
            }
        } catch(IOException err){
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public void writeFile(String content){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.path, true))){
            bw.write(content);
            bw.newLine();
        } catch(IOException err){
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public List<String> getContent(){ return this.content; }
}
