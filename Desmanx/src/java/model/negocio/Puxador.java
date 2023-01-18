/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.negocio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author euluc
 */

@Entity
public class Puxador implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    
    private String CPF;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String endereço;
    private String endereço_mae;
    private int quantidade_prisoes;
    private String especialidade_roubo;
    private int anos_experiência;
    private String email;
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getEndereço_mae() {
        return endereço_mae;
    }

    public void setEndereço_mae(String endereço_mae) {
        this.endereço_mae = endereço_mae;
    }

    public int getQuantidade_prisoes() {
        return quantidade_prisoes;
    }

    public void setQuantidade_prisoes(int quantidade_prisoes) {
        this.quantidade_prisoes = quantidade_prisoes;
    }

    public String getEspecialidade_roubo() {
        return especialidade_roubo;
    }

    public void setEspecialidade_roubo(String especialidade_roubo) {
        this.especialidade_roubo = especialidade_roubo;
    }

    public int getAnos_experiência() {
        return anos_experiência;
    }

    public void setAnos_experiência(int anos_experiência) {
        this.anos_experiência = anos_experiência;
    }
}
