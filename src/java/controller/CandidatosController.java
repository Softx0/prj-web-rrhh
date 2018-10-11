package controller;

import entity.Candidatos;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import facade.CandidatosFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("candidatosController")
@SessionScoped
public class CandidatosController implements Serializable {

    private Candidatos current;
    private DataModel items = null;
    @EJB
    private facade.CandidatosFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public CandidatosController() {
    }

    public Candidatos getSelected() {
        if (current == null) {
            current = new Candidatos();
            selectedItemIndex = -1;
        }
        return current;
    }

    private CandidatosFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "admin2";
    }

    public String prepareView() {
        current = (Candidatos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {

        current = new Candidatos();
        selectedItemIndex = -1;
        return "formulario";
    }

    public String create() {

        try {
           
            if (validarCedula(current.getCedula())) {
                getFacade().create(current);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CandidatosCreated"));
                return prepareCreate();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe introducir la Cedula correcta!"));
                return "formulario";
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("Debe introducir una cedula correcta!"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Candidatos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CandidatosUpdated"));
            return "admin2";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Candidatos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "admin2";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "admin2";
        }
    }

    public void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CandidatosDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    public void recreateModel() {
        items = null;
    }

    public void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Candidatos getCandidatos(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Candidatos.class)
    public static class CandidatosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CandidatosController controller = (CandidatosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "candidatosController");
            return controller.getCandidatos(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Candidatos) {
                Candidatos o = (Candidatos) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Candidatos.class.getName());
            }
        }

    }

    //Validacion de la Cedula
    public static boolean validarCedula(String ced) {
        if (ced == null || ced.length() != 11 || ced.equals("00000000000")) {
            return false;
        }
        int suma = 0;
        int division = 0;
        String peso = "1212121212";
        for (int i = 0; i < 10; i++) {
            int mul = (ced.charAt(i) - '0') * (peso.charAt(i) - '0');
            while (mul > 0) {
                suma += mul % 10;
                mul /= 10;
            }
        }
        division = (suma / 10) * 10;
        if (division < suma) {
            division += 10;
        }
        int digito = division - suma;
        if (digito != ced.charAt(10) - '0') {
            return false;
        }
        return true;
    }

}
