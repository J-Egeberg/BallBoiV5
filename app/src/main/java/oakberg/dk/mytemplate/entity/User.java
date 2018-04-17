package oakberg.dk.mytemplate.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Oakberg on 17/04/2018.
 */

@Entity
public class User {

    @PrimaryKey
    int id;
}
