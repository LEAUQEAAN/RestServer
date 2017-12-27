package com.lq.viewmodel;

import com.lq.model.Scenic;

import java.io.Serializable;

/**
 * Created by root on 2017-12-10.
 */
public class ScenicInfo implements Serializable{

    private Scenic scenic;
    private String newNum;
    private String color;

    public ScenicInfo() {
    }

    public ScenicInfo(Scenic scenic, String newNum, String color) {
        this.scenic = scenic;
        this.newNum = newNum;
        this.color = color;
    }

    public Scenic getScenic() {
        return scenic;
    }

    public void setScenic(Scenic scenic) {
        this.scenic = scenic;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNewNum() {
        return newNum;
    }

    public void setNewNum(String newNum) {
        this.newNum = newNum;
    }

    @Override
    public String toString() {
        return "ScenicInfo{" +
                "scenic=" + scenic +
                ", newNum='" + newNum + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
