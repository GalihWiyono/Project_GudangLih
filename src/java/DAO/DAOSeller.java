/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.GudanginLahUtil;
import pojo.TblSeller;

/**
 *
 * @author Galih
 */
public class DAOSeller {
    public List<TblSeller> Login(String uname, String pass){
        TblSeller tbl = new TblSeller();
        List<TblSeller> list = new ArrayList();
        
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM TblSeller WHERE id_seller= :uname AND password= :pass");
            query.setString("uname", uname);
            query.setString("pass", pass);
            tbl = (TblSeller) query.uniqueResult();
            list = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public void updateData(TblSeller tbl){
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            session.update(tbl);
            trans.commit();
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public List<TblSeller> cariId(String id){
        TblSeller tbl = new TblSeller();
        List<TblSeller> list = new ArrayList();
        
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
       try {
           trans = session.beginTransaction();
           Query query = session.createQuery("FROM TblSeller WHERE id_seller= :id");
           query.setString("id", id);
           tbl = (TblSeller) query.uniqueResult();
           list = query.list();
           trans.commit();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return list;
    }
    
    public List<TblSeller> retrieveData() {   
        List list = new ArrayList();
        TblSeller tbl = new TblSeller();
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM TblSeller");
            list = query.list();
            tbl = (TblSeller) query.uniqueResult();
             list = query.list();
           trans.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public int carirow(){
        int a = 0;
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Long count = ((long) session.createQuery("select count(*) from TblSeller").uniqueResult());
           a = count.intValue();
        }catch (Exception e){
            e.printStackTrace();
        }  
        return a;
    }
    
    public void addseller(TblSeller tbl) {
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
           trans = session.beginTransaction();
           session.save(tbl);
           trans.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteSeller(String id){
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            TblSeller tbl = (TblSeller) session.load(TblSeller.class, new String(id));
            session.delete(tbl);
            trans.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
