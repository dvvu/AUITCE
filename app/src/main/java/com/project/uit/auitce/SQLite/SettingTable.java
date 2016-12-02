package com.project.uit.auitce.SQLite;

/**
 * Created by leehoa on 11/30/16.
 */

public class SettingTable {
    private  int Vans;
    private int DRows;
    private int DImages;
    private int Threhold;
    private String Ip;
    private int Port;

    public SettingTable(int vans, int DRows, int DImages, int threhold, String ip, int port) {
        Vans = vans;
        this.DRows = DRows;
        this.DImages = DImages;
        Threhold = threhold;
        Ip = ip;
        Port = port;
    }

    public SettingTable() {
    }

    public int getVans() {
        return Vans;
    }

    public void setVans(int vans) {
        Vans = vans;
    }

    public int getDRows() {
        return DRows;
    }

    public void setDRows(int DRows) {
        this.DRows = DRows;
    }

    public int getDImages() {
        return DImages;
    }

    public void setDImages(int DImages) {
        this.DImages = DImages;
    }

    public int getThrehold() {
        return Threhold;
    }

    public void setThrehold(int threhold) {
        Threhold = threhold;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int port) {
        Port = port;
    }
}
