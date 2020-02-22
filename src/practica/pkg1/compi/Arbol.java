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
public class Arbol 
{
    Nodo raiz;
    int d=1;

    public void agregar(String nombre)
    {
        raiz = agregar(raiz , nombre).getAux();        
    }
    
    private respuesta agregar (Nodo nuevo, String nombre){
        boolean respuesta = false;
        

        if(nuevo == null){
            
            nuevo = new Nodo(nombre);            
            respuesta = true;
            
        }else{
            //validando simbolos unarios
            if(nuevo.nombre.equals("+")||nuevo.nombre.equals("*")||nuevo.nombre.equals("?")){                
                respuesta temp = agregar(nuevo.iz, nombre);
                if(temp.respuesta==true){
                    nuevo.iz = temp.aux;
//                    nuevo.hijos.add(temp.aux);
                    respuesta = true;
                }
            }//validando simbolos no unarios Los que concatenan
            else if(nuevo.nombre.equals("|")||nuevo.nombre.equals(".")){
                //System.out.println("ENTRO A DERECHA");
                respuesta temp = agregar(nuevo.iz, nombre);
                if(temp.respuesta==true){
                    nuevo.iz = temp.aux;
//                    nuevo.hijos.add(temp.aux);
                    respuesta = true;
                }else{
                    respuesta temp2 = agregar(nuevo.der , nombre);
                    if(temp2.respuesta== true){
                        nuevo.der = temp2.aux;
//                        nuevo.hijos.add(temp2.aux);
                        respuesta = true;
                    }
                }
            }
        }
        
        
        return new respuesta(nuevo, respuesta);
        
        
    }

        public void graficar(String path) {
        raiz.graficar(path);
    }
        
private class respuesta{
        public Nodo aux;
        public boolean respuesta;
        
        public respuesta(Nodo nuevo, boolean res){
            this.aux = nuevo;
            this.respuesta = res;
        }

        public Nodo getAux() {
            return aux;
        }

        public void setAux(Nodo aux) {
            this.aux = aux;
        }

        public boolean isRespuesta() {
            return respuesta;
        }

        public void setRespuesta(boolean respuesta) {
            this.respuesta = respuesta;
        }        
    } 
}
