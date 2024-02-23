import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }

    public void push(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return -1;
        } else {
            int elemento = cima.dato;
            cima = cima.siguiente;
            return elemento;
        }
    }

    public boolean isEmpty() {
        return cima == null;
    }

    public void mostrarPila() {
        Nodo actual = cima;
        System.out.print("Contenido de la pila: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public void enqueue(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (isEmpty()) {
            frente = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return -1;
        } else {
            int elemento = frente.dato;
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
            return elemento;
        }
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public void mostrarCola() {
        Nodo actual = frente;
        System.out.print("Contenido de la cola: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class PilasYColas {
    public static void main(String[] args) {
        Pila miPila = new Pila();
        Cola miCola = new Cola();
        Scanner scanner = new Scanner(System.in);
        int opcion, elemento;

        do {
            System.out.println("=== Menú de Operaciones ===");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Mostrar pila");
            System.out.println("4. Mostrar cola");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar: ");
                    elemento = scanner.nextInt();
                    miPila.push(elemento);
                    miCola.enqueue(elemento);
                    break;

                case 2:
                    int elementoPila = miPila.pop();
                    int elementoCola = miCola.dequeue();
                    if (elementoPila != -1 && elementoCola != -1) {
                        System.out.println("Elemento eliminado de la pila: " + elementoPila);
                        System.out.println("Elemento eliminado de la cola: " + elementoCola);
                    }
                    break;

                case 3:
                    miPila.mostrarPila();
                    break;

                case 4:
                    miCola.mostrarCola();
                    break;

                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
