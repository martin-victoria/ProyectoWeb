/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.logica;

import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import co.edu.uvpalmira.fpoe.modelo.Docente;
import co.edu.uvpalmira.fpoe.persistencia.DAO.DocenteDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author marti
 */
@ApplicationScoped
public class LogicaImplementacion implements ILogica{
    
    @PersistenceUnit(name="DocentePU")
    private EntityManagerFactory emf;
    
    private DocenteDAO docenteDAO;

    public LogicaImplementacion() {
    }
    
    @PostConstruct
    public void init(){
        this.docenteDAO = new DocenteDAO(this.emf);
    }
    
    @Override
    public void crearDocente(Docente docente) throws SQLIntegrityConstraintViolationException, Exception{
        this.docenteDAO.create(docente);
    }
    
    @Override
    public void modificarDocente(Docente docente) throws NonexistentEntityException, Exception{
        this.docenteDAO.edit(docente);
    }
    
    @Override
    public Docente buscarDocente(long nuip){
        return this.docenteDAO.buscarPorNuip(nuip);
    }
    
    @Override
    public List<Docente> buscarDocentes(){
        return this.docenteDAO.findEntities();
    }
    
}
