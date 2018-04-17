package oakberg.dk.mytemplate.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.EasyEditSpan;
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
                .withBackgroundColor(Color.parseColor("#074E72"))
                .withLogo(R.mipmap.ic_launcher)
                .withHeaderText("Food on a budget")
                .withFooterText("Copyright 2018 - GROSS GROSS GROSS")
                .withBeforeLogoText("CPH Dev Co, Ltd")
                .withAfterLogoText("Satisfy your needs!");


                // SET TEXT COLOR


                config.getHeaderTextView().setTextColor(Color.WHITE);
                config.getFooterTextView().setTextColor(Color.WHITE);
                config.getAfterLogoTextView().setTextColor(Color.WHITE);
                config.getBeforeLogoTextView().setTextColor(Color.WHITE);

                // SET TO VIEW

                View view = config.create();

                // SET VIEW TO CONTENT VIEW

                setContentView(view);



    }
}
