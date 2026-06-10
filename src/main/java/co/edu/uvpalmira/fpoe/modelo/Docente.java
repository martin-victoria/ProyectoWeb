/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.modelo;

import co.edu.uvpalmira.fpoe.jpalib.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

/**
 *
 * @author marti
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Docente.buscarPorNuip", query = "SELECT d FROM Docente d WHERE d.nuip = :nuip")})
public class Docente extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private long nuip;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String profesion;

    public Docente() {
    }

    public Docente(long nuip, String nombres, String apellidos, String genero, String profesion) {
        this.nuip = nuip;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.profesion = profesion;
    }

    public long getNuip() {
        return nuip;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setNuip(long nuip) {
        this.nuip = nuip;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

}
