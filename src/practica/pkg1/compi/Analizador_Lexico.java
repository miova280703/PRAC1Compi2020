/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.compi;

import java.util.ArrayList;
import practica.pkg1.compi.Error.TipoError;
import practica.pkg1.compi.Token.Tipo;

/**
 *
 * @author iova
 */
public class Analizador_Lexico 
{
    static public ArrayList<Token> lista_tokens;
    static public ArrayList<Error> lista_errores;
    ArrayList tokens;
    
    public Analizador_Lexico()
        {
        lista_tokens = new ArrayList<Token>();
        lista_errores = new ArrayList<Error>();
        tokens = new ArrayList();
        tokens.add("conj");
    }
    
    public void addToken(String idToken, String lexema, Tipo tipo, int linea, int columna, int indice)
    {
        Token nuevo = new Token(lexema, idToken, tipo, linea, columna, indice);
        lista_tokens.add(nuevo);
    }
    
    public void addError(String lexema, String idToken, TipoError tipo, int linea, int columna)
    {
        Error nuevo = new Error(lexema, idToken, tipo, linea, columna);
        lista_errores.add(nuevo);
    }
    
    static boolean el = false;
    public void escaner(String entrada)
    {
        int estado = 0;
        int columna = 0;
        int fila = 1;
        String lexema = "";
        String lexi = "";
        char c;
        char h;
        entrada = entrada + "#"+ "#";
        char[] ch_entrada = entrada.toCharArray();
        for(int i = 0; i < ch_entrada.length-1; i++)
        {
            c = ch_entrada[i];
            h = ch_entrada[i+1];
            columna++;
            switch(estado)
            {
                case 0:
                    if(Character.isLetter(c))
                    {
                        estado = 1;
                        lexema += c;
                    }
                    else if(Character.isDigit(c))
                    {
                        estado = 2;
                        lexema += c;
                    }
                    else if(c == '"')
                    {
                        estado = 5;
                        i--;
                        columna--;
                    }
                    else if(c == '/')
                    {
                        estado = 8;
                        i--;
                        columna--;
                    }
                    else if(c == '<')
                    {
                        estado = 11;
                        i--;
                        columna--;
                    }
                    else if(c == ',')
                    {
                        estado = 6;
                        i--;
                        columna--;
                    }
                    else if(c == ' ')
                    {
                        estado = 0;
                    }
                    else if (c == '\n')
                    {
                        columna = 0;
                        fila++;
                        estado = 0;
                    }
                    else if (c == '\t')
                    {
                        columna++;
                        estado = 0;
                    }
                    else if(c == '{')
                    {
                        lexema += c;
                        addToken("1", lexema, Tipo.llave_izquierda, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '}')
                    {
                        lexema += c;
                        addToken("2", lexema, Tipo.llave_derecha, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == ';')
                    {
                        lexema += c;
                        addToken("3", lexema, Tipo.punto_coma, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == ':')
                    {
                        lexema += c;
                        addToken("4", lexema, Tipo.dos_puntos, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '(')
                    {
                        lexema += c;
                        addToken("11", lexema, Tipo.parentesis_izquierdo, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == ')')
                    {
                        lexema += c;
                        addToken("12", lexema, Tipo.parentesis_derecho, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '[')
                    {
                        lexema += c;
                        addToken("13", lexema, Tipo.corchete_izquierdo, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == ']')
                    {
                        lexema += c;
                        addToken("14", lexema, Tipo.corchete_derecho, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '!')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '$')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }    
                    else if(c == '%')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '&')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '@')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '\\')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }     
                    else if(c == '^')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '_')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '~')
                    {
                        lexema += c;
                        addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '?')
                    {
                        lexema += c;
                        addToken("16", lexema, Tipo.signo_interrogacion, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '*')
                    {
                        lexema += c;
                        addToken("17", lexema, Tipo.signo_por, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '+')
                    {
                        lexema += c;
                        addToken("18", lexema, Tipo.signo_mas, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '|'){
                        lexema += c;
                        addToken("19", lexema, Tipo.or, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '-')
                    {
                        lexema += c;
                        addToken("20", lexema, Tipo.signo_menos, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == ',')
                    {
                        lexema += c;
                        addToken("21", lexema, Tipo.coma, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '.')
                    {
                        lexema += c;
                        addToken("22", lexema, Tipo.punto, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '>'){
                        lexema += c;
                        addToken("23", lexema, Tipo.mayor_que, fila, columna, i - ch_entrada.length);
                        lexema = "";
                    }
                    else if(c == '#')
                    {
                        lexema += c;
                        if(i == ch_entrada.length-1 || i == ch_entrada.length - 2)
                        {
//                            addToken("-2", lexema, Tipo.ultilmo, fila, columna, i - ch_entrada.length);
                        }      
                        else
                        {
                            addToken("15", lexema, Tipo.caracter, fila, columna, i - ch_entrada.length);
                        }
                        lexema = "";
                    }
                    else
                    {
                        estado = -99;
                        i--;
                        el=true;
                        columna--;
                    }
                    break;
                case 1:
                    if(Character.isLetterOrDigit(c) || c == '_' || c == ',' || c == '-')
                    {
                        lexema += c;
                        estado = 1;
                    }
                    else
                    {
                        Boolean encontrado = false;
                        encontrado = BUSCAR_PR(lexema);
                        if(encontrado)
                        {
                            addToken("5", lexema, Tipo.palabra_reservada, fila, columna, i - ch_entrada.length);
                        }else
                        {
                            addToken("6", lexema, Tipo.identificador, fila, columna, i - ch_entrada.length);
                        }
                        lexema = "";
                        i--;
                        columna--;
                        estado = 0;
                    }
                    break;
                case 2:
                    if(Character.isDigit(c))
                    {
                        lexema += c;
                        estado = 2;
                    }
                    else if( c == '.')
                    {
                        estado = 3;
                        lexema += c;
                    }
                    else
                    {
                        addToken("7", lexema, Tipo.numero, fila, columna, i - ch_entrada.length);
                        lexema = "";
                        i--;
                        columna--;
                        estado = 0;
                    }
                    break;
                case 3:
                    if(Character.isDigit(c))
                    {
                        estado = 4;
                        lexema += c;                        
                    }
                    else
                    {
                        addError(lexema,"Se esperaba un digito [" + lexema + "]",TipoError.lexico, fila, columna);
                        lexema = "";
                        estado = 0;
                        el=true;
                    }
                    break;
                case 4:
                    if(Character.isDigit(c))
                    {
                        estado = 4;
                        lexema += c;
                    }
                    else
                    {
                        addToken("7", lexema, Tipo.numero, fila, columna, i - ch_entrada.length);
                        lexema = "";
                        i--;
                        columna--;
                        estado = 0;
                    }
                    break;
                case 5:
                    if(c == '"'){
                        lexema += c;
                        addToken("8", lexema, Tipo.comillas, fila, columna, i - ch_entrada.length);
                        lexema = "";
                        estado = 6;
                    }
                    break;
                case 6:
                    if(c != '"')
                    {
                        lexema += c;
                        estado = 6;
                    }
                    else
                    {
                        estado = 7;
                        addToken("9", lexema, Tipo.cadena, fila, columna, i - ch_entrada.length);
                        lexema = "";
                        i--;
                        columna--;
                    }
                    break;
                case 7:
                    if(c=='"')
                    {
                        lexema += c;
                        addToken("8", lexema, Tipo.comillas, fila, columna, i - ch_entrada.length);
                        lexema = "";
                        estado = 0;
                    }
                    else if(c==','){
                        lexema += c;
                        addToken("10", lexema, Tipo.coma, fila, columna, i - ch_entrada.length);
                        lexema = "";
                        estado = 0;
                    }
                    break;
                case 8:
                    if(c == '/')
                    {
                        lexi +=c;
                        lexema = "";
                        estado = 9;
                    }
                    break;
                case 9:
                    if(c == '/')
                    {
                        lexema = "";
                        estado = 10;
                    }
                    else
                    {
                        addToken("24", lexi, Tipo.coma, fila, columna, i - ch_entrada.length);
                        lexi = "";
                        lexema = "";
                        estado = 0;
                    }
                    break;
                case 10:
                    if(c != '\n')
                    {
                        lexema += c;
                        estado = 10;
                    }
                    else
                    {
                        estado = 0;
                        lexema = "";
                        i--;
                        columna--;
                    }
                    break;                    
                case 11:                    
                    if(c == '<')
                    {
                        lexi += c;
                        lexema = "";
                        estado = 12;
                    }
                    break;
                case 12:
                    if(c == '!')
                    {
                        lexema = "";
                        estado=13;
                    }
                    else
                    {
                        addToken("25", lexi, Tipo.menor_que, fila, columna, i - ch_entrada.length);
                        lexi = "";
                        lexema = "";
                        estado = 0;
                    }
                    break;
                case 13:
                    if(c != '!' || h != '>')
                    {
                        lexema += c;
                        estado = 13;
                    }
                    else
                    {
                        estado=14;
                        lexema = "";
                        i--;
                        columna--;
                    }
                    break;
                case 14:
                    if(c == '!')
                    {
                        lexema="";
                        estado=15;
                    }
                    break;
                case 15:
                    if(c == '>')
                    {
                        lexema="";
                        estado=0;
                    }
                    break;
                case -99:
                    lexema += c;
                    addError(lexema, "Caracter Desconocido", TipoError.lexico, fila, columna);
                    System.out.println("estoy aqui estupida "+lexema);
                    estado = 0;
                    lexema = "";
                    break;
            }
        }
    }
        
    public int estado_token;
    public Boolean BUSCAR_PR(String entrada){
        Boolean enco = false;
        for(int i = 0; i < tokens.size(); i++) 
        {
            if(entrada.equals(tokens.get(i).toString()))
            {
                enco = true;
                estado_token = i;
                return enco;    
            }
            else
            {
                enco = false;
            }
        }
        return enco;
    }
    
    public ArrayList<Token> getListaTokens()
    {
        return lista_tokens;
    }
}
