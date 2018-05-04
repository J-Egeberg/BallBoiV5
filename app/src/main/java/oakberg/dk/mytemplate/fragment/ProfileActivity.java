//package oakberg.dk.mytemplate.fragment;
//
//
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.LayoutInflater;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.UserProfileChangeRequest;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;
//
//import java.io.IOException;
//
//import oakberg.dk.mytemplate.R;
//import oakberg.dk.mytemplate.activities.MainActivity;
//
//public class ProfileActivity extends Fragment {
//
//    private static final int CHOOSE_IMAGE = 101;
//
//    TextView textView;
//    ImageView imageView;
//    EditText editText;
//
//    Uri uriProfileImage;
//    ProgressBar progressBar;
//
//    String profileImageUrl;
//
//    private FirebaseAuth firebaseAuth;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
//        View view = inflater.inflate(R.layout.profile_activity, container, false);
//
//        firebaseAuth = FirebaseAuth.getInstance();
//
//
//
//        editText = (EditText) view.findViewById(R.id.editTextDisplayName);
//        imageView = (ImageView) view.findViewById(R.id.imageView);
//        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
//        textView = (TextView) view.findViewById(R.id.textViewVerified);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showImageChooser();
//            }
//        });
//
//        loadUserInformation();
//
//        view.findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                saveUserInformation();
//
//            }
//        });
//        return view;
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (firebaseAuth.getCurrentUser() == null) {
//
//            startActivity(new Intent(getActivity(), MainActivity.class));
//        }
//
//    }
//
//    private void loadUserInformation() {
//        final FirebaseUser user = firebaseAuth.getCurrentUser();
//
//        if (user != null) { }
//
//            if (user.getDisplayName() != null) {
//                editText.setText(user.getDisplayName());
//            }
//
//            if (user.isEmailVerified()) {
//                textView.setText("Email verified");
//
//            } else {
//
//                textView.setText("Email not verified (click to verify)");
//                textView.setOnClickListener(new View.OnClickListener() {
//
//                    public void onClick(View view) {
//                        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                Toast.makeText(getActivity(), "Verification Email Sent", Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//
//                    }
//
//                });
//
//            }
//        }
//
//
//    private void saveUserInformation() {
//
//        String displayName = editText.getText().toString();
//
//        if (displayName.isEmpty()) {
//            editText.setError("Name required");
//            editText.requestFocus();
//            return;
//        }
//
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//
//        // If the user and profile cant be found, he will be prompted to set photo and displayname
//
//        if (user != null && profileImageUrl != null) {
//            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
//                    .setDisplayName(displayName)
//                    .setPhotoUri(Uri.parse(profileImageUrl))
//                    .build();
//
//            // Updates the profile and tells the user accordingly
//
//            user.updateProfile(profile)
//                    .addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()) {
//                                Toast.makeText(getActivity(),  "Profile Updated", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//        }
//
//    }
//
//    private void showImageChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Select Profile Image"), CHOOSE_IMAGE);
//    }
//
//
//
//}
//
//
//
//
//
//
//
//
