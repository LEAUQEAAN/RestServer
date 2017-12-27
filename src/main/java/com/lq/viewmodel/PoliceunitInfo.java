package com.lq.viewmodel;

import com.lq.model.Policeunit;
import com.lq.model.Scenic;

import java.io.Serializable;
import java.util.List;

/**
 * Created by business on 2017-12-07.
 */
public class PoliceunitInfo implements Serializable {

    Policeunit policeunit;
    List<Scenic> scenics;

    public PoliceunitInfo(Policeunit policeunit, List<Scenic> scenics) {
        this.policeunit = policeunit;
        this.scenics = scenics;
    }

    public PoliceunitInfo() {
    }

    public Policeunit getPoliceunit() {
        return policeunit;
    }

    public void setPoliceunit(Policeunit policeunit) {
        this.policeunit = policeunit;
    }

    public List<Scenic> getScenics() {
        return scenics;
    }

    public void setScenics(List<Scenic> scenics) {
        this.scenics = scenics;
    }

    @Override
    public String toString() {
        return "PoliceunitInfo{" +
                "policeunit=" + policeunit +
                ", scenics=" + scenics +
                '}';
    }
}
