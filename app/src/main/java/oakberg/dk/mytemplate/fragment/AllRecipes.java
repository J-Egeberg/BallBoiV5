package oakberg.dk.mytemplate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.jsonloader.Recipe;
import oakberg.dk.mytemplate.adapters.RecipeAdapter;
import oakberg.dk.mytemplate.activities.MyRecipeDetail;


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


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // getting recipeList object, that is clicked
                Recipe selectedRecipe = recipeList.get(position);

                // Intent created to navigate
                Intent detailIntent = new Intent(getActivity(), MyRecipeDetail.class);

                // DetailActivity needs to know the title and url to display passing data via the intent
                detailIntent.putExtra("title", selectedRecipe.title);
                detailIntent.putExtra("url", selectedRecipe.instructionUrl);

                //
                startActivity(detailIntent);
            }

        });


        return view;
    }

}
