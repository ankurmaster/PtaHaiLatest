package patahai.digitopper.com.ptahailatestdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class LanguageSelectorActivity extends AppCompatActivity {


    public static boolean isEnglish = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_language_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        findViewById(R.id.tv_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isEnglish = true;

                ((TextView)findViewById(R.id.tv_english)).setTextColor(Color.parseColor("#ffffff"));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                    ((TextView)findViewById(R.id.tv_english)).setBackground(getResources().getDrawable(R.drawable.select_language_selected));
                }
            }
        });


        findViewById(R.id.tv_hindi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isEnglish = false;

                ((TextView)findViewById(R.id.tv_hindi)).setTextColor(Color.parseColor("#ffffff"));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                    ((TextView)findViewById(R.id.tv_hindi)).setBackground(getResources().getDrawable(R.drawable.select_language_selected));
                }
            }
        });


        findViewById(R.id.Next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LanguageSelectorActivity.this,MainActivity.class));
            }
        });



    }
}
