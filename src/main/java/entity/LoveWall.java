package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Title: LoveWall
 * @Description:
 * @Author: Ò×æÂ
 * @Date: 2017/6/24.
 */
@Entity
@Table(name = "lovewall", schema = "dating")
public class LoveWall {
    private int id;
    private String username;
    private Timestamp time;
    private String text;
    private int uid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoveWall)) return false;
        LoveWall loveWall = (LoveWall) o;
        return getId() == loveWall.getId() &&
                getUid() == loveWall.getUid() &&
                Objects.equals(getUsername(), loveWall.getUsername()) &&
                Objects.equals(getTime(), loveWall.getTime()) &&
                Objects.equals(getText(), loveWall.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getTime(), getText(), getUid());
    }
}
