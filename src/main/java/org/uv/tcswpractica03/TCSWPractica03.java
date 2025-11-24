/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.tcswpractica03;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ssova
 */
public class TCSWPractica03 {

    public static void main(String[] args) {
   /*
        Departamentos
            PK Clave
            Nombre
            Empleados <List> o <Set>
        One to Many

        Empleados
            PK Clave Serial
            Nombre
            Direccion
            Telefono
            FK Departamento Serial
        Many to one
        Leer Eager y Lazzy
        
        Eager
        Cuando cargas una entidad, también carga automáticamente todas las relaciones marcadas como EAGER, sin importar si las usas o no.
        Lazzy 
        Cuando cargas una entidad, NO trae inmediatamente las relaciones; en su lugar, se crean proxies (referencias vacías) y solo se hace la consulta a la BD cuando realmente accedes al atributo.
        */
    }
}
