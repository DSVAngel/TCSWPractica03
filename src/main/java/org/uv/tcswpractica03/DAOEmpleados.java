/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sova
 */
public class DAOEmpleados implements IDAOGeneral<Empleados, Long> {

    @Override
    public boolean guardar(Empleados pojo) {
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();
        session.save(pojo);
        //Hacer el delete, el modificar(Hacer un get y despues un save)
        //Buscar la diferencia de get y load --- Criterial hql
        t.commit();
        return true;
    }

    @Override
    public Empleados eliminar(Long id) {
        Session session = HibernateUtils.getSession();
        Transaction t = null;
        Empleados empleado = null;
        try {
            t = session.beginTransaction();
            empleado = session.get(Empleados.class, id);
            if (empleado != null) {
                session.delete(empleado);
            }
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empleado; // Devuelve el objeto eliminado o null si no existía
    }

    @Override
    public Empleados modificar(Empleados pojo, Long id) {
        Session session = HibernateUtils.getSession();
        Transaction t = null;
        Empleados empleadoExistente = null;

        try {
            t = session.beginTransaction();
            empleadoExistente = session.get(Empleados.class, id);

            if (empleadoExistente != null) {
                empleadoExistente.setNombre(pojo.getNombre());
                empleadoExistente.setDireccion(pojo.getDireccion());
                empleadoExistente.setTelefono(pojo.getTelefono());

                session.update(empleadoExistente);
            }
            t.commit();

        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empleadoExistente;
    }

    @Override
    public Empleados findByID(Long id) {
        Session session = HibernateUtils.getSession();
        Empleados empleado = null;
        try {
            empleado = session.get(Empleados.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empleado;
    }

    @Override
    public List<Empleados> findAll() {
        Session session = HibernateUtils.getSession();
        List<Empleados> empleados = null;
        try {
            // Modifica la consulta para que también "busque y una" el departamento
            String hql = "FROM Empleados e LEFT JOIN FETCH e.departamento";
            empleados = session.createQuery(hql, Empleados.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empleados;
    }

    public List<Empleados> findByDepartamento(Long idDepartamento) {
        Session session = HibernateUtils.getSession();
        List<Empleados> empleados = null;
        try {
            String hql = "FROM Empleados e WHERE e.departamento.clave = :idDepto";
            empleados = session.createQuery(hql, Empleados.class)
                    .setParameter("idDepto", idDepartamento)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empleados;
    }

    public List<Empleados> findEmpleadosSinDepartamento() {
        Session session = HibernateUtils.getSession();
        List<Empleados> empleados = null;
        try {
            // HQL para buscar empleados donde la 'clave' del departamento es 0
            String hql = "FROM Empleados e WHERE e.departamento.clave = :idDepto";
            empleados = session.createQuery(hql, Empleados.class)
                    .setParameter("idDepto", 0L) // Se establece el parámetro a 0 (Long)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empleados;
    }

}
