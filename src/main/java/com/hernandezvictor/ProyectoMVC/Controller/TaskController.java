
package com.hernandezvictor.ProyectoMVC.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hernandezvictor.ProyectoMVC.Model.Task;

/**
 *
 * @author Victor
 */
@Controller
public class TaskController {
    
    private List<Task> tasks = new ArrayList<>();
    
    //para este metodo usaremos el requestparam, es decir, mandaremos los parametros
    // por la url
    @PostMapping("/addTask") // el post hace referencia a la creación de un nuevo registro en mi backend
    // el @postmapping indica que este método responderá a solicitudes HTTP POST dirigidas a la URL "/addTask".
    public String addTask(@RequestParam String description){
        tasks.add(new Task(description));
        return "redirect:/";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam int index){
        tasks.remove(index);
        return "redirect:/";
    }
}   
