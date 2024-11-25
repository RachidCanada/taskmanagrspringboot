package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Afficher la page principale avec liste des tâches
    @GetMapping
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new Task()); // Par défaut, un formulaire vide pour ajout
        return "index";
    }

    // Charger la tâche à modifier
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            model.addAttribute("tasks", taskService.getAllTasks());
            model.addAttribute("task", task); // Charger la tâche existante dans le formulaire
        }
        return "index"; // Recharger la même vue
    }

    // Ajouter une nouvelle tâche
    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }

    // Modifier une tâche existante
    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }

    // Supprimer une tâche
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    // Marquer une tâche comme terminée
    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            task.setCompleted(true);
            taskService.saveTask(task);
        }
        return "redirect:/";
    }
}
