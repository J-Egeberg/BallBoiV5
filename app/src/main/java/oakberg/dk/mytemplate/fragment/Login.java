//package oakberg.dk.mytemplate.fragment;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.text.TextUtils;
//import android.util.Patterns;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//
//import org.w3c.dom.Text;
//
//import oakberg.dk.mytemplate.R;
//import oakberg.dk.mytemplate.activities.MainActivity;
//
///**
// * Created by Oakberg on 06/04/2018.
// */
//
//public class Login extends Fragment implements View.OnClickListener {
//
//    private Button buttonRegister;
//    private EditText editTextEmail;
//    private EditText editTextPassword;
//    private TextView textViewSignin;
//
//    private ProgressDialog progressDialog;
//    private ProgressBar progressBar;
//
//    private FirebaseAuth firebaseAuth;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.login_fragment_layout, container, false);
//
//
//        firebaseAuth = FirebaseAuth.getInstance();
//
//        progressDialog = new ProgressDialog(this.getContext());
//
//
//        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
//
//
//        buttonRegister = (Button) view.findViewById(R.id.buttonRegister);
//
//        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
//        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
//
//        textViewSignin = (TextView) view.findViewById(R.id.textViewSignin);
//
//
//        buttonRegister.setOnClickListener(this);
//        textViewSignin.setOnClickListener(this);
//
//        return view;
//    }
//
//
//        private void registerUser() {
//            String email = editTextEmail.getText().toString().trim();
//            String password = editTextPassword.getText().toString().trim();
//
//            // Test if the string is empty when user tries to login
//
//            if (email.isEmpty()) {
//                editTextEmail.setError("Email is required");
//                editTextEmail.requestFocus();
//                return;
//
//            }
//
//            // Test if the email pattern matches email typo
//
//            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//
//                editTextEmail.setError("Please enter a valid email");
//                editTextEmail.requestFocus();
//                return;
//            }
//
//            // Test if empty password
//
//            if (password.isEmpty()) {
//                editTextPassword.setError("Password is required");
//                editTextPassword.requestFocus();
//                return;
//
//            }
//
//            // Test password length is correct
//
//            if (password.length() < 6) {
//                editTextPassword.setError("Minimum length is 6 characters");
//                editTextPassword.requestFocus();
//                return;
//            }
//
//            progressBar.setVisibility(View.VISIBLE);
//
//
//            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    progressBar.setVisibility(View.GONE);
//                    if (task.isSuccessful()) {
//
//                        finish();
//                        startActivity(new Intent(Login.this, ProfileActivity.class));
//                    } else {
//
//                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//                            Toast.makeText(), "You are already registered", Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                }
//            });
//
//        }
//
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.buttonRegister:
//                registerUser();
//                break;
//
//            case R.id.textViewSignup:
//                finish();
//                startActivity(new Intent(this, MainActivity.class));
//                break;
//        }
//    }
//}
//
