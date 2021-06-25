package platform.model;

import javax.validation.constraints.NotNull;

public class CodeDTO {
    @NotNull
    private String code;
    @NotNull
    private long time;
    @NotNull
    private long views;

    public CodeDTO() {
    }

    public CodeDTO(@NotNull String code, @NotNull long time, @NotNull long views) {
        this.code = code;
        this.time = time;
        this.views = views;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }
}
