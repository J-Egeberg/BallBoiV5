package oakberg.dk.mytemplate.room.roomdatabase;

import android.content.Context;
import android.util.Log;

import oakberg.dk.mytemplate.room.database.RoomDB;
import oakberg.dk.mytemplate.room.entity.Score;

/**
 * Created by Oakberg on 08/04/2018.
 */

public class RoomDatabase {
    public RoomDatabase(Context context)
    {
        new Thread(() -> {
            RoomDB roomDatabase = RoomDB.getRoomDBInstance(context);

            roomDatabase.daoScore().insert(new Score(0, 50, "Oakberg"));
            roomDatabase.daoScore().insert(new Score(1, 60, "Cymback"));
            roomDatabase.daoScore().insert(new Score(2, 70, "Eyedfiber"));

            Score score = new Score(3, 50, "Jørgen");
            roomDatabase.daoScore().insert(score);

            score = roomDatabase.daoScore().findByName("Jørgen");
            score.setTime(80);

            roomDatabase.daoScore().update(score);

            //roomDatabase.daoUser().delete(u);

            Log.d("users", "Users: " + roomDatabase.daoScore().countUsers());

            Log.d("users", "Users: " + roomDatabase.daoScore().getAll());

            Log.d("users", "User: " + roomDatabase.daoScore().findByName("H"));

            roomDatabase.close();

        }).start();
    }
}