/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.dao.ManagerDao;
import model.negocio.Cabrito;
import model.negocio.Modelo;
import model.negocio.Puxador;

/**
 *
 * @author euluc
 */
@ManagedBean(name = "cabritoController")
@SessionScoped
public class CabritoController {

    private Cabrito cadastro;
    private Cabrito selCabrito;

    @PostConstruct
    public void init() {
        this.cadastro = new Cabrito();
    }

    public Cabrito getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cabrito cadastro) {
        this.cadastro = cadastro;
    }

    public Cabrito getSelCabrito() {
        return selCabrito;
    }

    public void setSelCabrito(Cabrito selCabrito) {
        this.selCabrito = selCabrito;
    }

    public String inserir(Puxador puxador, int modelo) {
        if (modelo == 0) {
            System.out.println("vazio");
            return "indexPuxador";
        } else {
            System.out.println("inserindo");
            cadastro.setData_Roubo(new Date());
            cadastro.setPuxador(puxador);
            
            List<Modelo> listModelo = ManagerDao.getCurrentInstance().read("SELECT c from Modelo c where c.codigo =" + modelo, Modelo.class);
            
            
            cadastro.setModelo(listModelo.get(0));
            cadastro.setIsCabritoFinished(false);
            ManagerDao.getCurrentInstance().insert(this.cadastro);
            this.cadastro = new Cabrito();
            return "index";
        }
    }

    public List<Cabrito> readAllCabrito() {
        List<Cabrito> cabritos = ManagerDao.getCurrentInstance().read("select c from Cabrito c", Cabrito.class);
        return cabritos;
    }

    public List<Cabrito> readAllCabritoNaoFinalizado() {
        List<Cabrito> cabritos = ManagerDao.getCurrentInstance().read("SELECT c from Cabrito c WHERE c.isCabritoFinished = false ORDER BY c.data_Roubo DESC", Cabrito.class);
        return cabritos;
    }
    
    public List<Cabrito> readAllCabritoFinalizado() {
        List<Cabrito> cabritos = ManagerDao.getCurrentInstance().read("SELECT c from Cabrito c WHERE c.isCabritoFinished = true ORDER BY c.data_Roubo DESC", Cabrito.class);
        return cabritos;
    }

    public List<Cabrito> readCabritoCurrentPuxador() {
        Puxador currentPuxador = ((LoginController) ((HttpSession) (FacesContext.
                getCurrentInstance().getExternalContext().getSession(true))).
                getAttribute("loginController")).getPuxadorLogado();
        List<Cabrito> cabritos = null;
        try {
            cabritos = ManagerDao.getCurrentInstance().read("select c from Cabrito c where c.puxador.codigo =" + currentPuxador.getCodigo(), Cabrito.class);

        } catch (Error E) {
        }
        
        return cabritos;
    }
}
