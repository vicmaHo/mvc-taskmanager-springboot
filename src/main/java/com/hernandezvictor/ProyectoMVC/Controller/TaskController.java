
package com.hernandezvictor.ProyectoMVC.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hernandezvictor.ProyectoMVC.Model.Task;

/**
 *
 * @author Victor
 */
@Controller // marco esta clase como un controlador de Spring que se encarga de procesar las solicitudes HTTP
public class TaskController {
    
    private List<Task> tasks = new ArrayList<>(); // Array donde almaceno los datos de las tareas
    private String mensaje = "Aun no tenemos tus datos";
    
    
    /**
     * Funcion que se encarga de responder las solicitudes HTTP GET dirigidas a la URL "/", es decir, la ruta raiz
     * de nuestra aplicacion
     * @param model es una interfaz de Spring que se encarga de manejar los datos de la vista, objeto que envia los datos para ser renderizados
     * @return retorna la vista que se renderizara, en este caso index
     */
    @GetMapping("/") // con el getmapping se indica que se encargue de responder las solicitudes HTTP GET dirigidas a la URL "/"
    public String index(Model model){ // model es una interfaz de Spring que se encarga de manejar los datos de la vista, 
        model.addAttribute("tasks", tasks); // se le pasan los atributos con sus valores y luego se retorna la vista que será renderizada 
        model.addAttribute("identidad", mensaje);
        return "index";
    }

    /**
     * funcion que se encarga de responder las solicitudes HTTP POST dirigidas a la URL "/addTask", en otras palabras
     * se encargara de la creación de nuevas tareas
     * 
     * @param description descripcion de la nueva tarea
     * @return redirect a la ruta raiz
     */
    @PostMapping("/addTask") // el post hace referencia a la creación de un nuevo registro en mi backend
    // el @postmapping indica que este método responderá a solicitudes HTTP POST dirigidas a la URL "/addTask".
    public String addTask(@RequestParam String description){
        tasks.add(new Task(description));
        return "redirect:/";
    }

    /**
     * Funcion que se encarga de responder las solicitudes HTTP POST dirigidas a la URL "/deleteTask", en otras palabras
     * se encargara de la eliminacion de tareas
     * @param index indice de la tarea
     * @return redirect a la ruta raiz
     */
    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam int index){
        tasks.remove(index);
        return "redirect:/";
    }

    /**
     * Funcion de prueba para agregar varias tareas a la lista y renderizarlas
     * @return redirect a la ruta raiz
     */
    @GetMapping("/Ejercicio") // cuando hago una solicitud GET a la ruta "/Ejercicio" agrega varias tareas
    public String Ejercicio(){
        tasks.add(new Task("PushUps"));
        tasks.add(new Task("PullUps"));
        tasks.add(new Task("Core"));
        return "redirect:/";
    }


    /**
     * Funcion de prueba para solicitudes Get que requieren parametros por URL
     * @param nombre
     * @param edad
     * @param model
     * @return
     */
    @GetMapping("/identidad")
    public String addID(
            @RequestParam(name = "nombre", defaultValue = "Invitado") String nombre,
            @RequestParam(name = "edad", defaultValue = "0") int edad,
            Model model) {

        mensaje = "Hola, " + nombre + ". Tu edad es " + edad + " años.";

        // // Agregar el mensaje al modelo para mostrar en la vista
        // model.addAttribute("identidad", mensaje);

        // Devolver el nombre de la vista
        return "redirect:/";
    }
}   
