package com.company.projectmanagement.view.taskdetail;


import com.company.projectmanagement.entity.Task;
import com.company.projectmanagement.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "tasks/:id", layout = MainView.class)
@ViewController("Task_.detail")
@ViewDescriptor("task-detail-view.xml")
@EditedEntityContainer("taskDc")
@DialogMode(width = "AUTO",height = "AUTO")
public class TaskDetailView extends StandardDetailView<Task> {
}