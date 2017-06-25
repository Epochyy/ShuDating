package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Title: News
 * @Description:
 * @Author: Ò×æÂ
 * @Date: 2017/6/24.
 */
@Entity
@Table(name = "news", schema = "dating")
public class News {
    private int id;
    private int uid;
    private String username;
    private Timestamp time;
    private String news;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
    @Column(name = "news")
    public String getNews() {
        return news;
    }
    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news1 = (News) o;
        return getId() == news1.getId() &&
                getUid() == news1.getUid() &&
                Objects.equals(getUsername(), news1.getUsername()) &&
                Objects.equals(getTime(), news1.getTime()) &&
                Objects.equals(getNews(), news1.getNews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUid(), getUsername(), getTime(), getNews());
    }
}
