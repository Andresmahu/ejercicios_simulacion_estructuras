import java.util.*;

public class Main {
    static Queue<avion> cola1 = new LinkedList<>();
    static Queue<avion> cola2 = new LinkedList<>();
    static Queue<avion> cola3 = new LinkedList<>();
    static Queue<avion> cola4 = new LinkedList<>();
    static Queue<avion> cola5 = new LinkedList<>();
    static ArrayList<Queue<avion>> colaDespegues = new ArrayList<>();
    static Random random = new Random();
    public static void main(String[] args) {
        llenarcolas();
        colaDespegues.add(cola1);
        colaDespegues.add(cola2);
        colaDespegues.add(cola3);
        colaDespegues.add(cola4);
        colaDespegues.add(cola5);
        despegue(5);
    }
    public static void llenarcolas(){
        for (int i = 0; i < 20; i++) {
            avion avion1 = new avion();
            avion1.setDistancia(random.nextInt(2000-100+1)+100);
            if(avion1.getDistancia()<500){
                cola1.add(avion1);
            }
            if(avion1.getDistancia()>=500&&avion1.getDistancia()<800){
                cola2.add(avion1);
            }
            if(avion1.getDistancia()>=800&&avion1.getDistancia()<1000){
                cola3.add(avion1);
            }
            if(avion1.getDistancia()>=1000&&avion1.getDistancia()<1350){
                cola4.add(avion1);
            }
            if(avion1.getDistancia()>=1350){
                cola5.add(avion1);
            }
            avion1.setAveria(random.nextBoolean());
            avion1.setTiempo(0);
        }
    }

    public static void despegue(int prioridad){
        while (!colaDespegues.get(prioridad-1).isEmpty()){
            colaDespegues.get(prioridad-1).peek().setAveria(random.nextBoolean());
            if (!colaDespegues.get(prioridad-1).peek().isAveria()){
                colaDespegues.get(prioridad-1).peek().setTiempo(random.nextInt(31));
                if(colaDespegues.get(prioridad-1).peek().getTiempo()>=6&&colaDespegues.get(prioridad-1).peek().getTiempo()<20){
                    colaDespegues.get(prioridad-1).poll();
                    System.out.println("Despego aeronave");
                }
                else if(colaDespegues.get(prioridad-1).peek().getTiempo()<6){
                    colaDespegues.get(prioridad-1).add(colaDespegues.get(prioridad-1).poll());
                    System.out.println("No cumple tiempo, pasa al final de la cola");
                }
                else if(colaDespegues.get(prioridad-1).peek().getTiempo()>=20){
                    colaDespegues.get(prioridad%5).add(colaDespegues.get(prioridad-1).poll());
                    System.out.println("Pasa a la siguiente cola");
                }
            }else{
                System.out.println("Problemas al despegar pasa al final de la cola");
                colaDespegues.get(prioridad-1).add(colaDespegues.get(prioridad-1).poll());
            }
          }

    }



}