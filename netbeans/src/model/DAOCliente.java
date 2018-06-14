package model;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import libs.Arquivos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danillo Lima
 */
public class DAOCliente {

    public void cadastrarClienteArquivo(Cliente novo, boolean append) {
        /* Escreve cliente no arquivo */
        try {
            File arquivo = new File("C:\\Users\\Danillo Lima\\Documents\\NetBeansProjects\\GerenciadorOtica\\src\\arquivos\\clientes\\Clientes.obj");
            Arquivos aux = new Arquivos();
            ObjectOutputStream escritor = aux.criaEscritorBinario(arquivo, append);
            aux.gravaObjeto(escritor, novo, true);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> lerClientes() {
        /* Ler cliente no arquivo */
        Arquivos aux = new Arquivos();
        File arquivo = new File("C:\\Users\\Danillo Lima\\Documents\\NetBeansProjects\\GerenciadorOtica\\src\\arquivos\\clientes\\Clientes.obj");
        ObjectInputStream leitor = aux.criaLeitorBinario(arquivo);
        Cliente c = null;
        ArrayList<Cliente> todosClientes;
        todosClientes = new ArrayList<>();
        do {
            c = (Cliente) aux.LeObjeto(leitor);
            if (c != null) {
                todosClientes.add(c);
                //   System.out.println( c.getNome());
                //     System.out.println( c.getCpf());
            }
        } while (c != null);

        try {
            leitor.close();
        } catch (IOException ex) {
            // Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todosClientes;
    }

}
