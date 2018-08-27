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
import android.widget.Toast;

public class LanguageSelectorActivity extends AppCompatActivity implements View.OnClickListener {


    public static boolean isEnglish = true;
    private TextView tv_english;
    private TextView tv_hindi;
    private TextView Next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_language_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();

    }

    private void initViews() {

        tv_english = findViewById(R.id.tv_english);
        tv_hindi = findViewById(R.id.tv_hindi);
        Next = findViewById(R.id.Next);

        tv_english.setOnClickListener(this);
        tv_hindi.setOnClickListener(this);
        Next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tv_english:

                isEnglish = true;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                    if(tv_english.getBackground().getConstantState()==getResources().getDrawable(R.drawable.select_language_selected).getConstantState()){


                    }else {

                        tv_english.setBackground(getResources().getDrawable(R.drawable.select_language_selected));
                        tv_english.setTextColor(Color.parseColor("#ffffff"));

                        tv_hindi.setBackground(getResources().getDrawable(R.drawable.select_language_drawable));
                        tv_hindi.setTextColor(Color.parseColor("#000000"));


                    }


                }


                break;

            case R.id.tv_hindi:

                isEnglish = false;



                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                    if(tv_hindi.getBackground().getConstantState()==getResources().getDrawable(R.drawable.select_language_selected).getConstantState()){

                    }else {

                        tv_hindi.setBackground(getResources().getDrawable(R.drawable.select_language_selected));
                        tv_hindi.setTextColor(Color.parseColor("#ffffff"));

                        tv_english.setBackground(getResources().getDrawable(R.drawable.select_language_drawable));
                        tv_english.setTextColor(Color.parseColor("#000000"));


                    }


                }


                break;


            case R.id.Next:

                if(tv_english.getBackground().getConstantState()==getResources().getDrawable(R.drawable.select_language_selected).getConstantState()||tv_hindi.getBackground().getConstantState()==getResources().getDrawable(R.drawable.select_language_selected).getConstantState()) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        Next.setBackground(getResources().getDrawable(R.drawable.select_language_selected));
                        Next.setTextColor(Color.parseColor("#ffffff"));
                        startActivity(new Intent(LanguageSelectorActivity.this, MainActivity.class));
                    }



                }
                else {

                    Toast.makeText(this, "Please select a language to continue", Toast.LENGTH_SHORT).show();
                }


                break;


        }

    }
}
