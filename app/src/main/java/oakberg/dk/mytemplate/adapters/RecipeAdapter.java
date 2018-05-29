package oakberg.dk.mytemplate.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.jsonloader.Recipe;


public class RecipeAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Recipe> mDataSource;

    public RecipeAdapter(Context context, ArrayList<Recipe> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    //1
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.allrecipes_activity_layout, parent, false);


        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.recipe_list_title);

        // Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.recipe_list_subtitle);

        // Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.recipe_list_detail);

        // Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(R.id.recipe_list_thumbnail);


        Recipe recipe = (Recipe) getItem(position);

// 2
        titleTextView.setText(recipe.title);
        subtitleTextView.setText(recipe.description);
        detailTextView.setText(recipe.label);

// 3
        Picasso.with(mContext).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);


        // SETTING THE FONT FROM ASSET FOLDER on the AllRecipes view

        Typeface titleTypeFace = Typeface.createFromAsset(mContext.getAssets(), "fonts/JosefinSans-Bold.ttf");
        titleTextView.setTypeface(titleTypeFace);

        Typeface subtitleTypeFace =
                Typeface.createFromAsset(mContext.getAssets(), "fonts/JosefinSans-SemiBoldItalic.ttf");
        subtitleTextView.setTypeface(subtitleTypeFace);

        Typeface detailTypeFace = Typeface.createFromAsset(mContext.getAssets(), "fonts/Quicksand-Bold.otf");
        detailTextView.setTypeface(detailTypeFace);

        return rowView;
    }


    }

