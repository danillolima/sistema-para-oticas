/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import libs.Arquivos;

/**
 *
 * @author Danillo Lima
 */
public class DAOUsuario {

    public void cadastrarUsuarioArquivo(Usuario novo, boolean append) {
        try {
            File arquivo = new File("C:\\Users\\Danillo Lima\\Documents\\NetBeansProjects\\GerenciadorOtica\\src\\arquivos\\usuarios\\Usuarios.obj");
            Arquivos aux = new Arquivos();
            ObjectOutputStream escritor = aux.criaEscritorBinario(arquivo, append);
            aux.gravaObjeto(escritor, novo, true);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> lerUsuarios() {
        /* Ler cliente no arquivo */
        Arquivos aux = new Arquivos();
        File arquivo = new File("C:\\Users\\Danillo Lima\\Documents\\NetBeansProjects\\GerenciadorOtica\\src\\arquivos\\usuarios\\Usuarios.obj");
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        try {
            ObjectInputStream leitor = aux.criaLeitorBinario(arquivo);
            Usuario c = null;            
            do {
                c = (Usuario) aux.LeObjeto(leitor);
                if (c != null) {
                    todosUsuarios.add(c);
                }
            } while (c != null);
                leitor.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return todosUsuarios;
    }
    
}
