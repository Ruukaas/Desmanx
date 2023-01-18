/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author euluc
 */

@Entity
public class Desmanx implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_desmanche;
    private String quem_roubou;
    private Cabrito cabrito;
    private List<itemPeça> itemPeças;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<itemPeça> getItemPeças() {
        return itemPeças;
    }

    public void setItemPeças(List<itemPeça> itemPeças) {
        this.itemPeças = itemPeças;
    }

    public Date getData_desmanche() {
        return data_desmanche;
    }

    public void setData_desmanche(Date data_desmanche) {
        this.data_desmanche = data_desmanche;
    }

    public String getQuem_roubou() {
        return quem_roubou;
    }

    public void setQuem_roubou(String quem_roubou) {
        this.quem_roubou = quem_roubou;
    }

    public Cabrito getCabrito() {
        return cabrito;
    }

    public void setCabrito(Cabrito cabrito) {
        this.cabrito = cabrito;
    }
 
}
