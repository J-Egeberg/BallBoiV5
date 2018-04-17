package oakberg.dk.mytemplate.room.roomdatabase;

import android.content.Context;

import oakberg.dk.mytemplate.room.database.RoomDB;

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

            roomDatabase.close();

        }).start();
    }
}