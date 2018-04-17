package oakberg.dk.mytemplate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.activities.MainActivity;

/**
 * Created by Oakberg on 06/04/2018.
 */

public class Menu extends Fragment {
    private static final String TAG = "Menu";

    private Button myRecipe;
    private Button allRecipe;
    private Button addRecipe;
    private Button exitBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.menu_fragment_layout, container, false);

        myRecipe = (Button) view.findViewById(R.id.myrecipesbtn);
        allRecipe = (Button) view.findViewById(R.id.allrecipesbtn);
        addRecipe = (Button) view.findViewById(R.id.addrecipebtn);
        exitBtn = (Button) view.findViewById(R.id.exitbtn);
        Log.d(TAG, "onCreateView: started.");

        myRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Going to My Recipes", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });
        allRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Going to All Recipes", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Add Food", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Exiting", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(4);
            }
        });

        return view;
    }

}
