package es.ujaen.dae.gabri_raul.hoteles.servicios;

import es.ujaen.dae.gabri_raul.hoteles.beans.BeanOperador;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorActualizar;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorBloquear;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelNoEncontrado;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.ReservaErrorCambiarUsuario;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.ReservaErrorDatos;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.ReservaNoEncontrada;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.ReservaNoPosible;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.UsuarioErrorDatos;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.UsuarioErrorEliminar;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.UsuarioErrorPersistir;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.UsuarioNoEncontrado;
import es.ujaen.dae.gabri_raul.hoteles.modelos.Operador;
import es.ujaen.dae.gabri_raul.hoteles.modelos.Reserva;
import es.ujaen.dae.gabri_raul.hoteles.modelos.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
            throws UsuarioErrorDatos, UsuarioErrorPersistir {
        operador.altaUsuario(nombre, direccion, dni);
    }

    @WebMethod
    public Usuario obtenerUsuario(String dni) {
        return operador.obtenerUsuario(dni);
    }

    @WebMethod
    public void bajaUsuario(String dni)
            throws UsuarioErrorEliminar, UsuarioNoEncontrado, ReservaErrorCambiarUsuario {
        operador.bajaUsuario(dni);
    }

    @WebMethod
    public Operador login(String cif, String pass) {
        return operador.login(cif, pass);
    }

    @WebMethod
    public List consultaNombreHotel(String nombre) {
        return new ArrayList(operador.consultaNombreHotel(nombre).values());
    }

    @WebMethod
    public List consultaCiudad(String ciudad) {
        return new ArrayList(operador.consultaCiudad(ciudad).values());
    }

    @WebMethod
    public List consultaFecha(String ciudad, Date fechaEntrada, Date fechaSalida) {
        return new ArrayList(operador.consultaFecha(ciudad, fechaEntrada, fechaSalida).values());
    }

    @WebMethod
    public void crearReserva(Date fechaEntrada, Date fechaSalida, Integer simples, Integer dobles, Integer triples, String dni, String nombreHotel)
            throws UsuarioNoEncontrado, HotelErrorBloquear, HotelNoEncontrado, ReservaErrorDatos, ReservaNoPosible, HotelErrorActualizar {
        operador.crearReserva(fechaEntrada, fechaSalida, simples, dobles, triples, dni, nombreHotel);
    }

    @WebMethod
    public Reserva obtenerReserva(int id) {
        return operador.obtenerReserva(id);
    }

    @WebMethod
    public void eliminarReserva(int id) throws HotelErrorActualizar, ReservaNoEncontrada {
        operador.eliminarReserva(id);
    }

    @WebMethod
    public List listaUsuarios() {
        return new ArrayList(operador.listaUsuarios().values());
    }

    @WebMethod
    public List listadoReservas() {
        return new ArrayList(operador.listadoReservas().values());
    }
}
