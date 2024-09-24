package pe.edu.ciberte.vehiculobackb.service;

import pe.edu.ciberte.vehiculobackb.dto.VehiculoRequest;

import java.io.IOException;

public interface VehiculoService {
    String[] buscarVehiculo(VehiculoRequest vehiculoRequest) throws IOException;
}
