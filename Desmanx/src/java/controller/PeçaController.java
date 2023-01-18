/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.dao.ManagerDao;
import model.negocio.Peça;

/**
 *
 * @author euluc
 */

@ManagedBean(name = "peçaController")
@SessionScoped
public class PeçaController {
    private Peça peça;
    private Peça selPeça;

    public Peça getPeça() {
        return peça;
    }

    public void setPeça(Peça peça) {
        this.peça = peça;
    }

    public Peça getSelPeça() {
        return selPeça;
    }

    public void setSelPeça(Peça selPeça) {
        this.selPeça = selPeça;
    }
    
    @PostConstruct
    public void init() {
        this.peça = new Peça();
    }
    
    public String inserir() {
        ManagerDao.getCurrentInstance().insert(this.peça);
        this.peça = new Peça();
        
        return "index";
    }
    
    public List<Peça> readAllPeça() {
        List<Peça> peças = ManagerDao.getCurrentInstance().read("select p from Peça p", Peça.class);
        return peças;
    }
    
    public String alterar() {
        ManagerDao.getCurrentInstance().update(this.selPeça);
        return "ApresentaPeça";
    }
    
    public void deletar() {
        ManagerDao.getCurrentInstance().delete(this.selPeça);
    }
    
    public void clearSelection() {
        this.selPeça = null;
    }
    
}
