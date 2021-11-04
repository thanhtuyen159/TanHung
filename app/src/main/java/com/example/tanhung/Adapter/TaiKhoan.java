package com.example.tanhung.Adapter;

public class TaiKhoan {
    int MATK;
    int SDT;
    String TENTK;
    String MATKHAU;
    String EMAIL;

    public TaiKhoan() {
        this.MATK = MATK;
        this.SDT = SDT;
        this.TENTK = TENTK;
        this.MATKHAU = MATKHAU;
        this.EMAIL = EMAIL;
    }

    public int getMATK() {
        return MATK;
    }

    public void setMATK(int MATK) {
        this.MATK = MATK;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getTENTK() {
        return TENTK;
    }

    public void setTENTK(String TENTK) {
        this.TENTK = TENTK;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
