/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.compi;

/**
 *
 * @author iova
 */
public class NoidoArbol {
     String dato;
    String nombre;
    Nodo izquierdo, derecho;
    
    public NoidoArbol(String dato){
        this.dato=dato;
        this.nombre="";
        this.izquierdo=null;
        this.derecho=null;
    }
    
    public NoidoArbol(){
        this.dato="";
        this.nombre="";
        this.izquierdo=null;
        this.derecho=null;
    }
    
    public String escribir(){
        return dato;
    }
    
    public void set_escribir(String dat){
        this.dato=dat;
    }

    public Nodo getHijo() {
        return izquierdo;
    }

    public Nodo getHermano() {
        return derecho;
    }

    public void setHijo(Nodo hijo) {
        this.izquierdo = hijo;
    }

    public void setHermano(Nodo hermano) {
        this.derecho = hermano;
    }
    
    
}
