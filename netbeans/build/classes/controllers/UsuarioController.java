/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import model.DAOUsuario;
import model.Usuario;

/**
 *
 * @author Danillo Lima
 */
public class UsuarioController {
    public void cadUsuario(Usuario novo){
        DAOUsuario pers = new DAOUsuario();
        pers.cadastrarUsuarioArquivo(novo, true);
    }
   public ArrayList<Usuario> leUsuarios(){
        DAOUsuario ler = new DAOUsuario();
        return ler.lerUsuarios();
   }
   
   public void updateUsuarios(ArrayList<Usuario> updated){
        DAOUsuario pers = new DAOUsuario();
        pers.cadastrarUsuarioArquivo((Usuario)updated.get(0), false);
        int i;
        for(i = 1; i < updated.size(); i++){
            pers.cadastrarUsuarioArquivo((Usuario)updated.get(i),  true);
        }
    }
}
