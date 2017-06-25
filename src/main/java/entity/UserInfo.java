package entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Title: entity.UserInfo
 * @Description:
 * @Author: Ò×æÂ
 * @Date: 2017/6/24.
 */
@Entity
@Table(name = "userinfo", schema = "dating")
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String realname;
    private String gender;
    private int age;
    private String sexlike;
    private String photo;
    private String motto;
    private String requirement;
    private String phone;
    private String qq;
    private String label1;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "sexlike")
    public String getSexlike() {
        return sexlike;
    }

    public void setSexlike(String sexlike) {
        this.sexlike = sexlike;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "motto")
    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Basic
    @Column(name = "requirement")
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "label1")
    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return getId() == userInfo.getId() &&
                getAge() == userInfo.getAge() &&
                getLabel1() == userInfo.getLabel1() &&
                Objects.equals(getUsername(), userInfo.getUsername()) &&
                Objects.equals(getPassword(), userInfo.getPassword()) &&
                Objects.equals(getRealname(), userInfo.getRealname()) &&
                Objects.equals(getGender(), userInfo.getGender()) &&
                Objects.equals(getSexlike(), userInfo.getSexlike()) &&
                Objects.equals(getPhoto(), userInfo.getPhoto()) &&
                Objects.equals(getMotto(), userInfo.getMotto()) &&
                Objects.equals(getRequirement(), userInfo.getRequirement()) &&
                Objects.equals(getPhone(), userInfo.getPhone()) &&
                Objects.equals(getQq(), userInfo.getQq());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getRealname(), getGender(), getAge(), getSexlike(), getPhoto(), getMotto(), getRequirement(), getPhone(), getQq(), getLabel1());
    }
}
