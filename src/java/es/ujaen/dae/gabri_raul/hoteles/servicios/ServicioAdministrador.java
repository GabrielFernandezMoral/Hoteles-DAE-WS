package es.ujaen.dae.gabri_raul.hoteles.servicios;

import es.ujaen.dae.gabri_raul.hoteles.beans.BeanAdministrador;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorDatos;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorEliminar;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorPersistir;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelNoEncontrado;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorDatos;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorEliminar;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorErrorPersistir;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.OperadorNoEncontrado;
import es.ujaen.dae.gabri_raul.hoteles.modelos.Hotel;
import es.ujaen.dae.gabri_raul.hoteles.modelos.Operador;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Servicio para el Administrador
 *
 * @author Raúl & Gabri
 */
@WebService
@Component(value = "ServicioAdministrador")
public class ServicioAdministrador {

    @Autowired
    BeanAdministrador administrador;

    @WebMethod
    public void altaHotel(Hotel hotel) throws HotelErrorPersistir, HotelErrorDatos {
        administrador.altaHotel(hotel);
    }

    @WebMethod
    public Hotel obtenerHotel(String nombreHotel) {
        return administrador.obtenerHotel(nombreHotel);
    }

    @WebMethod
    public void bajaHotel(String nombreHotel) throws HotelErrorEliminar, HotelNoEncontrado {
        administrador.bajaHotel(nombreHotel);
    }

    @WebMethod
    public void altaOperador(Operador operador) throws OperadorErrorPersistir, OperadorErrorDatos {
        administrador.altaOperador(operador);
    }

    @WebMethod
    public Operador obtenerOperador(String cif) {
        return administrador.obtenerOperador(cif);
    }

    @WebMethod
    public void bajaOperador(String cif) throws OperadorNoEncontrado, OperadorErrorEliminar {
        administrador.bajaOperador(cif);
    }
}
