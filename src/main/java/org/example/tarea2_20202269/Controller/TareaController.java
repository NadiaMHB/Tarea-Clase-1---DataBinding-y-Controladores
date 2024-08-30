package org.example.tarea2_20202269.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TareaController {

    //PRIMERA PARTE SIN MODEL
    @GetMapping("/formulario")
    public String formularioPersona (){
        return "formulario";
    }


    @PostMapping("/formulario/guardar")
    public String guardarPersona( Informacion informacion){
        System.out.println("Nombre: " + informacion.getNombre() + "\n" +
                "Apellido: " + informacion.getApellido() + "\n" +
                "Dni: " + informacion.getDni() + "\n" +
                "Código PUCP: " + informacion.getCodigoPucp() + "\n" +
                "Dirección: " + informacion.getDireccion());
        return "formulario";
    }

    //-----------------------------------------------------------------

    //ACTIVIDAD 4

    List<Informacion> estudiantes = new ArrayList<>();

    @GetMapping("/formulario2")
    public String formularioPersona2(Model model) {
        Informacion datos = new Informacion();
        model.addAttribute("persona", datos);
        return "formulario2";
    }

    @PostMapping("/formulario2/guardar2")
    public String guardarPersona2(@RequestParam("nombre") String nombre,
                                  @RequestParam("apellido") String apellido,
                                  @RequestParam("dni") String dni,
                                  @RequestParam("codigoPucp") String codigoPucp,
                                  @RequestParam("direccion") String direccion,
                                  Model model) {

        Informacion nuevaPersona = new Informacion(nombre, apellido, dni, codigoPucp, direccion);
        estudiantes.add(nuevaPersona);

        model.addAttribute("estudiantes", estudiantes);

        return "listaEstudiantes";
    }

    @GetMapping("/listaEstudiantes")
    public String listaEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantes";
    }

    //--------------------------------------------------------------

    //ACTIVIDAD 5 USANDO DATA BINDING
    @PostMapping("/formulario2/guardar3")
    public String guardarPersona3(@ModelAttribute("persona") Informacion nuevaPersona, Model model) {
        estudiantes.add(nuevaPersona);
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantes";
    }

}



