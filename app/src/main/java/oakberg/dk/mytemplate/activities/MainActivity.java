package oakberg.dk.mytemplate.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import oakberg.dk.mytemplate.fragment.ProfileActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    private static SectionStatePagerAdapter sectionStatePagerAdapter;
    private ViewPager viewPager;


    /* FOR LOGIN PURPOSES */
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;
    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);


        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);


        Log.d(TAG, "onCreate: Started.");

        sectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());

        //klargører
        viewPager = (ViewPager) findViewById(R.id.containter);

        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Login(), "Login");
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


    private void userLogin() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Minimum lenght of password should be 6");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if(task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } else {

                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));

        }
    }

    // REMEMBER LOGIN CLASS IS RESPONSBLE FOR HANDLING SIGNUP

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewSignin:
            finish();
            startActivity(new Intent(this, Login.class));
            break;

            case R.id.buttonLogin:
                userLogin();
                break;

        }
    }


}