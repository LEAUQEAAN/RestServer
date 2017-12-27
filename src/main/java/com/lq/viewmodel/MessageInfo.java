package com.lq.viewmodel;

import com.lq.model.Message;
import com.lq.model.Police;
import com.lq.model.Scenic;
import com.lq.model.Worker;

import java.io.Serializable;

/**
 * Created by root on 2017-12-03.
 */
public class MessageInfo implements Serializable {

    private Worker worker;
    private Message message;
    private Police police;
    private boolean New;

    public MessageInfo(Worker worker, Message message, Police police, boolean aNew) {
        this.worker = worker;
        this.message = message;
        this.police = police;
        New = aNew;
    }

    public MessageInfo() {
    }
    public boolean isNew() {
        return New;
    }

    public void setNew(boolean aNew) {
        New = aNew;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }


    @Override
    public String toString() {
        return "MessageInfo{" +
                "worker=" + worker +
                ", message=" + message +
                ", police=" + police +
                ", New=" + New +
                '}';
    }
}
