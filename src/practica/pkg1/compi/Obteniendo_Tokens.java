/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.compi;

import java.util.ArrayList;
import practica.pkg1.compi.Datos.Tipo_Dato;
import practica.pkg1.compi.DatosArbol.Tipo_Caracter;

/**
 *
 * @author iova
 */
public class Obteniendo_Tokens 
{
    Analizador_Lexico asd = new Analizador_Lexico();
    ArrayList<Datos> lista_datos = new ArrayList<Datos>();
    ArrayList<DatosArbol> lista_Arbol = new ArrayList<DatosArbol>();
//    ArrayList<ER> lista_er = new ArrayList<ER>();
    
    
    public void addDato(String nombre, String expresion, Tipo_Dato tipo)
    {
        Datos nuevo = new Datos(nombre, expresion, tipo);
        lista_datos.add(nuevo);
    }
   
    public void addDatoArbol(String valor, Tipo_Caracter tipo)
    {
        DatosArbol nuevo = new DatosArbol(valor, tipo);
        lista_Arbol.add(nuevo);
    }
    
    public void recorrer()
    {
        String nombre =" ";
        String expresion =" ";
        for(int i =0; i<Interfaz.lis_toks.size()-5; i++)
        {
            Token actual = Interfaz.lis_toks.get(i);
            Token actual1 = Interfaz.lis_toks.get(i+1);
            Token actual2 = Interfaz.lis_toks.get(i+2);
            Token actual3 = Interfaz.lis_toks.get(i+3);
            Token actual4 = Interfaz.lis_toks.get(i+4);
            
            if(actual.getTipo().equals("Palabra Reservada")&& actual1.getLexema().equals(":") && actual2.getTipo().equals("Identificador") && actual3.getLexema().equals("-") &&actual4.getLexema().equals(">"))
            {
                nombre = actual2.getLexema();
                int a = i+5;
                Token act = Interfaz.lis_toks.get(a);
                while(!";".equals(act.getLexema()))
                {
                    expresion +=act.getLexema();
                    a++;
                    act = Interfaz.lis_toks.get(a);
                }
                addDato(nombre, expresion, Tipo_Dato.conjuntos);
                nombre = " ";
                expresion = " ";
            }
            else if(actual.getTipo().equals("Identificador")&&actual1.getLexema().equals(":")&&actual3.getTipo().equals("Cadena"))
            {
                nombre = actual.getLexema();
                expresion = actual3.getLexema();
                addDato(nombre, expresion, Tipo_Dato.expresiones);
                nombre = " ";
                expresion = " ";
            }                
            else if(actual.getTipo().endsWith("Identificador")&&actual1.getLexema().equals("-")&&actual2.getLexema().equals(">"))
            {
                nombre = actual.getLexema();
                int a = i+3;
                Token act = Interfaz.lis_toks.get(a);
                expresion = " .";
                while(!";".equals(act.getLexema()))
                {
                    expresion +=" "+act.getLexema();                    
                    a++;
                    act = Interfaz.lis_toks.get(a);
                }
                expresion += " #";
                addDato(nombre, expresion, Tipo_Dato.er);
                nombre = "";
                expresion = "";
            }
        }
        recorrer1();
    }
    
    
    public void recorrer1()
    {
        addDato(" "," ",Tipo_Dato.saber);
        for(int i =0; i<lista_datos.size()-1; i++)
        {
            Datos actual = lista_datos.get(i);
            Datos actual1 = lista_datos.get(i+1);
            String nombre = actual.getNombre();
            String nombre1 = actual1.getNombre();            
            if(actual.getNombre().equals(actual1.getNombre()))
            {
                if(actual1.getTipoDato().equals("Expresion Regular")&& actual.getTipoDato().equals("Conjuntos")){
                    lista_datos.remove(i+1);
                }
            }
            System.out.println("no "+(i+1)+" nombre: "+actual.getNombre()+" expresion: "+actual.getExpresion()+" tipo: "+actual.getTipoDato());
        }        
        
        recorrer3();
    }
    
    public void datos_arbol()
    {
        String txt="";
        for (int i = 0; i < lista_datos.size(); i++) 
        {
            Datos actual = lista_datos.get(i);
            if(actual.getTipoDato().equals("Expresion Regular"))
            {
                String[] separando = actual.getExpresion().split("¬");                
                for (int j = 0; j < separando.length-2; j++) 
                {
                    switch(separando[j])
                        {
                            case ".":
                                addDatoArbol(".", Tipo_Caracter.concatenacion);
                                break;
                            case "|":
                                addDatoArbol("|", Tipo_Caracter.or);
                                break;
                            case "+":
                                addDatoArbol("+", Tipo_Caracter.mas);
                                break;
                            case "*":
                                addDatoArbol("*", Tipo_Caracter.asterisco);
                                break;
                            case "?":
                                addDatoArbol("?", Tipo_Caracter.interrogacion);
                                break;
                            default:
                                if(separando[j].equals("\"")||separando[j].equals("{")){
                                    String comillas1 = separando[j];
                                    if(!separando[j+1].equals("\"")||!separando[j+1].equals("{")||!separando[j+1].equals("}")){
                                        String txt1=comillas1+separando[j+1];
                                        if(separando[j+2].equals("\"")||separando[j+2].equals("}")){
                                            txt=txt1+separando[j+2];
                                            comillas1=" ";
                                            txt1=" ";
                                        }
                                    }                                        
                                }
                                addDatoArbol(txt, Tipo_Caracter.hoja);
                                txt=" ";
                                break;
//                    String[] separando1 = separando[j].split("");
//                    for (int k = 0; k < separando1.length; k++) {
//                        switch(separando1[k])
//                        {
//                            case ".":
//                                addDatoArbol(".", Tipo_Caracter.concatenacion);
//                                break;
//                            case "|":
//                                addDatoArbol("|", Tipo_Caracter.or);
//                                break;
//                            case "+":
//                                addDatoArbol("+", Tipo_Caracter.mas);
//                                break;
//                            case "*":
//                                addDatoArbol("*", Tipo_Caracter.asterisco);
//                                break;
//                            case "?":
//                                addDatoArbol("?", Tipo_Caracter.interrogacion);
//                                break;
//                            default:
//                                if(separando1[k].equals("\"")){
//                                    String comillas1 = separando[k];
//                                    if(!separando1[k+1].equals("\"")){
//                                        String txt1=comillas1+separando1[k+1];
//                                        if(separando1[k+2].equals("\"")){
//                                            txt=txt1+separando1[k+2];
//                                        }
//                                    }                                        
//                                }
//                                addDatoArbol(txt, Tipo_Caracter.hoja);
//                                break;
//                        }
                    }
                    
                }
            }
        }
//        recorrer3();
    }
    
    
    public void recorrer2()
    {
        for (int i = 0; i < lista_Arbol.size(); i++) {
            DatosArbol actual = lista_Arbol.get(i);
            if("".equals(actual.valor)&&actual.getTipo_Caracter().equals("Hoja")){
                lista_Arbol.remove(i);
            }       
//            System.out.println("esto es :"+actual.getValor()+"su tipo "+actual.getTipo_Caracter());
        }
        
        recorrer3();
    }
    
    public void recorrer3()
    {
        Arbol arbol = new Arbol();    
        String holas3="";
        String holas4="";
        String holas5="";
        for (int i = 0; i < lista_datos.size(); i++) {
            Datos actual = lista_datos.get(i);
            if(actual.getTipoDato().equals("Expresion Regular")){
                holas3 = actual.getExpresion().replace("\"", " ");
                holas4 = holas3.replace("{", " ");
                holas5 = holas4.replace("}", " ");
                String[] separar = holas5.split(" ");
                int m=0;
                for (String separar1 : separar) {
                    if (!"".equals(separar1)) {                        
                        m++;
                        System.out.println(m+" asi viene " + separar1);
                        arbol.agregar(separar1);    
                        arbol.raiz.id++;
                    }
                }
            }
//            ArbolBinario arbol = new ArbolBinario(); 
//            Nodo pivote = new Nodo(actual.valor);
////            Nodo nuevo = new Nodo(actual1.valor);
//            if(actual.valor!=null||!actual.valor.equals("")){
//                arbol.agregar(nuevo, arbol.raiz);
//            }
            
//            if(actual.valor.equals("")){
//                lista_Arbol.remove(i);
//            }    
//            String exp ="";
//            for(int i =0; i<lista_datos.size(); i++){
//                Datos actual = lista_datos.get(i);
//                if(actual.getTipoDato().equals("Expresion Regular")){
//                    char [] evaluar = actual.getExpresion().toCharArray();
//                    for (int j = 0; j < evaluar.length; j++) {
//                        char evaluacion = evaluar[j];
//                        exp=Character.toString(evaluacion);
//                        if(evaluacion == '\"' || evaluacion == '{'){
//                            int a = j;     
//                            exp="";
//                            while('\"'!=evaluacion)
//                            {
//                                exp +=evaluacion;                    
//                                a++;
//                                evaluacion = evaluar[a];
//                            }
//                        }   
//                        Nodo nuevo = new Nodo(exp);
//                        arbol.agregar(nuevo, arbol.raiz);
//                        exp="";
//                    }
//            }
//            System.out.println(pivote.dato+" "+pivote.escribir());
        }
//        Graficador g = new Graficador();
//        g.graficarAST(arbol.raiz);
        arbol.graficar("arbol.jpg");
    }
    
}
