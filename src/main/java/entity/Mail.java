package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Title: Mail
 * @Description:
 * @Author: Ò×æÂ
 * @Date: 2017/6/24.
 */
@Entity
@Table(name = "mail", schema = "dating")
public class Mail {
    private int id;
    private int sender;
    private int receiver;
    private Timestamp time;
    private String mail;
    private Integer ifread;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sender")
    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "receiver")
    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
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
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "ifread")
    public Integer getIfread() {
        return ifread;
    }

    public void setIfread(Integer ifread) {
        this.ifread = ifread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mail)) return false;
        Mail mail = (Mail) o;
        return getId() == mail.getId() &&
                getSender() == mail.getSender() &&
                getReceiver() == mail.getReceiver() &&
                Objects.equals(getTime(), mail.getTime()) &&
                Objects.equals(getMail(), mail.getMail()) &&
                Objects.equals(getIfread(), mail.getIfread());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSender(), getReceiver(), getTime(), getMail(), getIfread());
    }
}
