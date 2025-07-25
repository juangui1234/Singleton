package persistence;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class GestorPersistencia {

    private static GestorPersistencia instancia;

    private GestorPersistencia() {}

    public static synchronized GestorPersistencia getInstance() {
        if (instancia == null) {
            instancia = new GestorPersistencia();
        }
        return instancia;
    }

    public <T extends Serializable> void guardarLista(String ruta, List<T> lista) {
        try {
            //crea archivo
            File archivo = new File(ruta);
            archivo.getParentFile().mkdirs(); //crea carpeta
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
                oos.writeObject(lista);
            }
        } catch (IOException e) {
                System.err.println("❌ Error al guardar datos: " + e.getMessage());
            }

    }

    public <T extends Serializable> List<T> cargarLista(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            return new ArrayList<>();
            //return null; //No hay datos, cuando el archivo no existe todavia

        }

               try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<T>) ois.readObject();
               } catch (EOFException e) { //retorna lista vacia
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Error al leer datos: " + e.getMessage());
        }
        return new ArrayList<>();
               //return null;
    }
}
