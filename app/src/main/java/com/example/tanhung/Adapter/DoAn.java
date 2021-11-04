package com.example.tanhung.Adapter;

public class DoAn {
    private int ID;
    private String Ten;
    private String MoTa;
    private byte[] Hinh;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }

    public DoAn(int ID, String ten, String moTa, byte[] hinh) {
        this.ID = ID;
        Ten = ten;
        MoTa = moTa;
        Hinh = hinh;
    }
}
