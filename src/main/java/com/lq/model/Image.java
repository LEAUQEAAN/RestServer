package com.lq.model;

import java.io.Serializable;

/**
 * Created by Software1 on 2017/12/15.
 */
public class Image  implements Serializable{

    private String id;
    private String img;

    public Image() {
    }

    public Image(String id, String img) {
        this.id = id;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
