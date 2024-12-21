package com.example.bt_code_nhom.Model;

import java.util.List;

public class Movie {
    private int id;
    private int resourceImage;
    private String name;
    private int time;
    private String date;
    private String noiDung;
    private String daoDien;
    private String trailler;
    private double soSao;
    private String trangThai;
    private String ngayKhoiChieu;
    private List<String> showTime;
    private List<Integer> idlc;

    public Movie(int id, String name, int resourceImage, double soSao, String ngayKhoiChieu, int time, List<Integer> idlc, List<String> showTime) {
        this.id = id;
        this.name = name;
        this.resourceImage = resourceImage;
        this.soSao = soSao;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.time = time;
        this.idlc = idlc;
        this.showTime = showTime;
    }

    public String getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setNgayKhoiChieu(String ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public List<Integer> getIdlc() {
        return idlc;
    }

    public void setIdlc(List<Integer> idlc) {
        this.idlc = idlc;
    }

    public Movie(int id, String name, int resourceImage) {
        this.id =id;
        this.name = name;
        this.resourceImage = resourceImage;
    }

    public Movie(int resourceImage, String name, String date, int time, List<String> showTime) {
        this.resourceImage = resourceImage;
        this.date = date;
        this.time = time;
        this.name = name;
        this.showTime = showTime;

    }

    public Movie(int resourceImage, String name, int time, String trailler, double soSao, String ngayKhoiChieu) {
        this.resourceImage = resourceImage;
        this.name = name;
        this.time = time;
        this.daoDien = daoDien;
        this.trailler = trailler;
        this.soSao = soSao;
        this.trangThai = trangThai;
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public Movie(String noiDung, String daoDien) {
        this.noiDung = noiDung;
        this.daoDien = daoDien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getShowTime() {
        return showTime;
    }
    public void setShowTime(List<String> showTime) {
        this.showTime = showTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getTrailler() {
        return trailler;
    }

    public void setTrailler(String trailler) {
        this.trailler = trailler;
    }

    public double getSoSao() {
        return soSao;
    }

    public void setSoSao(double soSao) {
        this.soSao = soSao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getngayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setngayKhoiChieu(String ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }
}
