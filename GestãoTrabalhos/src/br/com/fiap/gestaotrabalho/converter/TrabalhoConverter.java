package br.com.fiap.gestaotrabalho.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.model.Trabalho;

@FacesConverter("trabalhoConverter")
public class TrabalhoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
            	GenericDao<Trabalho> dao = new GenericDao<Trabalho>(Trabalho.class);
                return dao.buscar(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid curso."));
            }
        } else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null) {
            return String.valueOf(((Trabalho) object).getIdTrabalho());
        } else {
            return null;
        }
	}

	
}
