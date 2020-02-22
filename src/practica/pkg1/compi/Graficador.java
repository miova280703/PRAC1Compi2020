/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.compi;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iova
 */
public class Graficador {
    int contador;
    //Metodo para graficar un arbol
    public void graficarAST(Nodo raiz)
    {
        //Creo una carpeta en /home/usuario/SalidasDot, en donde va estar todo
        File folder = new File(System.getProperty("user.home") + File.separator +"SalidasDot");        
        if(!folder.exists())
            folder.mkdirs();
        
        
        //Rutas para el .dot y la imagen .png
        String ruta_dot = System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"ast.dot"; 
        String ruta_png = System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"ast.png"; 
        
        //Arma el contenido del .dot
        this.armar_Cuerpo_dot(raiz, ruta_dot);        
        
        //Genera el archivo .dot y su imagen .png
        this.crearGrafo(ruta_dot, ruta_png);
        
        //Abre la imagen resultante .png
        this.autoAbrir(ruta_png);        
    }
        
    //Este metodo se puede usar para graficar cualquier grafo
    //debido a q solo necesita al ruta del dot y la ruta de la salida->imagen
    private void crearGrafo(String ruta_dot, String ruta_png)
    {
        String tParam = "-Tpng";    
        String tOParam = "-o";        
        
        String[] cmd = new String[5]; 
        
        //cmd[0]="dot"; para linux-unix
        //cmd[0]="dot.exe"; para windows
        //cmd[0]="dot"; para mac, creo
        cmd[0] = this.pametro_en_base_sistema_operativo();
        cmd[1] = tParam;    
        cmd[2] = ruta_dot;
        cmd[3] = tOParam;   
        cmd[4] = ruta_png;
        Runtime rt = Runtime.getRuntime();
        
        try 
        {
            //Hace la llamada al sistema y ejecuta la variable cmd
            rt.exec( cmd );                                    
        } 
        catch (IOException ex) 
        {
//            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Este devuelve el parametro que va ha tener para generar la imagen
    //el parametro depende el sistema operativo
    private String pametro_en_base_sistema_operativo()
    {        
        String OS = System.getProperty("os.name").toLowerCase();		
        
        if (OS.contains("win"))
            return "dot.exe";
        else if (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0 )
            return "dot";
        else if (OS.contains("mac")) 
            return "dot";
        else
            System.out.println("Saber :D");
        
        return "dot";
    }
    
    //Este metodo es generico
    //Por que abre un fichero, archivo, etc. en base a la ruta
    //Lo abre con el programa predeterminado por el sistema
    private void autoAbrir(String ruta)
    {
        try
        {
            File archivo = new File(ruta);
            if(archivo.exists())
            {
                Desktop.getDesktop().open(archivo);
            }
        }
        catch (IOException ex) 
        {
//            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Este metodo es generico
    //Porque solo necesita un nodo para crear el .dot
    private void armar_Cuerpo_dot(Nodo raiz, String ruta_dot)
    {
        contador=0;
        StringBuffer buffer=new StringBuffer();
        buffer.append("\ndigraph G {\r\nnode [shape=doublecircle, style=filled, color=khaki1, fontcolor=black];\n");        
        this.listarNodos(raiz, buffer);
        this.enlazarNodos(raiz, buffer);        
        buffer.append("}");
        this.creararchivo(ruta_dot, buffer.toString());
    }
    
    //Este metodo es generico
    //Porque solo necesita un nodo para lista y generar una porcion
    //de lo que sera el fichero .dot
    private void listarNodos(Nodo praiz, StringBuffer buffer)
    {        
        //graphviz+="node"+contador+"[label=\""+praiz.valor+"\"];\n";
        buffer.append("node").append(contador).append("[label=\"").append(praiz.nombre).append("\"];\n");
        praiz.id=contador;  contador++;        
        for(Nodo temp:praiz.hijos)
        {
            listarNodos(temp,buffer);
        }
    }    
    
    //Este metodo es generico
    //Porque solo necesita un nodo para lista y generar una porcion
    //de lo que sera el fichero .dot
    private void enlazarNodos(Nodo praiz, StringBuffer bufffer)
    {        
        for(Nodo temp:praiz.hijos)
        {            
            String relacion="\"node"+praiz.id+"\"->";
            relacion+="\"node"+temp.id+"\";\n";
            bufffer.append(relacion);
            enlazarNodos(temp, bufffer);
        }
    } 
    
    public synchronized void creararchivo(String pfichero,String pcontenido)
    {   
        FileWriter archivo = null;
   
        try{archivo = new FileWriter(pfichero);} 
        catch (IOException ex) 
        {
//            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }

        File a = new File(pfichero);        
        if (!a.exists()){return;}   
        
        try(PrintWriter printwriter = new PrintWriter(archivo)) 
        {
            printwriter.print(pcontenido);
            printwriter.close();
        }
    }
}
