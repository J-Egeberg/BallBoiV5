package oakberg.dk.mytemplate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.activities.MainActivity;

/**
 * Created by Oakberg on 06/04/2018.
 */

public class MyRecipes extends Fragment {
    private static final String TAG = "Menu";

    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.myrecipes_fragment_layout, container, false);

        imageView = (ImageView) view.findViewById(R.id.image);


        String url = "https://firebasestorage.googleapis.com/v0/b/cheapfoodz-54843.appspot.com/o/images%2F6695b573-ecd9-462b-b236-ec4e731e926d?alt=media&token=b149cc12-6af9-407b-992b-8ee4d9264ec0";

        Glide.with(getActivity().getApplicationContext()).load(url).into(imageView);


        return view;
    }
}
