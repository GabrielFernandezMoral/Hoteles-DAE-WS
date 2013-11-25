package es.ujaen.dae.gabri_raul.hoteles.dao;

import es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorActualizar;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorEliminar;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorPersistir;
import es.ujaen.dae.gabri_raul.hoteles.modelos.Operador;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

/**
 * Clase utilizada para trabajar con la BBDD
 *
 * @author Raúl & Gabri
 */
@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OperadorDAO {

    @PersistenceContext
    EntityManager em;

    public OperadorDAO() {

    }

    /**
     * @param cif Clave para buscar el operador
     * @return Devuelve un objeto de tipo operador o null si no lo encuentra.
     */
    @Cacheable(value = "operadores", key = "#cif")
    public Operador buscar(String cif) {
        return em.find(Operador.class, cif);
    }

    /**
     * Persiste en la BBDD un operador.
     *
     * @param operador
     * @throws OperadorErrorPersistir
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false,
            rollbackFor = es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorPersistir.class)
    public void insertar(Operador operador) throws OperadorErrorPersistir {
        try {
            em.persist(operador);
            em.flush();
        } catch (Exception e) {
            throw new OperadorErrorPersistir();
        }
    }

    /**
     * Actualizar en la BBDD un operador
     *
     * @param operador
     * @throws OperadorErrorActualizar
     */
    @CacheEvict(value = "operadores", key = "#operador.getCif()")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false,
            rollbackFor = es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorActualizar.class)
    public void actualizar(Operador operador) throws OperadorErrorActualizar {
        try {
            em.merge(operador);
            em.flush();
        } catch (Exception e) {
            throw new OperadorErrorActualizar();
        }
    }

    /**
     * Elimina en la BBDD un operador
     *
     * @param operador
     * @throws OperadorErrorEliminar
     */
    @CacheEvict(value = "operadores", key = "#operador.getCif()")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false,
            rollbackFor = es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorEliminar.class)
    public void eliminar(Operador operador) throws OperadorErrorEliminar {
        try {
            em.remove(em.contains(operador) ? operador : em.merge(operador));
            em.flush();
        } catch (Exception e) {
            throw new OperadorErrorEliminar();
        }
    }
}
