package patahai.digitopper.com.ptahailatestdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import patahai.digitopper.com.ptahailatestdesign.Presenters.SplashPresenter;
import patahai.digitopper.com.ptahailatestdesign.apiclient.BConnectAPICallback;
import patahai.digitopper.com.ptahailatestdesign.apiclient.BConnectAPIClient;
import patahai.digitopper.com.ptahailatestdesign.apiclient.BConnectAPIRequest;
import patahai.digitopper.com.ptahailatestdesign.interfaces.ConnectionInterface;
import patahai.digitopper.com.ptahailatestdesign.managers.PersistentManager;
import patahai.digitopper.com.ptahailatestdesign.models.FactObject;
import patahai.digitopper.com.ptahailatestdesign.models.Facts;
import retrofit2.Call;

public class Splash extends AppCompatActivity implements ConnectionInterface {

    private SplashPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SplashPresenter();
        BConnectAPIClient.init(BConnectAPIRequest.class, getApplicationContext());
        setContentView(R.layout.activity_splash);
        PersistentManager.writeContentToSharedPreferences("ok",String.class);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageView logo = findViewById(R.id.logo);


        Glide.with(this)
                .asGif()
                .load(R.drawable.splash_lgo)
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource)
                    {
                        presenter.getFactsFromServer();
                        if(!PersistentManager.getIsFirstTime())
                        {
                            startActivity(new Intent(getApplicationContext(), LanguageSelectorActivity.class));

                        }
                        else {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            PersistentManager.setIsFirstTime(true);
                        }
                        finish();

                        return false;
                    }
                }).into(logo);



    }



    @Override
    public void getFactsFromServer() {

    }
}
