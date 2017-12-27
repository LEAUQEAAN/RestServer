package com.lq.viewmodel;

import com.lq.model.Police;
import com.lq.model.Policeunit;

import java.io.Serializable;

/**
 * Created by business on 2017-12-06.
 */
public class PoliceInfo implements Serializable {

    private Police police;
    private Policeunit policeunit;

    public PoliceInfo() {
    }

    public PoliceInfo(Police police, Policeunit policeunit) {
        this.police = police;
        this.policeunit = policeunit;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }

    public Policeunit getPoliceunit() {
        return policeunit;
    }

    public void setPoliceunit(Policeunit policeunit) {
        this.policeunit = policeunit;
    }

    @Override
    public String toString() {
        return "PoliceInfo{" +
                "police=" + police +
                ", policeunit=" + policeunit +
                '}';
    }
}
