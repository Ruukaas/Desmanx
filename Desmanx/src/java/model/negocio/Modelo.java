/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.negocio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author euluc
 */
@Entity
public class Modelo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String nome;
    private String fabricante;
    private String tipo;
    private String potencia_Motor;
    private String cilindrada_motor;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<Peça> peças;

    public List<Peça> getPeças() {
        return peças;
    }

    public void setPeças(List<Peça> peças) {
        this.peças = peças;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPotencia_Motor() {
        return potencia_Motor;
    }

    public void setPotencia_Motor(String potencia_Motor) {
        this.potencia_Motor = potencia_Motor;
    }

    public String getCilindrada_motor() {
        return cilindrada_motor;
    }

    public void setCilindrada_motor(String cilindrada_motor) {
        this.cilindrada_motor = cilindrada_motor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.codigo);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.fabricante);
        hash = 83 * hash + Objects.hashCode(this.tipo);
        hash = 83 * hash + Objects.hashCode(this.potencia_Motor);
        hash = 83 * hash + Objects.hashCode(this.cilindrada_motor);
        hash = 83 * hash + Objects.hashCode(this.peças);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.potencia_Motor, other.potencia_Motor)) {
            return false;
        }
        if (!Objects.equals(this.cilindrada_motor, other.cilindrada_motor)) {
            return false;
        }
        if (!Objects.equals(this.peças, other.peças)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo{" + "codigo=" + codigo + ", nome=" + nome + ", fabricante=" + fabricante
                + ", tipo=" + tipo + ", potencia_Motor=" + potencia_Motor + ", cilindrada_motor="
                + cilindrada_motor + ", peças=" + peças + '}';
    }
}
