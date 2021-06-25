package platform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;


    private String code;

    @Transient
    @Getter(AccessLevel.NONE)
    private String date;

    @JsonIgnore
    private LocalDateTime localDateTime;

    private long time;

    private long views;

    @Transient
    @JsonIgnore
    @Column(nullable = false)
    private boolean viewsLimited;

    @JsonIgnore
    @Column(nullable = false)
    private boolean restrictedByTime;

    @JsonIgnore
    @Column(nullable = false)
    private boolean restrictedByViews;


    public boolean isRestrictedByTime() {
        return restrictedByTime;
    }

    public void setRestrictedByTime(boolean restrictedByTime) {
        this.restrictedByTime = restrictedByTime;
    }

    public boolean isRestrictedByViews() {
        return restrictedByViews;
    }

    public void setRestrictedByViews(boolean restrictedByViews) {
        this.restrictedByViews = restrictedByViews;
    }

    public String getDate() {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(localDateTime);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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

    public boolean isViewsLimited() {
        return viewsLimited;
    }

    public void setViewsLimited(boolean viewsLimited) {
        this.viewsLimited = viewsLimited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code1 = (Code) o;
        return Objects.equals(id, code1.id) &&
                code.equals(code1.code) &&
                date.equals(code1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, date);
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
