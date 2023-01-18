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
import model.negocio.Modelo;

/**
 *
 * @author euluc
 */
@ManagedBean(name = "modeloController")
@SessionScoped
public class ModeloController {

    private Modelo modelo;
    private Modelo selModelo;

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getSelModelo() {
        return selModelo;
    }

    public void setSelModelo(Modelo selModelo) {
        this.selModelo = selModelo;
    }

    @PostConstruct
    public void init() {
        this.modelo = new Modelo();
    }

    public String inserir() {
        ManagerDao.getCurrentInstance().insert(this.modelo);
        this.modelo = new Modelo();

        return "index";
    }

    public List<Modelo> readAllModelo() {
        List<Modelo> modelos = ManagerDao.getCurrentInstance().read("select m from Modelo m", Modelo.class);
        return modelos;
    }

    public String alterar() {
        ManagerDao.getCurrentInstance().update(this.selModelo);
        return "ApresentaModelo";
    }

    public void deletar() {
        ManagerDao.getCurrentInstance().delete(this.selModelo);
    }

    public void clearSelection() {
        this.selModelo = null;
    }

}
