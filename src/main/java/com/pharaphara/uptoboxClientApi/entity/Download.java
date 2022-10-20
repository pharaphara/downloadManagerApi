package com.pharaphara.uptoboxClientApi.entity;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Download {

    private String code;
    private String name;
    private long size;
    private long downloaded;

    private String downloadUrl;



    public OutputStream getOutputStream(FileOutputStream fileOutputStream) {
        return new FilterOutputStream(fileOutputStream) {
            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                out.write(b, off, len);
                downloaded += len;
            }
            @Override
            public void write(int b) throws IOException {
                out.write(b);
                downloaded++;
            }
            @Override
            public void close() throws IOException {
                super.close();
                done();
            }
        };
    }

    public void done() {
        if ( size == -1 ) {
            size = downloaded;
        } else {
            downloaded = size;
        }
    }

    public double getProgress() {
        if ( size == -1 ) return 0;
        return downloaded / (double) size;
    }



    public boolean finished() {
        return downloaded > 0 && downloaded == size;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(long downloaded) {
        this.downloaded = downloaded;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Download(String code, String name, long size, String downloadUrl) {
        this.code = code;
        this.name = name;
        this.size = size;
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "Download{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", downloaded=" + downloaded +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}