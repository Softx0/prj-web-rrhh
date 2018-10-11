package controller;

import entity.ExperienciaLaboral;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import facade.ExperienciaLaboralFacade;
import helper.Validacion;

import java.io.Serializable;
import java.util.Date;
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

@Named("experienciaLaboralController")
@SessionScoped
public class ExperienciaLaboralController implements Serializable {

    private ExperienciaLaboral current;
    private DataModel items = null;
    @EJB
    private facade.ExperienciaLaboralFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ExperienciaLaboralController() {
    }

    public ExperienciaLaboral getSelected() {
        if (current == null) {
            current = new ExperienciaLaboral();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ExperienciaLaboralFacade getFacade() {
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
        return "List";
    }

    public String prepareView() {
        current = (ExperienciaLaboral) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ExperienciaLaboral();
        selectedItemIndex = -1;
        if (vali.transferirExperiencialaboral()) {
            return "formulario";
        } else {
            return "formulario";
        }
    }
    Validacion vali = new Validacion();

    public String create() {
        try {

            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ExperienciaLaboralCreated"));
            return prepareCreate();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ExperienciaLaboral) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ExperienciaLaboralUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ExperienciaLaboral) getItems().getRowData();
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
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ExperienciaLaboralDeleted"));
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

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
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

    public ExperienciaLaboral getExperienciaLaboral(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = ExperienciaLaboral.class)
    public static class ExperienciaLaboralControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ExperienciaLaboralController controller = (ExperienciaLaboralController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "experienciaLaboralController");
            return controller.getExperienciaLaboral(getKey(value));
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
            if (object instanceof ExperienciaLaboral) {
                ExperienciaLaboral o = (ExperienciaLaboral) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ExperienciaLaboral.class.getName());
            }
        }

    }

//    public boolean validacionFechas(Date fechaDesde, Date fechaHasta) {
//        String strFechaDesde = fechaDesde.toString();
//        Integer iFechaDesde = Integer.parseInt(strFechaDesde);
//
//        String strFechaHasta = fechaHasta.toString();
//        Integer iFechaHasta = Integer.parseInt(strFechaHasta);
//        if (iFechaDesde > iFechaHasta) {
//            return false;
//        } else {
//            return true;
//        }
//    }

}
