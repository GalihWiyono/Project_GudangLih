package pojo;
// Generated 18-Oct-2020 20:19:13 by Hibernate Tools 4.3.1

import DAO.DAOBarang;
import DAO.DAOSeller;
import DAO.DAOTransaksi;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * TblBarang generated by hbm2java
 */

@ManagedBean
@SessionScoped
@RequestScoped
public class TblBarang  implements java.io.Serializable {

    FacesContext context2 = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
    
     private String idsel = (String) session.getAttribute("user");
     private String idBarang;
     private String namaBarang;
     private String jenisBarang;
     private int jumlahBarang;
     private String idSeller;
     private int total_product,seller,total_transaksi;
  
    public TblBarang() {
    }

    public TblBarang(String idBarang, String namaBarang, String jenisBarang, int jumlahBarang, String idSeller, int total_product, int seller, int total_transaksi) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.jumlahBarang = jumlahBarang;
        this.idSeller = idSeller;
        this.total_product = total_product;
        this.seller = seller;
        this.total_transaksi = total_transaksi;
    }


    public String getIdsel() {
        return idsel;
    }

    public void setIdsel(String idsel) {
        this.idsel = idsel;
    }
    
  
    public int getTotal_product() {
        return total_product;
    }

    public void setTotal_product(int total_product) {
        this.total_product = total_product;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getTotal_transaksi() {
        return total_transaksi;
    }

    public void setTotal_transaksi(int total_transaksi) {
        this.total_transaksi = total_transaksi;
    }
    

    public String getIdBarang() {
        return this.idBarang;
    }
    
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    public String getNamaBarang() {
        return this.namaBarang;
    }
    
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    public String getJenisBarang() {
        return this.jenisBarang;
    }
    
    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }
    public int getJumlahBarang() {
        return this.jumlahBarang;
    }
    
    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    public String getIdSeller() {
        return this.idSeller;
    }
    
    public void setIdSeller(String idSeller) {
        this.idSeller = idSeller;
    }
    
    @PostConstruct
    public void init(){
        DAOBarang dao = new DAOBarang();
        total_product = dao.carirow();
        
        DAOSeller dao2 = new DAOSeller();
        seller = dao2.carirow();
        
        DAOTransaksi dao3 = new DAOTransaksi();
        total_transaksi = dao3.carirow();

    }
      
    public List<TblBarang> getallrecord(){
        DAOBarang dao = new DAOBarang();
        List<TblBarang> list = dao.retrieveTblBarang();
        return list;
    }
    
    public void addProduct() {
        DAOBarang dao = new DAOBarang();
        List<TblBarang> list = dao.cariID(idBarang);

        if(list.size()==0){
            dao.addBarang(this);
            idBarang = "";
            namaBarang= "";
            jenisBarang = "";
            jumlahBarang = 0;
            idSeller = "";
        } else {
            FacesContext.getCurrentInstance().addMessage("validate", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Data Gagal", null));
        }
    }
    
    public String updateProduct() {
        DAOBarang dao = new DAOBarang();
        dao.updateBarang(this);
        return "listproduct";
    }
    
    public String deleteProduct(String id){
        DAOBarang dao = new DAOBarang();
        dao.deleteBarang(id);
        return "listproduct?faces-redirect=true";
    }
    
    public String produkCari(String id){
        DAOBarang dao = new DAOBarang();
        List<TblBarang> list = dao.cariID(id);
        idBarang = list.get(0).idBarang;
        namaBarang = list.get(0).namaBarang;
        jenisBarang = list.get(0).jenisBarang;
        jumlahBarang = list.get(0).jumlahBarang;
        idSeller = list.get(0).idSeller; 
        return "updatebrg";
    }
    
    public String datatransaksi(String id){
        DAOBarang dao = new DAOBarang();
        List<TblBarang> list = dao.cariID(id);
        idBarang = list.get(0).idBarang;
        namaBarang = list.get(0).namaBarang;
        return "addtransaksi?faces-redirect=true";
    }

    public String itung(){
        String idbar = (String) session.getAttribute("idbar");
        DAOBarang dao = new DAOBarang();
        List<TblBarang> list = dao.cariID(idbar);
        int jumlah = (int) session.getAttribute("jumlah");
        int temp = list.get(0).jumlahBarang;
        temp = temp - jumlah;
        idBarang = list.get(0).idBarang;
        namaBarang = list.get(0).namaBarang;
        jenisBarang = list.get(0).jenisBarang;
        jumlahBarang = temp;
        idSeller = list.get(0).idSeller;
        dao.updateBarang(this);
        return "listproduct?faces-redirect=true";
    }
    
    public String dataBarangTrx(String id){
         return "addtransaksi";
     }
    
    
    //user
    public List<TblBarang> caribrgSeller(){
        DAOBarang dao = new DAOBarang();
        List<TblBarang> list = dao.cariIdUser(idsel);
        return list;
    }
    
    
    
    

}


