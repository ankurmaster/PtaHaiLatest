package patahai.digitopper.com.ptahailatestdesign;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class SlideFragment extends Fragment implements View.OnClickListener{

    public  EasyFlipView flashcard_flip;
    private CardView front_flash_card;
    private CardView back_flash_card;
    private ImageView bookmark_IV;
    public ImageView flash_card_IV;
    private TextView shortDesp_TV;
    private TextView longDesp_TV;
    private MainActivity activity;
    private TextView category_TV;
    private Button newsButton;
    private Button knowledgeButton;
    private Button entertainmentButton;
    public TextView readMoreTV;
    public LinearLayout mainCategories;
    public CardView flash_card_holder;
    public FrameLayout fact_IV;
    public WebView htmlWebView;
    public ProgressBar webViewLoadingProgress;
    public RelativeLayout flash_card_parent;
    private Object object;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.front_flash_card,container,false);

        activity = (MainActivity)getActivity();

        init(view);


         object = getArguments().getSerializable("FragObj");

        Glide.with(getActivity()).asBitmap().load(((FactObject)object).getImage().replaceAll("\\\\","")).into(flash_card_IV);

         setCurrentFlashCardCategory(object);




        shortDesp_TV.setText("");

        if(shortDesp_TV.getText().toString().equalsIgnoreCase("")){

            shortDesp_TV.setVisibility(View.GONE);


        }else {

            shortDesp_TV.setVisibility(View.VISIBLE);


        }
        longDesp_TV.setText(((FactObject)object).getTitle());
        category_TV.setText(((FactObject)object).getCategory());








        return view;



    }

    private void setCurrentFlashCardCategory(Object object) {

        if (object != null) {
            switch (((FactObject) object).getParent()) {

                case "Knowledge":


                    knowledgeButton.setTextColor(Color.parseColor("#ffffff"));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                        knowledgeButton.setBackground(getActivity().getResources().getDrawable(R.drawable.categories_fill_selected));
                    }
                    break;

                case "News":


                    newsButton.setTextColor(Color.parseColor("#ffffff"));


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                        newsButton.setBackground(getActivity().getResources().getDrawable(R.drawable.categories_fill_selected));
                    }
                    break;

                case "Entertainment":


                    entertainmentButton.setTextColor(Color.parseColor("#ffffff"));


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                        entertainmentButton.setBackground(getActivity().getResources().getDrawable(R.drawable.categories_fill_selected));
                    }
                    break;
            }


        }


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser) {

            if (object != null) {
                switch (((FactObject) object).getParent()) {

                    case "Knowledge":

                        activity.initGridSubCatKnowledge();

                        break;

                    case "News":


                        activity.initGridSubCatNews();

                        break;

                    case "Entertainment":

                        activity.initGridSubCatEntertainment();

                        break;
                }


            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init(View view) {

         flashcard_flip = view.findViewById(R.id.flashcard_flip);
         back_flash_card = view.findViewById(R.id.back_flash_card);
        // bookmark_IV =view.findViewById(R.id.bookmark_IV);
         flash_card_IV = view.findViewById(R.id.flash_card_IV);
         shortDesp_TV = view.findViewById(R.id.short_description);
         longDesp_TV = view.findViewById(R.id.long_description);
        category_TV = view.findViewById(R.id.category_TV);
        readMoreTV = view.findViewById(R.id.readMoreTV);
        readMoreTV.setOnClickListener(this);
        newsButton = view.findViewById(R.id.newButton);
        knowledgeButton = view.findViewById(R.id.knowledgeButton);
        entertainmentButton = view.findViewById(R.id.entertainmentButton);
        newsButton.setOnClickListener(this);
        entertainmentButton.setOnClickListener(this);
        knowledgeButton.setOnClickListener(this);
        mainCategories = view.findViewById(R.id.mainCategories);
        flash_card_holder = view.findViewById(R.id.flash_card_holder);
        fact_IV = view.findViewById(R.id.fact_IV);
        htmlWebView = view.findViewById(R.id.flash_card_WV);
        webViewLoadingProgress = view.findViewById(R.id.webViewLoadingProgress);
        view.findViewById(R.id.flash_card_parent).setOnClickListener(this);
        category_TV.setOnClickListener(this);
        flash_card_parent = view.findViewById(R.id.flash_card_parent);
        htmlWebView.setOnTouchListener(new View.OnTouchListener() {
                                           public boolean onTouch(View v, MotionEvent event) {
                                               return (event.getAction() == MotionEvent.ACTION_MOVE);
                                           }
                                       });
      /*



         front_flash_card.setOnClickListener(this);
         back_flash_card.setOnClickListener(this);
         bookmark_IV.setOnClickListener(this);*/




    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {
           /* case R.id.bookmark_IV:

                bookmark_IV.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_action__bookmark));

                break;

            case R.id.front_flash_card:

                flashcard_flip.flipTheView(true);
                break;


            case R.id.back_flash_card:

                flashcard_flip.flipTheView(true);
                if(flashcard_flip.isBackSide())flashcard_flip.flipTheView(true);
                break;



            case R.id.like_IV:


                like_IV.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.like2));

                break;


            case R.id.clap_IV:

                clap_IV.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.clap2));
                break;


            case R.id.palm_IV:

                palm_IV.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ap2));

                break;


            case R.id.thumbs_down_IV:

                thumbs_down_IV.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.dislike2));
                break;

            case R.id.current_affairs_IV:

                addCurrentAffairs();

                break;

            case R.id.nature_IV:


                addNatureFacts();

                break;

            case R.id.science_IV:

                addScienceFacts();

                break;

            case R.id.Politics:

                addPoliticsFacts();

                break;

            case R.id.Sports:

                addSportsFacts();

                break;


            case R.id.Hollywood:

                addHollywoodfacts();

                break;

            case R.id.Bollywood:

                addBollywoodFacts();

                break;


            case R.id.goToSearchActivityOnClick:

                startActivity(new Intent(getContext(),SearchActivity.class));

                break;

*/

            case R.id.newButton:

                activity.addNewsCat();

                break;

            case R.id.entertainmentButton:

                activity.addBollywoodFacts();

                break;

            case R.id.knowledgeButton:

                activity.addKnowledgeCat();

                break;



            case R.id.readMoreTV:

               activity.hideToolbarAndOtherViews();

               break;


            case R.id.subCatParentLayout:

                break;

            case R.id.category_TV:

                activity.addScienceFacts(category_TV.getText().toString());

                break;

        }
    }


    public void loadWebView() {


        webViewLoadingProgress.setVisibility(View.VISIBLE);
        htmlWebView.setVisibility(View.VISIBLE);
        htmlWebView.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        htmlWebView.loadUrl(((FactObject)object).getLink());


    }



    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            webViewLoadingProgress.setVisibility(View.GONE);
        }
    }
}
