package oakberg.dk.mytemplate.room.database;
/*
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import oakberg.dk.mytemplate.entity.Recipe;
import oakberg.dk.mytemplate.room.dao.DaoRecipe;

/**
 * Created by Oakberg on 08/04/2018.
 */
/*
@Database(entities = {Recipe.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {
    public abstract DaoRecipe daoScore();

    private static RoomDB INSTANCE;

    public static RoomDB getRoomDBInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, "RoomDB.db").build();
        }
        return INSTANCE;
    }

    public static void destroyRoomDBInstance() {
        INSTANCE = null;
    }
}*/
