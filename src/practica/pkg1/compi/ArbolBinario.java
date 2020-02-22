/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.compi;

/**
 *
 * @author iovan
 */
public class ArbolBinario 
{
    NoidoArbol raiz;
    NoidoArbol trabajo;
    int i =0;
    
    
    public ArbolBinario()
    {
        this.raiz = new NoidoArbol(".");
    }
    
    int parar = 0;
    
    public void agregar(NoidoArbol nuevo, NoidoArbol pivote){
        if(pivote == null){
            raiz = nuevo;
        }else{
            if(nuevo.dato.equals(".") || nuevo.dato.equals("|"))
            {
                if(pivote.izquierdo == null)
                {
//                    pivote.izquierdo=nuevo;
                }
                else
                {
//                    this.agregar(nuevo, pivote.izquierdo);
                }
            }
            else if(nuevo.dato.equals("*") || nuevo.dato.equals("+") || nuevo.dato.equals("?"))
            {
                if(pivote.izquierdo == null)
                {
//                    pivote.izquierdo=nuevo;
//                    pivote.derecho = new Nodo("¬");
                }
                else
                {
//                    this.agregar(nuevo, pivote.izquierdo);
                } 
           }
            else
            {
                if(nuevo.dato!="")
                {
                    if(pivote.izquierdo == null && parar == 0)
                    {
//                        pivote.izquierdo=nuevo;
//                        pivote.izquierdo.izquierdo = new Nodo("¬");
//                        pivote.izquierdo.derecho = new Nodo("¬");
//                        parar=1;
                        trabajo=pivote;
                    }
                    else
                    {
                        if(parar == 0)
                        {
//                            this.agregar(nuevo, pivote.izquierdo);
                        }
                        else
                        {
                            if(trabajo.derecho == null)
                            {
//                                trabajo.derecho=nuevo;
//                                trabajo.derecho.izquierdo = new Nodo("¬");
//                                trabajo.derecho.derecho = new Nodo("¬");
                            }
                        }                        
                    }
                }
                
            }
        }
    }
}
