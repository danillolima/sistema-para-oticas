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
public class DAOProduto {

    public void cadastrarProdutoArquivo(Produto novo, boolean append) {
         /* Escreve Produto no arquivo */
        try {
            File arquivo = new File("C:\\Users\\Danillo Lima\\Documents\\NetBeansProjects\\GerenciadorOtica\\src\\arquivos\\produtos\\Produtos.obj");
            Arquivos aux = new Arquivos();
            ObjectOutputStream escritor = aux.criaEscritorBinario(arquivo, append);
            aux.gravaObjeto(escritor, novo, true);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Produto> lerProdutos() {
            /* Ler cliente no arquivo */
        Arquivos aux = new Arquivos();
        File arquivo = new File("C:\\Users\\Danillo Lima\\Documents\\NetBeansProjects\\GerenciadorOtica\\src\\arquivos\\produtos\\Produtos.obj");
        ObjectInputStream leitor = aux.criaLeitorBinario(arquivo);
        Produto c = null;
        ArrayList<Produto> todosProdutos = new ArrayList<Produto>();
        do {
            c = (Produto) aux.LeObjeto(leitor);
            if (c != null) {
                todosProdutos.add(c);
            }
        } while (c != null);
        try {
            leitor.close();
        } catch (IOException ex) {
            // Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todosProdutos;
    }
    
}
