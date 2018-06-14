/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import model.Cliente;
import model.DAOCliente;

/**
 *
 * @author Danillo Lima
 */
public class ClienteController {
    public void cadCliente(Cliente novo){
       // Cliente novo = new Cliente();
       //    novo.setNome("pepo");
       //    novo.setCpf("01245689525");
       //   novo.setId(1);
        DAOCliente pers = new DAOCliente();
        pers.cadastrarClienteArquivo(novo, true);
    }
   public ArrayList<Cliente> leClientes(){
        DAOCliente ler = new DAOCliente();
        return ler.lerClientes();
   }
   
   public void updateClientes(ArrayList<Cliente> updated){
        DAOCliente pers = new DAOCliente();
        pers.cadastrarClienteArquivo((Cliente)updated.get(0), false);
        int i;
        for(i = 1; i < updated.size(); i++){
            pers.cadastrarClienteArquivo((Cliente)updated.get(i),  true);
        }
    }
   
}
