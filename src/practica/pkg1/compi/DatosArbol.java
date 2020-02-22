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
public class DatosArbol {
    
    public enum Tipo_Caracter
    {
        concatenacion,
        or,
        asterisco,
        mas,
        interrogacion,
        hoja
    }
    
    String valor;
    Tipo_Caracter tipo;
    
    public DatosArbol(String valor, Tipo_Caracter tipo)
    {
        this.valor=valor;
        this.tipo=tipo;
    }
    
    public String getTipo_Caracter(){
        switch(tipo){
            case concatenacion:
                return "Concatenacion";
            case or:
                return "Or";
            case asterisco:
                return "Asterisco";
            case mas:
                return "Mas";
            case interrogacion:
                return "Interrogacion";
            case hoja:
                return "Hoja";
            default:
                return " ";
        }
    }
    
    public String getValor(){
        return this.valor;
    }
}
