/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relaciones1a1;

/**
 *
 * @author ramam
 */
public class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Foto foto;       // Composición
    private Persona persona; // Asociación bidireccional

    public Pasaporte(String numero, String fechaEmision, Foto foto, Persona persona) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = foto;
        this.persona = persona;
        persona.setPasaporte(this); // establecer relación bidireccional
    }

    public String getNumero() {
        return numero;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public Foto getFoto() {
        return foto;
    }

    public Persona getPersona() {
        return persona;
    }
}