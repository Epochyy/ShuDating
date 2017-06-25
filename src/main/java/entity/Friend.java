package entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Title: Friend
 * @Description:
 * @Author: Ò×æÂ
 * @Date: 2017/6/24.
 */
@Entity
@Table(name = "friend", schema = "dating")
public class Friend {
    private int id1;
    private int id2;

    @Id
    @Column(name = "id1")
    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    @Basic
    @Column(name = "id2")
    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Friend)) return false;
        Friend friend = (Friend) o;
        return getId1() == friend.getId1() &&
                getId2() == friend.getId2();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId1(), getId2());
    }
}
