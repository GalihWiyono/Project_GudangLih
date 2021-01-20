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
import pojo.TblBarang;

/**
 *
 * @author Galih
 */
public class DAOBarang {
    
    public void addBarang(TblBarang tbl) {
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
    
     public void deleteBarang(String id) {
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            TblBarang tbl = (TblBarang) session.load(TblBarang.class, new String(id));
            session.delete(tbl);
            trans.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
     
    public List<TblBarang> cariID(String id){
        TblBarang tbl = new TblBarang();
        List<TblBarang> list = new ArrayList();
        
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM TblBarang WHERE id_barang= :id");
            query.setString("id", id);
            tbl = (TblBarang) query.uniqueResult();
            list = query.list();
            trans.commit();       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public void updateBarang(TblBarang tbl) {
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            session.update(tbl);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<TblBarang> retrieveTblBarang() {   
        List list = new ArrayList();
        TblBarang tbl = new TblBarang();
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblBarang");
            list = query.list();
            tbl = (TblBarang) query.uniqueResult();
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
            Long count = ((long) session.createQuery("select count(*) from TblBarang").uniqueResult());
            a = count.intValue();
        }catch (Exception e){
            e.printStackTrace();
        }  
        return a;
    }
    
    //buat user
    public int carirowById(String id){
        int a = 0;
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Long count = ((long) session.createQuery("select count(*) from TblBarang where id_seller= :id").setString("id", id).uniqueResult());
            a = count.intValue();
        } catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
    public List<TblBarang> cariIdUser(String id){
        TblBarang tbl = new TblBarang();
        List list = new ArrayList();
        
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM TblBarang WHERE id_seller= :id");
            query.setString("id", id);
            list = query.list();
            if (list.isEmpty()){
                return null;
            } else {
            list.add(tbl.getIdBarang());
            list.add(tbl.getNamaBarang());
            list.add(tbl.getJenisBarang());
            list.add(tbl.getJumlahBarang());
            trans.commit();  
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
