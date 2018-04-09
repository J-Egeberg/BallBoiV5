package oakberg.dk.mytemplate.fragment;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.room.dao.DaoScore;
import oakberg.dk.mytemplate.room.database.RoomDB;
import oakberg.dk.mytemplate.room.entity.Score;
import oakberg.dk.mytemplate.room.roomdatabase.RoomDatabase;

/**
 * Created by Oakberg on 06/04/2018.
 */

public class Personal extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.personalhighscores_fragment_layout, container, false);

        return view;
    }}

