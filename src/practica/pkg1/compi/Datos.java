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
public class Datos 
{
    public enum Tipo_Dato
    {
        er,expresiones,conjuntos,saber
    }
    
    public String nombre;
    public String expresion;
    public Tipo_Dato tipo;
    
    Datos(String nombre, String expresion, Tipo_Dato tipo)
    {
        this.nombre = nombre;
        this.expresion = expresion;
        this.tipo = tipo;
    }
    
    public String getTipoDato()
    {
        switch(tipo)
        {
            case er:
                return "Expresion Regular";
            case expresiones:
                return "Expresiones";
            case conjuntos:
                return "Conjuntos";
            case saber:
                return "saber";
            default:
                return "Saber";                        
        }
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public String getExpresion(){
        return this.expresion;
    }        
}
