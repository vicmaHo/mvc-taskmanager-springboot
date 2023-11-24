
package com.hernandezvictor.ProyectoMVC.Model;

/**
 *
 * @author Victor
 */
/* Esta clase hara referencia a un Plain Old Java Object (POJO) el cual se usa
para representar datos, y son objetos simples que no heredan nada externo o del framework*/
public class Task {
    // en terminos generales es una clase que hace referencia a un dato, y por lo tanto requiere
    // de atributos y un constructor
    

    private String descripcion; // Modificador de acceso privado, solo esta clase accede a este atributo, para acceder o modificar
    // de forma externa se usan los metodos get o set

    // constructores
    public Task(){
        this.descripcion = "None";
    }

    public Task(String descripcion){
        this.descripcion = descripcion;
    }


    //Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    
}
