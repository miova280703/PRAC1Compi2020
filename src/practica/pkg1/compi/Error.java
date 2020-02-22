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
public class Error 
{
    public enum TipoError
    {
        lexico,sintactico
    }
    
    String lexema;
    String idToken;
    int linea;
    int columna;
    TipoError tipo_error;
    
    public Error(String lexema, String idToken, TipoError tipo_error, int linea, int columna)
    {
        this.lexema=lexema;
        this.idToken=idToken;
        this.linea=linea;
        this.columna=columna;
        this.tipo_error=tipo_error;
    }
    
    public String getTipoError()
    {
        switch(tipo_error)
        {
            case lexico:
                return "Error Lexico";
            case sintactico:
                return "Error Sintactico";
            default:
                return "!!ERROR!!";
        }
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
