package pe.edu.ciberte.vehiculobackb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.ciberte.vehiculobackb.dto.VehiculoRequest;
import pe.edu.ciberte.vehiculobackb.dto.VehiculoResponse;
import pe.edu.ciberte.vehiculobackb.service.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoControlador {
    @Autowired
    VehiculoService vehiculoService;

    @PostMapping
    public VehiculoResponse buscarVehiculo(@RequestBody VehiculoRequest vehiculoRequest) {
        try {
            String[] datosAutos = vehiculoService.buscarVehiculo(vehiculoRequest);
            if (datosAutos == null) {
                return new VehiculoResponse("01", "Error: Auto no encontrado", "", "",
                        "", "", "");
            }
            return new VehiculoResponse("00", "", datosAutos[0], datosAutos[1],
                    datosAutos[2], datosAutos[3], datosAutos[4]);
        } catch (Exception e) {
            return new VehiculoResponse("99", "Error: Ocurrió un problema", "",
                    "", "", "", "");
        }
    }
}
