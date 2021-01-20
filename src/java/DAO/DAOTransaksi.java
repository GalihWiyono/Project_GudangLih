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
import pojo.TblTransaksi;


/**
 *
 * @author Galih
 */
public class DAOTransaksi {
    
    
    public void addTransaksi(TblTransaksi tbl) {
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
    
    public List<TblTransaksi> cariID(String id){
        TblTransaksi tbl = new TblTransaksi();
        List<TblTransaksi> list = new ArrayList();
        
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM TblTransaksi WHERE id_barang= :id");
            query.setString("id", id);
            tbl = (TblTransaksi) query.uniqueResult();
            list = query.list();
            trans.commit();       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    
    public List<TblTransaksi> retrieveTblTransaksi() {   
        List list = new ArrayList();
        TblTransaksi tbl = new TblTransaksi();
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblTransaksi");
           list = query.list();
            if (list.isEmpty()){
                return null;
            } else {
            list.add(tbl.getIdTransaksi());
            list.add(tbl.getIdBarang());
            list.add(tbl.getNamaBarang());
            list.add(tbl.getNamaPenerima());
            list.add(tbl.getAlamatPenerima());
            list.add(tbl.getJumlahPembelian());
            list.add(tbl.getNotelpPenerima());
            list.add(tbl.getTglTransaksi());
            list.add(tbl.getIdSeller());
            trans.commit();
            }
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
            Long count = ((long) session.createQuery("select count(*) from TblTransaksi").uniqueResult());
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
            Long count = ((long) session.createQuery("select count(*) from TblTransaksi where id_seller= :id").setString("id", id).uniqueResult());
            a = count.intValue();
        } catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
    public List<TblTransaksi> getDataById(String id) {   
        List list = new ArrayList();
        TblTransaksi tbl = new TblTransaksi();
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblTransaksi where id_seller= :id");
            query.setString("id", id);
            list = query.list();
            if (list.isEmpty()){
                return null;
            } else {
            list.add(tbl.getIdTransaksi());
            list.add(tbl.getIdBarang());
            list.add(tbl.getNamaBarang());
            list.add(tbl.getNamaPenerima());
            list.add(tbl.getAlamatPenerima());
            list.add(tbl.getJumlahPembelian());
            list.add(tbl.getNotelpPenerima());
            list.add(tbl.getTglTransaksi());
            trans.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    } 
    
    public List<TblTransaksi> allrecordReverse(String id) {   
        List list = new ArrayList();
        TblTransaksi tbl = new TblTransaksi();
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblTransaksi where id_seller= :id ORDER BY id_transaksi DESC");
            query.setString("id", id);
            list = query.list();
            if(list.isEmpty()){
                return list;
            } else {
             list.add(tbl.getTglTransaksi());
            trans.commit();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<TblTransaksi> cariTransaksi(String id) {   
        List list = new ArrayList();
        TblTransaksi tbl = new TblTransaksi();
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblTransaksi where id_transaksi= :id");
            query.setString("id", id);
            list = query.list();
            
            if(list.isEmpty()){
                return list;
            } else {
                list.add(tbl.getIdTransaksi());
                list.add(tbl.getIdBarang());
                list.add(tbl.getNamaBarang());
                list.add(tbl.getNamaPenerima());
                list.add(tbl.getAlamatPenerima());
                list.add(tbl.getJumlahPembelian());
                list.add(tbl.getNotelpPenerima());
                list.add(tbl.getTglTransaksi());
                trans.commit();
            }
                } catch (Exception e) 
                    {
                    e.printStackTrace();
                }
            return list;
            }
    
   public List<TblTransaksi> transid(String id){
        TblTransaksi tbl = new TblTransaksi();
        List<TblTransaksi> list = new ArrayList();
        
        Transaction trans = null;
        Session session = GudanginLahUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM TblTransaksi WHERE id_transaksi= :id");
            query.setString("id", id);
            tbl = (TblTransaksi) query.uniqueResult();
            list = query.list();
            trans.commit();       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
      
} 
    
    
    

