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
 * @author ALUNO
 */
@ManagedBean
@SessionScoped
public class LoginController {

    private String tipoLogado;

    private Puxador puxadorLogado;

    @PostConstruct
    public void init() {
        this.tipoLogado = "";
        this.puxadorLogado = null;
    }

    public String logar(String login, String senha) {

        System.out.println("logarr");
        System.out.println(login);
        System.out.println(senha);

        {
            List<Puxador> puxadores = ManagerDao.getCurrentInstance().
                    read("select c from Puxador c where "
                            + "c.email='" + login + "' and c.senha='" + senha + "'",
                            Puxador.class);

            System.out.println(puxadores);

            if ((login.equals("admin@gmail.com") && senha.equals("admin123456789"))) {
                System.out.println("adm");
                this.tipoLogado = "admin";
                return "indexAdm";
            } else if (puxadores.isEmpty()) {
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(
                                FacesMessage.SEVERITY_ERROR, "Erro ao logar",
                                "Login ou Senha não conferem"));

                return null;
            } else {
                System.out.println("achou");

                this.puxadorLogado = puxadores.get(0);
                this.tipoLogado = "puxador";

                return "indexPuxador";
            }
        }

    }

    public String logout() {
        System.out.println("Saindo");
        this.puxadorLogado = null;
        this.tipoLogado = "";
        return "index";
    }

    public String getTipoLogado() {
        return tipoLogado;
    }

    public void setTipoLogado(String tipoLogado) {
        System.out.println("Socorro");
        this.tipoLogado = tipoLogado;
    }

    public Puxador getPuxadorLogado() {
        return puxadorLogado;
    }

    public void setPuxadorLogado(Puxador puxadorLogado) {
        this.puxadorLogado = puxadorLogado;
    }

}
