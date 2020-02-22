/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.compi;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author iovan
 */
public class Nodo 
{
    int id;
    String nombre;
    Nodo iz;
    Nodo der;
    Nodo raiz;
    boolean anulable;
    public ArrayList<Nodo> hijos;

    public Nodo(){
        this.nombre = ""; 
        this.id++;
        this.der=null;
        this.iz=null;
        this.anulable=false;        
        this.hijos = new ArrayList<Nodo>();
    }    
    
    public Nodo(String nombre){
        this.nombre = nombre; 
        this.id++;
        this.der=null;
        this.iz=null;
        this.anulable=false;
        this.hijos = new ArrayList<Nodo>();       
    }
    
    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo aux_grafico.dot");
           } 
        }                        
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tjpg -o "+path+" aux_grafico.dot");
          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varios
          //árboles sucesivamente.
          Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }            
    }
    
    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
               "rankdir=LR;\n" +
               "node [shape=circle, style=filled, color=khaki1, fontcolor=black];\n"+
                getCodigoInterno()+
                "}\n";
    }
    
    private String getCodigoInterno() {
        String etiqueta="";
        if(iz==null && der==null){
            etiqueta="nodo"+id+" [ label =\""+nombre+"\"];\n"; 
        }else{
            etiqueta="nodo"+id+" [ label =\""+nombre+"\"];\n";
        }
        if(iz!=null){
            etiqueta=etiqueta + iz.getCodigoInterno() +
               "nodo"+id+"->nodo"+iz.id+"\n";
        }
        if(der!=null){
            etiqueta=etiqueta + der.getCodigoInterno() +
               "nodo"+id+"->nodo"+der.id+"\n";       
        }
        return etiqueta;
    }        
}
