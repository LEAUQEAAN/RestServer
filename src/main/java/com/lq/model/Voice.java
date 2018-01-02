package com.lq.model;

/**
 * Created by root on 2018-01-01.
 */
public class Voice {

   private String  voice_code;
    private String message_code ;
    private String voice_url;
    private String datetime;
    private String local_url ;
    private int voice_length;

    public Voice() {
    }

    public Voice(String voice_code, String message_code, String voice_url, String datetime, String local_url, int voice_length) {
        this.voice_code = voice_code;
        this.message_code = message_code;
        this.voice_url = voice_url;
        this.datetime = datetime;
        this.local_url = local_url;
        this.voice_length = voice_length;
    }

    public String getVoice_code() {
        return voice_code;
    }

    public void setVoice_code(String voice_code) {
        this.voice_code = voice_code;
    }

    public String getMessage_code() {
        return message_code;
    }

    public void setMessage_code(String message_code) {
        this.message_code = message_code;
    }

    public String getVoice_url() {
        return voice_url;
    }

    public void setVoice_url(String voice_url) {
        this.voice_url = voice_url;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLocal_url() {
        return local_url;
    }

    public void setLocal_url(String local_url) {
        this.local_url = local_url;
    }

    public int getVoice_length() {
        return voice_length;
    }

    public void setVoice_length(int voice_length) {
        this.voice_length = voice_length;
    }

    @Override
    public String toString() {
        return "Voice{" +
                "voice_code='" + voice_code + '\'' +
                ", message_code='" + message_code + '\'' +
                ", voice_url='" + voice_url + '\'' +
                ", datetime='" + datetime + '\'' +
                ", local_url='" + local_url + '\'' +
                ", voice_length=" + voice_length +
                '}';
    }
}
