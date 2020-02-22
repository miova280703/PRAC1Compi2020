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
public class Token 
{
    public enum Tipo
    {
        palabra_reservada, identificador, llave_izquierda, llave_derecha, cadena, numero, punto_coma,
        dos_puntos, diagonal, menor_que, mayor_que, caracter, porcentaje, signo_menos, 
        signo_mas, signo_por, punto, signo_interrogacion, or, ultilmo, comillas, coma,
        parentesis_derecho, parentesis_izquierdo, corchete_derecho, corchete_izquierdo
    }
    
    public String lexema;
    public String idToken;
    public int linea;
    public int columna;
    public int indice;
    public Tipo tipotoken;
    
    public Token(String lexema, String idToken, Tipo tipotoken, int linea, int columna, int indice)
    {
        this.lexema=lexema;
        this.idToken=idToken;
        this.tipotoken=tipotoken;
        this.linea=linea;
        this.columna=columna;
        this.indice=indice;
    }
    
    public String getTipo()
    {
        switch(tipotoken)
        {
            case palabra_reservada:
                return "Palabra Reservada";
            case identificador:
                return "Identificador";
            case llave_izquierda:
                return "Llave Izquieda";
            case llave_derecha:
                return "Llave Derecha";
            case cadena:
                return "Cadena";
            case numero:
                return "Numero";
            case punto_coma:
                return "Punto Y Coma";
            case dos_puntos:
                return "Dos Puntos";
            case diagonal:
                return "Diagonal";
            case menor_que:
                return "Menor que";
            case mayor_que:
                return "Mayor que";
            case caracter:
                return "Caracter";
            case porcentaje:
                return "Signo Porcentaje";
            case signo_mas:
                return "Signo Mas";
            case signo_menos:
                return "Signo Menos";
            case signo_por:
                return "Signo Por";
            case punto:
                return "Punto";
            case signo_interrogacion:
                return "Signo de Interrogacion";
            case or:
                return "Or";
            case ultilmo:
                return "ultimo";
            case comillas:
                return "Comillas";
            case coma:
                return "Coma";
            case parentesis_derecho:
                return "Parentesis Derecho";
            case parentesis_izquierdo:
                return "Parentesis Izquierdo";
            case corchete_derecho:
                return "Corchete Derecho";
            case corchete_izquierdo:
                return "Corchete Izquierdo";
            default:
                return "Desconocido";                    
        }
    }
    
    public int getIndice()
    {
        return this.indice;
    }
    
    public String getLexema()
    {
        return this.lexema;
    }
    
    public String getIdToken()
    {
        return this.idToken;
    }
    
    public int getLinea()
    {
        return this.linea;
    }
    
    public int getColumna()
    {
        return this.columna;
    }
}
