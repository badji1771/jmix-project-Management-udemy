package com.company.projectmanagement.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "TASK_", indexes = {
        @Index(name = "IDX_TASK__ASSIGNEE", columnList = "ASSIGNEE_ID"),
        @Index(name = "IDX_TASK__PROJET", columnList = "PROJET_ID")
})
@Entity(name = "Task_")
public class Task {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @FutureOrPresent(message = "{msg://com.company.projectmanagement.entity/Task.dueDate.validation.FutureOrPresent}")
    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "PRIORITY")
    private String priority;

    @JoinColumn(name = "ASSIGNEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User assignee;

    @Column(name = "ESTIMATION")
    @PositiveOrZero
    private Integer estimation;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "PROJET_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Projet projet;

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority == null ? null : priority.getId();
    }

    public TaskPriority getPriority() {
        return priority == null ? null : TaskPriority.fromId(priority);
    }

    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}