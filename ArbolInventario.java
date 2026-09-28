public class ArbolInventario {
    private Producto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    // Método público para insertar
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    // Método recursivo para ubicar el producto por ID (ABB)
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        if (actual == null) {
            return new Producto(id, nombre);
        }
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        } else {
            System.out.println("El ID ya existe en el inventario.");
        }
        return actual;
    }

    // Método público para mostrar el inventario (Inorden)
    public void mostrarInorden() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("\n--- INVENTARIO DE PRODUCTOS (ORDENADO) ---");
            inordenRecursivo(raiz);
            System.out.println("------------------------------------------");
        }
    }

    // Recorrido Inorden (Izquierda, Raíz, Derecha)
    private void inordenRecursivo(Producto nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.println("ID: " + nodo.id + " | Nombre: " + nodo.nombre);
            inordenRecursivo(nodo.derecho);
        }
    }

    // Método público para buscar un producto por ID
    public boolean buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    // Búsqueda recursiva en el ABB
    private boolean buscarRecursivo(Producto nodo, int id) {
        if (nodo == null) {
            return false;
        }
        if (nodo.id == id) {
            return true;
        }
        return id < nodo.id ? buscarRecursivo(nodo.izquierdo, id) : buscarRecursivo(nodo.derecho, id);
    }
}