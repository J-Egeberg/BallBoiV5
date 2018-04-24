package oakberg.dk.mytemplate.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;
import oakberg.dk.mytemplate.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#ACACAC"))
                .withLogo(R.drawable.cheap)
                .withHeaderText("")
                .withFooterText("Copyright 2018 - CPH Business")
                .withBeforeLogoText("")
                .withAfterLogoText("");


                // SET TEXT COLOR


                config.getHeaderTextView().setTextColor(Color.BLACK);
                config.getFooterTextView().setTextColor(Color.BLACK);
                config.getAfterLogoTextView().setTextColor(Color.BLACK);
                config.getBeforeLogoTextView().setTextColor(Color.BLACK);

                // SET TO VIEW

                View view = config.create();

                // SET VIEW TO CONTENT VIEW

                setContentView(view);



    }
}
