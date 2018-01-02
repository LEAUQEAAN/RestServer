package com.lq.viewmodel;

import com.lq.model.Scenic;
import com.lq.model.Worker;

import java.io.Serializable;

/**
 * Created by business on 2017-12-06.
 */
public class WorkerInfo implements Serializable{

    private  Worker worker;
    private  Scenic scenic;



    public WorkerInfo() {
    }

    public WorkerInfo(Worker worker, Scenic scenic) {
        this.worker = worker;
        this.scenic = scenic;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Scenic getScenic() {
        return scenic;
    }

    public void setScenic(Scenic scenic) {
        this.scenic = scenic;
    }

    @Override
    public String toString() {
        return "WorkerInfo{" +
                "worker=" + worker +
                ", scenic=" + scenic +
                '}';
    }
}
