package es.eoi;

import es.eoi.persistence.Cliente;
import es.eoi.persistence.Direccion;
import es.eoi.persistence.TipoCliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //  Obtener el EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        // Obtener el EntityManager (conexion a la BBDD)
        EntityManager em = emf.createEntityManager();

        // Obtener una transaccion
        EntityTransaction et = em.getTransaction();

        // Crear las entidades
        Cliente c1 = new Cliente(1L, "Robert", "U874563W", 964365784,
                new Direccion("Columbretes",35,"Castellon"), TipoCliente.NACIONAL);
        Cliente c2 = new Cliente(2L, "Sergi", "U874563W", 968934729,
                new Direccion("Beltran",12,"Girona"), TipoCliente.INTERNACIONAL);


        try {
            // Iniciar la transaccion
            et.begin();

            // Persistir las entidades
            em.persist(c1);
            em.persist(c2);

            // Hacemos efectiva la transaccion
            et.commit();
        } catch (Exception e) {
            // Desahacer la transaccion
            et.rollback();
            e.printStackTrace();
        } finally {
            // Cerar la conexion a la BBDD
            em.close();
        }
    }
}