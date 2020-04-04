package net.serkankaya.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        ImageView imageView=findViewById(R.id.image_view);

        Glide.with(this).load((R.drawable.splashscreen)).into(imageView);
        startMainScreen();
    }

    private void startMainScreen() {

        Thread git = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                } catch (Exception ex) {
                    System.out.println("Geçiş hatası " + ex.toString());
                } finally {
                    finish();
                }
            }
        };
        git.start();

    }
}
