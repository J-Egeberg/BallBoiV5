package oakberg.dk.mytemplate.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Oakberg on 03/04/2018.
 */

@Entity
public class Score {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "time")
    private int time;
    private String userName;

    public Score(){

    }

    public Score(int id, int time, String userName) {
        this.id = id;
        this.time = time;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
