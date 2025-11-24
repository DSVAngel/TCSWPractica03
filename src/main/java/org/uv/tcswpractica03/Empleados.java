package org.uv.tcswpractica03;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "empleados2")
public class Empleados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleados2_clave_seq")
    @SequenceGenerator(name = "empleados2_clave_seq", sequenceName = "empleados2_clave_seq", initialValue = 1, allocationSize = 1)
    private Long clave;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 200)
    private String direccion;

    @Column(length = 20)
    private String telefono;


    // Getters y Setters
    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return this.getNombre();
    }
}
