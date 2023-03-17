package com.dmjsistemas.bean;

import com.dmjsistemas.model.Usuario;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named("menu")
@ViewScoped
public class MenuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private MenuModel model;

    public MenuBean() {

    }

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        if (us.getPerfil().getNombre().equals("Administrador")) {
            // First submenu
            DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label("MENÚ").build();

            DefaultMenuItem item = DefaultMenuItem
                    .builder()
                    .value("Usuarios")
                    .icon("pi pi-users")
                    .outcome("/views/Usuarios")
                    .build();
            firstSubmenu.getElements().add(item);

            item = DefaultMenuItem
                    .builder()
                    .value("Captura")
                    .icon("pi pi-ticket")
                    .outcome("/views/Captura")
                    .build();
            firstSubmenu.getElements().add(item);

            item = DefaultMenuItem
                    .builder()
                    .value("Proveedores")
                    .icon("pi pi-cog")
                    .outcome("/views/Proveedores")
                    .build();
            firstSubmenu.getElements().add(item);

            item = DefaultMenuItem
                    .builder()
                    .value("Póliza")
                    .icon("pi pi-inbox")
                    .outcome("/views/Poliza")
                    .build();
            firstSubmenu.getElements().add(item);
            
            item = DefaultMenuItem
                    .builder()
                    .value("Relación de pagos")
                    .icon("pi pi-inbox")
                    .outcome("/views/Reporte")
                    .build();
            firstSubmenu.getElements().add(item);

            item = DefaultMenuItem
                    .builder()
                    .value("XML Facturas")
                    .icon("pi pi-file")
                    .outcome("/views/XML")
                    .build();
            firstSubmenu.getElements().add(item);

            model.getElements().add(firstSubmenu);
        } else if (us.getPerfil().getNombre().equals("Usuario")) {
            // First submenu
            DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label("Menú").build();

            DefaultMenuItem item = DefaultMenuItem
                    .builder()
                    .value("Captura")
                    .icon("pi pi-ticket")
                    .outcome("/views/Captura")
                    .build();
            firstSubmenu.getElements().add(item);

            item = DefaultMenuItem
                    .builder()
                    .value("XML Facturas")
                    .icon("pi pi-file")
                    .outcome("/views/XML")
                    .build();
            firstSubmenu.getElements().add(item);

            model.getElements().add(firstSubmenu);
        }

    }

    public MenuModel getModel() {
        return model;
    }

}
