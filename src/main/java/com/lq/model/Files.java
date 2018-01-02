package com.lq.model;

/**
 * Created by Software1 on 2017/12/27.
 */
public class Files{

    private String  file_code ;
    private String  message_code;
    private String file_type;
    private String file_url;
    private String datetime;
    private String local_url;
    private String file_name;
    private String file_status;

    public Files() {
    }

    public Files(String file_code, String message_code, String file_type, String file_url, String datetime, String local_url, String file_name, String file_status) {
        this.file_code = file_code;
        this.message_code = message_code;
        this.file_type = file_type;
        this.file_url = file_url;
        this.datetime = datetime;
        this.local_url = local_url;
        this.file_name = file_name;
        this.file_status = file_status;
    }

    public String getFile_code() {
        return file_code;
    }

    public void setFile_code(String file_code) {
        this.file_code = file_code;
    }

    public String getMessage_code() {
        return message_code;
    }

    public void setMessage_code(String message_code) {
        this.message_code = message_code;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
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

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_status() {
        return file_status;
    }

    public void setFile_status(String file_status) {
        this.file_status = file_status;
    }

    @Override
    public String toString() {
        return "Files{" +
                "file_code='" + file_code + '\'' +
                ", message_code='" + message_code + '\'' +
                ", file_type='" + file_type + '\'' +
                ", file_url='" + file_url + '\'' +
                ", datetime='" + datetime + '\'' +
                ", local_url='" + local_url + '\'' +
                ", file_name='" + file_name + '\'' +
                ", file_status='" + file_status + '\'' +
                '}';
    }
}
