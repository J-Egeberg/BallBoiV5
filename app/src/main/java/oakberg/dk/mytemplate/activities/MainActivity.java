package oakberg.dk.mytemplate.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.fragment.Exit;
import oakberg.dk.mytemplate.fragment.AddFood;
import oakberg.dk.mytemplate.fragment.Login;
import oakberg.dk.mytemplate.fragment.Menu;
import oakberg.dk.mytemplate.fragment.MyRecipes;
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
        adapter.addFragment(new MyRecipes(), "My Recipes");
        adapter.addFragment(new AllRecipes(), "All Recipes");
        adapter.addFragment(new AddFood(), "Add Food");
        adapter.addFragment(new Exit(), "Exit");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed() {
        viewPager.setCurrentItem(1);
    }

    }