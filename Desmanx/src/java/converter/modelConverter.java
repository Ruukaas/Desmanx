/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.convert.FacesConverter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.dao.ManagerDao;
import model.negocio.Modelo;

/**
 *
 * @author euluc
 */

@FacesConverter(value = "modeloConverter")
public class modelConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        System.out.println("getAsObject");
        String query = String.format("SELECT m FROM Modelo m WHERE m.codigo = %s", string);
        return ManagerDao.getCurrentInstance().read(query, Modelo.class).get(0);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        System.out.println("getAsString");
        if (o == null) {
            return null;
        }
        System.out.println(o);
        return Integer.toString(((Modelo) o).getCodigo());
    }
}
