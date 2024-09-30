package model;

/**
 *
 * Họ tên sinh viên: Trần Minh Tâm
 */
public class KhachHang {
    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;            

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter
public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }  
    
    
    //phương thức tính toán    

    public double getTieuThu()
    {
      return chisomoi-chisocu;
    }
    
    public double getDinhMuc()
    {
       return sonhankhau * 4;
    }
    
    
    public double tinhTienTra()
    {
       double tieuThu = getTieuThu();
        double dinhMuc = getDinhMuc();

        double giaBan = 0;

        if (tieuThu <= dinhMuc) {
            giaBan = tieuThu * 6700; // Giá 6.700 đồng/m3
        } else if (tieuThu <= dinhMuc + 2) { // từ 4m3 đến 6m3/người
            double m3VuotDinhMuc = tieuThu - dinhMuc;
            giaBan = (dinhMuc * 6700) + (m3VuotDinhMuc * 12900);
        } else { // trên 6m3/người
            double m3VuotDinhMuc = tieuThu - dinhMuc;
            double m3Tren6 = m3VuotDinhMuc - 2;
            giaBan = (dinhMuc * 6700) + (2 * 12900) + (m3Tren6 * 14400);
        }

        // Tính thuế GTGT, TDVTN và thuế TDVTN
        double thueGTGT = giaBan * 0.05;
        double tdvtn = giaBan * 0.25;
        double thueTDVTN = tdvtn * 0.08;

        // Tổng tiền phải trả
        return giaBan + thueGTGT + tdvtn + thueTDVTN;
    }         
}
