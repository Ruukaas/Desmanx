/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.dao.ManagerDao;
import model.negocio.Puxador;

/**
 *
 * @author euluc
 */
@ManagedBean(name = "puxadorController")
@SessionScoped
public class PuxadorController {

    private Puxador puxador;
    private Puxador selPuxador;
    private Puxador cadastro;

    @PostConstruct
    public void init() {
        this.cadastro = new Puxador();
        this.puxador = new Puxador();
    }

    public String inserir(String confirma) {

        if (!this.cadastro.getSenha().equals(confirma)) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro ao logar",
                            "O login e a senha não batem"));

            return null;
        }

        ManagerDao.getCurrentInstance().insert(this.cadastro);

        ((LoginController) ((HttpSession) (FacesContext.
                getCurrentInstance().getExternalContext().getSession(true))).
                getAttribute("loginController")).setPuxadorLogado(this.cadastro);

        this.cadastro = new Puxador();

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_INFO, "Sucesso!",
                        "bem vindo ao Desmanx"));

        return "indexPuxador";

    }

    public Puxador getCadastro() {
        return cadastro;
    }

    public void setCadastro(Puxador cadastro) {
        this.cadastro = cadastro;
    }

    public Puxador getPuxador() {
        return puxador;
    }

    public void setPuxador(Puxador puxador) {
        this.puxador = puxador;
    }

    public Puxador getSelPuxador() {
        return selPuxador;
    }

    public void setSelPuxador(Puxador selPuxador) {
        this.selPuxador = selPuxador;
    }

    public String inserir() {
        ManagerDao.getCurrentInstance().insert(this.puxador);
        this.puxador = new Puxador();

        return "index";
    }

    public List<Puxador> readAllPuxador() {
        List<Puxador> puxadores = ManagerDao.getCurrentInstance().read("select p from Puxador p", Puxador.class);
        return puxadores;
    }

    public String alterar() {
        ManagerDao.getCurrentInstance().update(this.selPuxador);
        return "ApresentaPuxador";
    }

    public void deletar() {
        ManagerDao.getCurrentInstance().delete(this.selPuxador);
    }

    public void clearSelection() {
        this.selPuxador = null;
    }

}
