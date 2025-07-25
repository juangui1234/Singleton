package dao;

import dto.MascotaDTO;
import persistence.GestorPersistencia;

import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
    private final String ruta = "data/mascotas.dat";
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();

    private MascotaDAO() {

    }
    //singleton para MascotaDAO
    private static MascotaDAO instancia;

    public static MascotaDAO getInstancia() {
        if (instancia == null) {
            instancia = new MascotaDAO();
        }
        return instancia;
    }

    public void guardar(MascotaDTO mascota) {
        List<MascotaDTO> lista = listar();
        lista.add(mascota);
        gestor.guardarLista(ruta, lista);
    }

    public List<MascotaDTO> listar() {
        List<MascotaDTO> lista = gestor.cargarLista(ruta);
        return lista != null ? lista : new ArrayList<>();
    }

    public void eliminar(int indice) {
        List<MascotaDTO> lista = listar();
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            gestor.guardarLista(ruta, lista);
        }
    }

    public void actualizar(int indice, MascotaDTO mascotaActualizada) {
        List<MascotaDTO> lista = listar();
        if (indice >= 0 && indice < lista.size()) {
            lista.set(indice, mascotaActualizada);
            gestor.guardarLista(ruta, lista);
        }
    }

}
