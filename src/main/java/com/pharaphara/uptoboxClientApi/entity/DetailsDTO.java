package com.pharaphara.uptoboxClientApi.entity;

public class DetailsDTO {

    private String file_code;
    private String file_name;
    private long file_size;

    private boolean available_uts;
    private boolean need_premium;
    private SubtitleDTO[] subtitleDTOS;

    public String getFile_code() {
        return file_code;
    }

    public void setFile_code(String file_code) {
        this.file_code = file_code;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public boolean isAvailable_uts() {
        return available_uts;
    }

    public void setAvailable_uts(boolean available_uts) {
        this.available_uts = available_uts;
    }

    public boolean isNeed_premium() {
        return need_premium;
    }

    public void setNeed_premium(boolean need_premium) {
        this.need_premium = need_premium;
    }

    public SubtitleDTO[] getSubtitles() {
        return subtitleDTOS;
    }

    public void setSubtitles(SubtitleDTO[] subtitleDTOS) {
        this.subtitleDTOS = subtitleDTOS;
    }
}
