/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import IDao.IDao;
import entities.Employe;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employe);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employe);
        session.getTransaction().commit();
        return true;  
    }

    @Override
    public boolean delete(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(employe);
        session.flush();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Employe getById(int id) {
        Employe employe = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employe = (Employe) session.get(Employe.class, id);
        session.getTransaction().commit();
        return employe;

    }

    @Override
    public List<Employe> getAll() {
    List<Employe> employes = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes = session.createQuery("from Employe").list();
        session.getTransaction().commit();
        return employes;
    
    }
    public List<Object[]> nbemploye() {
    List<Object[]> employes = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    employes = session.createQuery("select count(e.id), e.nom, e.chef.id from Employee e group by e.nom, e.chef.id").list();
    
    session.getTransaction().commit();
    return employes;
}
   public List<Object[]> nbEmployeByChef() {
    List<Object[]> employes = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    employes = session.createQuery("select count(e.nom), e.chef.nom from Employee e group by e.chef.nom").list();
    session.getTransaction().commit();
    return employes;
} 
   public List<Employe> getbydates(Date d1, Date d2) {
        List<Employe> employes = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes = session.createQuery("from Employee e where e.dateDeNaisssance between :d1 and :d2")
                .setParameter("d1", d1)
                .setParameter("d2", d2)
                .list();
        session.getTransaction().commit();
        return employes;
    }
    
}
