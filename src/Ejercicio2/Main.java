package Ejercicio2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    static TDA_BICOLA_LISTA<automovil> parqueadero = new TDA_BICOLA_LISTA();
    static Queue<automovil> espera = new LinkedList<>();
    static Stack<automovil> aux = new Stack<>();
    public static void main(String[] args) {
        llenarParqueadero();
        parquear(110);
        desaparcar(100);
        parquear(111);
        desaparcar(105);
        desaparcar(101);
        desaparcar(111);
        desaparcar(102);
    }

    public static void llenarParqueadero(){
        for (int i = 0; i < 10; i++) {
            automovil auto = new automovil(100+i);
            parqueadero.encolarFinal(auto);
        }
    }

    public static void parquear(int placa){
        automovil auto = new automovil(placa);
        if(parqueadero.size() == 10) {
            System.out.println("Cola llena pasa a cola de espera");
            espera.add(auto);
        } else {
            System.out.println("Entro al parqueadero");
            parqueadero.encolarFinal(auto);
        }
    }

    public static void desaparcar(int placa) {
        if(parqueadero.Peek().getPlaca() == placa) {
            moverAutos(parqueadero.size());
            System.out.println("Se desaparco el automovil con placa "+placa+" y se movio "+parqueadero.Peek().getMovimientos()+" veces");
            parqueadero.decolarInicio();
            if(!espera.isEmpty()) {
                parqueadero.encolarFinal(espera.poll());
                System.out.println("Saliendo de la cola de espera");
            }
        } else {
            while (parqueadero.Peek().getPlaca() != placa) {
                moverAutos(parqueadero.size());
                aux.add(parqueadero.decolarInicio());
            }
            moverAutos(parqueadero.size());
            System.out.println("Se desaparco el automovil con placa "+placa+" y se movio "+parqueadero.Peek().getMovimientos()+" veces");
            parqueadero.decolarInicio();
            while (!aux.isEmpty()) {
                aux.peek().setMovimientos(aux.peek().getMovimientos() + 1);
                parqueadero.encolarInicio(aux.pop());
            } if (!espera.isEmpty()) {
                parqueadero.encolarFinal(espera.poll());
                System.out.println("Saliendo de la cola de espera");
            }
        }
    }

    public static void moverAutos(int i) {
        if (i > 0) {
            parqueadero.Peek().setMovimientos(parqueadero.Peek().getMovimientos() + 1);
            parqueadero.encolarFinal(parqueadero.decolarInicio());
            moverAutos(i-1);
        }
    }
}