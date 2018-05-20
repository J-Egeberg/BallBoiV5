package oakberg.dk.mytemplate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.entity.Recipe;
import oakberg.dk.mytemplate.entity.RecipeAdapter;


/**
 * Created by Oakberg on 06/04/2018.
 */

public class AllRecipes extends Fragment {

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.allrecipes_fragment_layout, container, false);

        mListView = (ListView) view.findViewById(R.id.recipe_list_view);

        // Loads list of objects from the jSON file in asset folder

        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", getActivity());

        RecipeAdapter adapter = new RecipeAdapter(getActivity(), recipeList);
        mListView.setAdapter(adapter);


        return view;
    }

}
