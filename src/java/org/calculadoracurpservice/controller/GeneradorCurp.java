package org.calculadoracurpservice.controller;

import org.calculadoracurpservice.model.Ciudadano;

/**
 *
 * @author beniblo
 */
public class GeneradorCurp {

    public static String preFechaNacimiento(Ciudadano ciudadano) {
        return String.valueOf(ciudadano.getApellidoPaterno().charAt(0)) + 
                localizarVocal(ciudadano.getApellidoPaterno()) + 
                (ciudadano.getApellidoMaterno().isEmpty() ? 'X' : ciudadano.getApellidoMaterno().charAt(0)) +
                obtenerLetraNombre(ciudadano.getPrimerNombre(), ciudadano.getSegundoNombre());
    }

    private static char localizarVocal(String cadena) {
        for (int i = 1; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if ("AEIOUaeioÁÉÍÓMÚuáéíóú".indexOf(c) != -1) {
                return Character.toUpperCase(c);
            }
        }
        return 'X';
    }

    private static char obtenerLetraNombre(String primerNombre, String segundoNombre) {
        boolean esNombreEspecial = primerNombre.equalsIgnoreCase("José") || 
                                  primerNombre.equalsIgnoreCase("María");
        boolean haySegundoNombre = segundoNombre != null && !segundoNombre.isEmpty();

        return (esNombreEspecial && haySegundoNombre) ? 
               segundoNombre.charAt(0) : primerNombre.charAt(0);
    }

    private static String formatearFecha(String fechaNacimiento) {
        String dia = fechaNacimiento.substring(0, 2);
        String mes = fechaNacimiento.substring(2, 4);
        String anio = fechaNacimiento.substring(4);
        return anio.substring(2) + mes + dia; // Extrae últimos 2 dígitos del año
    }

    private static String obtenerCodigoEntidad(String entidad) {
        return entidad.substring(0, 2);
    }

    private static char obtenerConsonanteInterna(String cadena) {
        for (int i = 1; i < cadena.length(); i++) {
            char c = Character.toUpperCase(cadena.charAt(i));
            if ("BCDFGHJKLMNÑPQRSTVWXYZ".indexOf(c) != -1) {
                return (c == 'Ñ') ? 'X' : c; // Reemplaza Ñ por X
            }
        }
        return 'X';
    }

    public static String generarCurpCompleta(Ciudadano ciudadano) {
        // 1. Primeras 4 letras (apellidos y nombre)
        String curp = preFechaNacimiento(ciudadano);

        // 2. Fecha de nacimiento (AAMMDD)
        curp += formatearFecha(ciudadano.getFechaDeNacimiento());

        // 3. Género (H/M)
        curp += Character.toUpperCase(ciudadano.getGenero());

        // 4. Entidad federativa (2 letras)
        curp += obtenerCodigoEntidad(ciudadano.getEntidad());

        // 5. Consonantes internas
        curp += obtenerConsonanteInterna(ciudadano.getApellidoPaterno());
        curp += (ciudadano.getApellidoMaterno().isEmpty()) ? 'X' : 
                obtenerConsonanteInterna(ciudadano.getApellidoMaterno());
        curp += obtenerConsonanteInterna(ciudadano.getPrimerNombre());

        // 6. Dígitos aleatorios (inicialmente 01)
        curp += "A3";

        // 7. Validar y corregir palabras soeces
        if (esPalabraSoez(curp.substring(0, 4))) {
            curp = curp.substring(0, 1) + "X" + curp.substring(2);
        }

        return curp.toUpperCase();
    }

    private static boolean esPalabraSoez(String iniciales) {
        String[] palabrasProhibidas = {"BUEI", "CACA", "CAGA", "CAKA", "COGE", "COJA", "COJE", 
                                      "CULO", "GUEY", "KACA", "KAGA", "KOGE", "KAKA", "MAME", 
                                      "MAMO", "MEAR", "MEON", "MION", "MOCO", "PEDA", "PENE", 
                                      "PUTA", "QULO", "RATA", "RUIN", "PEDO", "PITO", "PUTO", "JOTO"};
        for (String palabra : palabrasProhibidas) {
            if (iniciales.equals(palabra)) {
                return true;
            }
        }
        return false;
    }
}
