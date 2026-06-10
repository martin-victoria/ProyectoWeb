package co.edu.uvpalmira.fpoe.persistencia.DAO;

import co.edu.uvpalmira.fpoe.modelo.Docente;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.fail;

public class DocenteDAOTest {

    private DocenteDAO docenteDAO;
    private Long id;

    public DocenteDAOTest() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("FPOE-Test-PU");

        this.docenteDAO = new DocenteDAO(emf);
    }

    @Test
    public void test() {

        try {

            System.out.println("Insertar");

            Docente docente = new Docente(
                    123456789L,
                    "Juan",
                    "Perez",
                    "Masculino",
                    "Ingeniero");

            docenteDAO.create(docente);

            this.id = docente.getId();

            Assert.assertNotNull(docente.getId());

            System.out.println("Buscar");

            docente = docenteDAO.buscarPorNuip(123456789L);

            Assert.assertEquals("Juan", docente.getNombres());

            System.out.println("Actualizar");

            docente.setProfesion("Licenciado");

            docenteDAO.edit(docente);

            docente = docenteDAO.buscarPorNuip(123456789L);

            Assert.assertEquals(
                    "Licenciado",
                    docente.getProfesion()
            );

        } catch (Exception ex) {

            Logger.getLogger(DocenteDAOTest.class.getName())
                    .log(Level.SEVERE, null, ex);

            fail();
        }
    }
}