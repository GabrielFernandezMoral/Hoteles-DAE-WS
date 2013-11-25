package es.ujaen.dae.gabri_raul.hoteles.servicios;

import es.ujaen.dae.gabri_raul.hoteles.beans.BeanHotel;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorActualizar;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorBloquear;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelErrorReserva;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.HotelNoEncontrado;
import es.ujaen.dae.gabri_raul.hoteles.excepciones.ReservaNoPosible;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Servicio para el Hotel
 *
 * @author Raúl & Gabri
 */
@WebService
@Component(value = "ServicioHotel")
public class ServicioHotel {

    @Autowired
    BeanHotel hotel;

    @WebMethod
    public List consultarReservas(String nombreHotel) {
        return (List) hotel.consultarReservas(nombreHotel).values();
    }

    @WebMethod
    public void crearReserva(Date fechaEntrada, Date fechaSalida, Integer simples, Integer dobles, Integer triples, String nombreHotel)
            throws ReservaNoPosible, HotelNoEncontrado, HotelErrorReserva, HotelErrorBloquear, HotelErrorActualizar {
        hotel.crearReserva(fechaEntrada, fechaSalida, simples, dobles, triples, nombreHotel);
    }
}
