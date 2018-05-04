package oakberg.dk.mytemplate.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.activities.MainActivity;
import oakberg.dk.mytemplate.entity.User;

public class Login extends Fragment {


    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button login;
    private TextView signUp;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signin_fragment_layout, container, false);
        super.onCreate(savedInstanceState);


        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);

        signUp = view.findViewById(R.id.textViewSignUp);
        login = view.findViewById(R.id.buttonLogin);

        signUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Sign Up Menu", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });


        return view;
    }



    private void userLogin() {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

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

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    Toast.makeText(getActivity(), "User Credentials Accepted", Toast.LENGTH_SHORT).show();
                    ((MainActivity)getActivity()).setViewPager(2);

                    //her vil vi evt gerne gemme bruger info så vi kan bruge det på recipes

                    FirebaseUser firebaseUser = mAuth.getCurrentUser();

                    //kan se vi er logget på den rigtige user i loggen
                    Log.d("authentication","User: " + firebaseUser.getEmail());

                } else {

                    Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    ((MainActivity)getActivity()).setViewPager(0);
                    Toast.makeText(getActivity(), "Something happened - please try again", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

//        if (mAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getActivity(), User.class));
//
//        }
    }


    }