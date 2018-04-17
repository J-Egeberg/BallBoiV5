package oakberg.dk.mytemplate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

import oakberg.dk.mytemplate.R;
import oakberg.dk.mytemplate.activities.MainActivity;

/**
 * Created by Oakberg on 06/04/2018.
 */

public class Login extends Fragment {

    private Button loginButton;
    private Button registerButton;
    private String userName;
    private String password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_fragment_layout, container, false);

        loginButton = (Button) view.findViewById(R.id.loginbtn);
        registerButton = (Button) view.findViewById(R.id.registerbtn);
        //userName = view.findViewById(R.id.usernametxt);
        //password = view.findViewById(R.id.passwordtxt);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to the menu", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        return view;
    }

}
