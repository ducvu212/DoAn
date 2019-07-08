package pp.facerecognizer.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rbddevs.splashy.Splashy;

import pp.facerecognizer.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setSplashy();
    }

    private void setSplashy() {
        new Splashy(this)         // For JAVA : new Splashy(this)
                .setLogo(R.drawable.splashy)
                .setTitle("Splashy")
                .setTitleColor("#FFFFFF")
                .setSubTitle("Splash screen made easy")
                .setProgressColor(R.color.white)
                .setBackgroundResource("#000000")
                .setFullScreen(true)
                .setTime(5000)
                .show();
    }
}
