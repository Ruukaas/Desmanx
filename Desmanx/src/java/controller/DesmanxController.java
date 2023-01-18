/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.dao.ManagerDao;
import model.negocio.Cabrito;
import model.negocio.Desmanx;
import model.negocio.Peça;
import model.negocio.itemPeça;

/**
 *
 * @author euluc
 */
@ManagedBean(name = "desmanxController")
@SessionScoped
public class DesmanxController {

    private Desmanx desmanx;

    @PostConstruct
    public void init() {
        this.desmanx = new Desmanx();
    }

    public Desmanx getDesmanx() {
        return desmanx;
    }

    public void setDesmanx(Desmanx desmanx) {
        this.desmanx = desmanx;
    }

    public void iniciarDesmanx(Cabrito cabrito) {
        List<itemPeça> currentItensPeças = new ArrayList<>();
        System.out.println("a" + cabrito.getModelo().getPeças());
        for (Peça peça : cabrito.getModelo().getPeças()) {
            System.out.println(peça.getNome());
            itemPeça currentItemPeça = new itemPeça();
            currentItemPeça.setPeça(peça);
            currentItensPeças.add(currentItemPeça);
        }
        
        this.desmanx.setCabrito(cabrito);
        this.desmanx.setItemPeças(currentItensPeças);
        System.out.println("a" + desmanx.getItemPeças().get(0).getPeça().getNome());
    }
    
    public void viewDesmanxByCabrito(Cabrito cabrito) {
        List<Desmanx> currentDesmanx = ManagerDao.getCurrentInstance().read("SELECT c from Desmanx c WHERE c.cabrito.codigo =" + cabrito.getCodigo(), Desmanx.class);
        this.desmanx = currentDesmanx.get(0);
    }
    
    public String inserir() {
        List<itemPeça> itensPeças = this.desmanx.getItemPeças();
        
        Cabrito cabrito = this.desmanx.getCabrito();
        cabrito.setIsCabritoFinished(true);
        ManagerDao.getCurrentInstance().update(cabrito);
        
        this.desmanx.setData_desmanche(new Date());
        
        itensPeças.forEach((item) -> {
            ManagerDao.getCurrentInstance().insert(item);
        });
        
        ManagerDao.getCurrentInstance().insert(desmanx);
      
        this.desmanx = new Desmanx();
        
        return "indexAdm";
        
    }
}
