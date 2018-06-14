/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import model.DAOProduto;
import model.Produto;

/**
 *
 * @author Danillo Lima
 */
public class ProdutoController {
    public void cadProduto(Produto novo){
        DAOProduto pers = new DAOProduto();
        pers.cadastrarProdutoArquivo(novo, true);
    }
   public ArrayList<Produto> leProdutos(){
        DAOProduto ler = new DAOProduto();
        return ler.lerProdutos();
   }
   
   public void updateProdutos(ArrayList<Produto> updated){
        DAOProduto pers = new DAOProduto();
        pers.cadastrarProdutoArquivo((Produto)updated.get(0), false);
        int i;
        for(i = 1; i < updated.size(); i++){
            pers.cadastrarProdutoArquivo((Produto)updated.get(i),  true);
        }
    }
}
