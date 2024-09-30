package model;

import java.util.ArrayList;
import util.FileHelper;
import java.io.*;
import java.util.A.Collections;
import java.utirrayList;
import java.utill.Comparator;
/**
 *
 * Họ tên sinh viên: Trần Minh Tâm
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) {
        //sinh viên viết code 
      BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(";");
            if (data.length == 5) {
                KhachHang kh = new KhachHang(data[0], data[1], Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]));
                dsKhachHang.add(kh);
            }
        }
    }

    public boolean GhiHoaDon(String filename) throws IOException {
        //sinh viên viết code 
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (KhachHang kh : dsKhachHang) {
            double tieuThu = kh.getTieuThu();
            double tienTra = kh.tinhTienTra();
            bw.write(kh.getMaso() + ";" + kh.getHoten() + ";" + tieuThu + ";" + tienTra);
            bw.newLine();
        }
        bw.close();
    }
    public ArrayList<KhachHang> getDanhSachKhachHang() {
        return dsKhachHang;
    } 
   
    public void sapXepTheoMucTieuThu() {
        //sinh viên viết code  
         Collections.sort(danhSachKhachHang, Comparator.comparingDouble(KhachHang::getTieuThu).reversed());
    }
    
    public double getTieuThuCaoNhat()
    {
      return dsKhachHang.stream()
                .mapToDouble(KhachHang::getTieuThu)
                .average().orElse(0);
    }
    
    public double getTieuThuThapNhat()
    {
       double min=0;
       return min;       
    }
    
    public double getTieuThuTrungBinh()
    {
       return dsKhachHang.stream()
                .mapToDouble(KhachHang::getTieuThu)
                .average().orElse(0);     
    }
}
