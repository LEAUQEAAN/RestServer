package com.lq.viewmodel;

import com.lq.model.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by root on 2017-12-03.
 */
public class MessageInfo implements Serializable {

    private Worker worker;
    private Message message;
    private Police police;
    private List<Files> Imgfiles;
    private List<Voice> Voicefiles;
    private List<Files> VIDfiles;
    private boolean New;
    private int numImg;
    private int numVoice;
    private int numVID;

    public MessageInfo() {
    }

    public MessageInfo(Worker worker, Message message, Police police, List<Files> imgfiles, List<Voice> voicefiles, List<Files> VIDfiles, boolean aNew, int numImg, int numVoice, int numVID) {
        this.worker = worker;
        this.message = message;
        this.police = police;
        Imgfiles = imgfiles;
        Voicefiles = voicefiles;
        this.VIDfiles = VIDfiles;
        New = aNew;
        this.numImg = numImg;
        this.numVoice = numVoice;
        this.numVID = numVID;
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

    public List<Files> getImgfiles() {
        return Imgfiles;
    }

    public void setImgfiles(List<Files> imgfiles) {
        Imgfiles = imgfiles;
    }

    public List<Voice> getVoicefiles() {
        return Voicefiles;
    }

    public void setVoicefiles(List<Voice> voicefiles) {
        Voicefiles = voicefiles;
    }

    public List<Files> getVIDfiles() {
        return VIDfiles;
    }

    public void setVIDfiles(List<Files> VIDfiles) {
        this.VIDfiles = VIDfiles;
    }

    public boolean isNew() {
        return New;
    }

    public void setNew(boolean aNew) {
        New = aNew;
    }

    public int getNumImg() {
        return numImg;
    }

    public void setNumImg(int numImg) {
        this.numImg = numImg;
    }

    public int getNumVoice() {
        return numVoice;
    }

    public void setNumVoice(int numVoice) {
        this.numVoice = numVoice;
    }

    public int getNumVID() {
        return numVID;
    }

    public void setNumVID(int numVID) {
        this.numVID = numVID;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "worker=" + worker +
                ", message=" + message +
                ", police=" + police +
                ", Imgfiles=" + Imgfiles +
                ", Voicefiles=" + Voicefiles +
                ", VIDfiles=" + VIDfiles +
                ", New=" + New +
                ", numImg=" + numImg +
                ", numVoice=" + numVoice +
                ", numVID=" + numVID +
                '}';
    }
}
