package com.example.taskmanager.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération automatique de l'ID
    private Long id;

    @Column(nullable = false) // Le titre est obligatoire
    private String title;

    private boolean completed; // Indique si la tâche est terminée ou non

    // Constructeur par défaut
    public Task() {
    }

    // Constructeur avec arguments (optionnel)
    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
