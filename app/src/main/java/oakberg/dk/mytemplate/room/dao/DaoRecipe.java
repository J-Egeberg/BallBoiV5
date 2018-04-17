package oakberg.dk.mytemplate.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Oakberg on 08/04/2018.
 */

@Dao
public interface DaoRecipe {
    @Query("SELECT * FROM Score")
    List<Score> getAll();

    @Query("SELECT * FROM Score where userName LIKE :n")
    Score findByName(String n);

    @Query("SELECT COUNT(*) from Score")
    int countUsers();

    @Insert
    void insert(Score score);

    @Insert
    void insertAll(Score... scores);

    @Delete
    void delete(Score score);

    @Update
    void update(Score score);
}

