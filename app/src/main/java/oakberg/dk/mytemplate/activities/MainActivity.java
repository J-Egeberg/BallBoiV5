package oakberg.dk.mytemplate.activities;

import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.fragment.AddRecipe;
import oakberg.dk.mytemplate.fragment.Login;
import oakberg.dk.mytemplate.fragment.Menu;
import oakberg.dk.mytemplate.fragment.AllRecipes;
//import oakberg.dk.mytemplate.fragment.ProfileActivity;
import oakberg.dk.mytemplate.fragment.SignUp;

public class MainActivity extends AppCompatActivity{


    private static final String TAG = "MainActivity";
    private static SectionStatePagerAdapter sectionStatePagerAdapter;
    private ViewPager viewPager;


    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started.");

        sectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());

        //klargører
        viewPager = (ViewPager) findViewById(R.id.containter);

        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Login(), "Login");
        adapter.addFragment(new SignUp(), "Sign up");
        adapter.addFragment(new Menu(), "Menu");
        adapter.addFragment(new AllRecipes(), "Our Recipes");
        adapter.addFragment(new AddRecipe(), "Your Recipes");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed() {

        if(viewPager.getCurrentItem()==3) {
            viewPager.setCurrentItem(2);
        }
        else if(viewPager.getCurrentItem()==4) {
            viewPager.setCurrentItem(2);
        }
        else if(viewPager.getCurrentItem()==2) {
            viewPager.setCurrentItem(0);
        }
    }

    }