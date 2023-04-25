package Ejercicio2;

import java.util.LinkedList;
public class TDA_BICOLA_LISTA<T> {
    LinkedList<T> bicola = new LinkedList<>();
    public boolean estavacia(){
        return bicola.isEmpty();
    }
    public void encolarInicio(T dato){
        bicola.add(0,dato);
    }
    public void encolarFinal(T dato){
        bicola.add(dato);
    }
    public T decolarInicio(){
        if(estavacia()){
            System.out.println("La cola està vacìa chatgptero");
            return null;
        }else{
            return bicola.remove(0);
        }

    }
    public T decolarFinal(){
        if(estavacia()){
            System.out.println("La cola està vacìa");
            return null;
        }else{
            return bicola.remove(bicola.size()-1);
        }

    }
    public T Peek(){
        return bicola.peek();
    }
    public T PeekLast() {
        return bicola.peekLast();
    }
    public int size() {
            return bicola.size();
    }
}
