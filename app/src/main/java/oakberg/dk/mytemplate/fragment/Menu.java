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

        allRecipe = (Button) view.findViewById(R.id.allrecipesbtn);
        addRecipe = (Button) view.findViewById(R.id.addrecipebtn);
        exitBtn = (Button) view.findViewById(R.id.exitbtn);
        Log.d(TAG, "onCreateView: started.");

        allRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Going to Our Recipes", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });
        addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to User Recipes", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(4);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Logged out successfully", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });

        return view;
    }

}
