/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Danillo Lima
 */
public class Usuario implements Serializable{
    public Usuario(){}
    public Usuario(int id, String usuario, char[] senha, int cargo, String cpf, String nome) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = cargo;
        this.cpf = cpf;
        this.nome = nome;
    }
    private int id;
    private String usuario;
    private char[] senha;
    private int cargo;
    private String cpf;
    private String nome;
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
}
