package com.company.projectmanagement.view.projet;

import com.company.projectmanagement.entity.Projet;

import com.company.projectmanagement.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "projets/:id", layout = MainView.class)
@ViewController("Projet.detail")
@ViewDescriptor("projet-detail-view.xml")
@EditedEntityContainer("projetDc")
public class ProjetDetailView extends StandardDetailView<Projet> {
}