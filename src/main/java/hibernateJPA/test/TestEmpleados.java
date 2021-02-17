package hibernateJPA.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernateJPA.modelo.Empleado;

public class TestEmpleados {

    //creo mi gestor de persistencia (si no lo hago static no lo puedo ver desde el main)
    private static EntityManager manager;

    private static EntityManagerFactory emf;

    public static void main(String[] args){
        //creamos el geestor de persistencia
        emf = Persistence.createEntityManagerFactory("aplicacion");
        //createEntityManager() crea automaticamente el manager
        manager = emf.createEntityManager();

        Empleado e= new Empleado(10L, "perez","raul", new Date(1989,6,6));


        //transaccion es un metodo manager
        manager.getTransaction().begin();
        //con persiste me hace un almacen de la entidad 'e' y queda guardada en  el commit
        manager.persist(e);
        //lo envio a mi base de datos
        manager.getTransaction().commit();

        imprimir();

    }
    //paara que no se queje
    @SuppressWarnings("unchecked")
    private static void imprimir(){
        List<Empleado> emps=(List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        System.out.println("Hay "+emps.size() +" empleados");
        for(Empleado emp: emps){
            System.out.println(emp.toString());
        }
    }
}

 