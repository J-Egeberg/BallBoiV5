package oakberg.dk.mytemplate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import oakberg.dk.mytemplate.R;

/**
 * Created by Oakberg on 06/04/2018.
 */

public class VegetarianFood extends Fragment {

    private ListView listOfScores;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.vegetarianfood_fragment_layout, container, false);
        listOfScores = (ListView)view.findViewById(R.id.personalscores);

        return view;
    }}

