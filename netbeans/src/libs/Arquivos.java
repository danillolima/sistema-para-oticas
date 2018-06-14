
package libs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Danillo Lima
 */
public class Arquivos {
    
    public ObjectOutputStream criaEscritorBinario(File arquivo, boolean append){
        ObjectOutputStream out = null;
        try{
            if(arquivo.exists() && append){
                out = new ObjectOutputStream(new FileOutputStream(arquivo, append)){
                    @Override 
                    protected void writeStreamHeader() {
                        //Não escreve um header
                    }              
                };
            }else if(arquivo.exists() && !append){
                out = new ObjectOutputStream(new FileOutputStream(arquivo, append));
            }
            else{
                out = new ObjectOutputStream(new FileOutputStream(arquivo, append));
            }
        }
        catch(IOException e){
            System.err.println(e);
        }
        return out;
    }
    
    public void gravaObjeto(ObjectOutputStream escritor, Object obj, boolean flush){
        try{
            escritor.writeObject(obj);
            if (flush) {
               escritor.flush();
            }
        }
        catch(IOException e){
            System.out.println("Erro na escrita: " + e);
        }     
    }
    
    public ObjectInputStream criaLeitorBinario(File arquivo) {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo. "
                    + erro);
        }
        return ois;
    }
    
      public Object LeObjeto(ObjectInputStream ois) {
        Object objlido = null;
        try {
            objlido = ois.readObject();
        } catch (ClassNotFoundException erro) {
            System.out.println("Classe nao encontrada.");
                    //+ erro);
        } catch (java.io.EOFException erro) {
            System.out.println("Final de arquivo.");
                    //+ erro);
        } catch (IOException erro) {
            System.out.println("Erro na leitura do objeto.111");
            // + erro);
        } finally {
            return objlido;
        }
    }
    
    
    
}