package es.ujaen.dae.gabri_raul.hoteles.servicios;

import es.ujaen.dae.gabri_raul.hoteles.beans.BeanOperador;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.UsuarioErrorDatos;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.UsuarioErrorPersistir;
import es.ujaen.dae.gabri_raul.hoteles.modelos.Usuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Servicio para el Operador
 *
 * @author Raúl & Gabri
 */
@WebService
@Component(value = "ServicioOperador")
public class ServicioOperador {

    @Autowired
    BeanOperador operador;

    @WebMethod
    public void altaUsuario(String nombre, String direccion, String dni) 
            throws UsuarioErrorDatos, UsuarioErrorPersistir{
        operador.altaUsuario(nombre, direccion, dni);
    }
    
    @WebMethod
    public Usuario obtenerUsuario(String dni) {
        return operador.obtenerUsuario(dni);
    }
}
