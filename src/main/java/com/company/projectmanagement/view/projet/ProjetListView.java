package com.company.projectmanagement.view.projet;

import com.company.projectmanagement.entity.Projet;

import com.company.projectmanagement.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "projets", layout = MainView.class)
@ViewController("Projet.list")
@ViewDescriptor("projet-list-view.xml")
@LookupComponent("projetsDataGrid")
@DialogMode(width = "64em")
public class ProjetListView extends StandardListView<Projet> {
}