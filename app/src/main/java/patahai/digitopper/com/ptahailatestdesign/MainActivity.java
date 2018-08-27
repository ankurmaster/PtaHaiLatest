package patahai.digitopper.com.ptahailatestdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eftimoff.viewpagertransformers.BackgroundToForegroundTransformer;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.takusemba.spotlight.OnSpotlightStateChangedListener;
import com.takusemba.spotlight.OnTargetStateChangedListener;
import com.takusemba.spotlight.Spotlight;
import com.takusemba.spotlight.shape.Circle;
import com.takusemba.spotlight.target.SimpleTarget;
import com.wooplr.spotlight.SpotlightView;
import com.wooplr.spotlight.utils.SpotlightListener;

import java.util.ArrayList;

import patahai.digitopper.com.ptahailatestdesign.managers.CachingManager;
import patahai.digitopper.com.ptahailatestdesign.models.FactObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SlidingUpPanelLayout.PanelSlideListener, AdapterView.OnItemClickListener {


    private View fill_animation_bg;
    public CustomFlashcardViewpager viewpager;
    public MainPageAdpater mainPageAdpater;
    public SlidingUpPanelLayout sliding_layout;
    public ImageView slide_up_arrow;
    private GridView subCatGrid;
    private ImageView like_IV;
    private ImageView clap_IV;
    private ImageView palm_IV;
    private ImageView thumbs_down_IV;
    private ArrayList<ModelClassForSubCategories> subCategoriesListKnowledge = new ArrayList<>();
    private ArrayList<ModelClassForSubCategories> subCategoriesListNews = new ArrayList<>();
    private ArrayList<ModelClassForSubCategories> subCategoriesListEntertainment = new ArrayList<>();
    private ArrayList<FactObject> knowledgeList = new ArrayList<>();
    private ArrayList<FactObject> newsList = new ArrayList<>();
    private ArrayList<FactObject> entertainmentList = new ArrayList<>();
    int toolbarBottom;
    int categoriesBottom;
    private boolean isFullScreen = false;
    public DrawerLayout navigation_drawer;
    private NavigationView navigation_view;
    private ListView nav_menu_items;
    private CustomNavDrawerAdapter customNavDrawerAdapter;
    private ImageView overflow_menu;
    private Integer currentInteractionLayout;
    private Button log_in_btn;
    private Button sign_in_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();

        initDataSet();

        initDataSet2();

        initDataSet3();

        initTuts();




    }

    private void initTuts() {

        new SpotlightView.Builder(this)
                .introAnimationDuration(400)
                .enableRevealAnimation(true)
                .performClick(true)
                .fadeinTextDuration(400)
                .headingTvColor(Color.parseColor("#ffffff"))
                .headingTvSize(32)
                .headingTvText("Menu")
                .subHeadingTvColor(Color.parseColor("#ffffff"))
                .subHeadingTvSize(16)
                .subHeadingTvText("The menu button gives you access to your profile, your added facts, earning summary.")
                .maskColor(Color.parseColor("#dc000000"))
                .target(findViewById(R.id.nav_drawer))
                .lineAnimDuration(400)
                .lineAndArcColor(Color.parseColor("#f9ca10"))
                .dismissOnTouch(true)
                .dismissOnBackPress(true)
                .enableDismissAfterShown(true)
                .usageId("100") //UNIQUE ID
                .setListener(new SpotlightListener() {
                    @Override
                    public void onUserClicked(String s) {

                        new SpotlightView.Builder(MainActivity.this)
                                .introAnimationDuration(400)
                                .enableRevealAnimation(true)
                                .performClick(true)
                                .fadeinTextDuration(400)
                                .headingTvColor(Color.parseColor("#ffffff"))
                                .headingTvSize(32)
                                .headingTvText("Search")
                                .subHeadingTvColor(Color.parseColor("#ffffff"))
                                .subHeadingTvSize(16)
                                .subHeadingTvText("The search button allows you to explore whatever you have in mind. Our curated database helps you to learn in one click.")
                                .maskColor(Color.parseColor("#dc000000"))
                                .target(findViewById(R.id.search_facts))
                                .lineAnimDuration(400)
                                .lineAndArcColor(Color.parseColor("#f9ca10"))
                                .dismissOnTouch(true)
                                .dismissOnBackPress(true)
                                .enableDismissAfterShown(true)
                                .usageId("101") //UNIQUE ID
                                .setListener(new SpotlightListener() {
                                    @Override
                                    public void onUserClicked(String s) {

                                        new SpotlightView.Builder(MainActivity.this)
                                                .introAnimationDuration(400)
                                                .enableRevealAnimation(true)
                                                .performClick(true)
                                                .fadeinTextDuration(400)
                                                .headingTvColor(Color.parseColor("#ffffff"))
                                                .headingTvSize(32)
                                                .headingTvText("Options")
                                                .subHeadingTvColor(Color.parseColor("#ffffff"))
                                                .subHeadingTvSize(16)
                                                .subHeadingTvText("Find anything fake, wrong, missing.\n" +
                                                        "Don't worry; help us figure out the mistakes and get rewarded.")
                                                .maskColor(Color.parseColor("#dc000000"))
                                                .target(findViewById(R.id.overflow_menu))
                                                .lineAnimDuration(400)
                                                .lineAndArcColor(Color.parseColor("#f9ca10"))
                                                .dismissOnTouch(true)
                                                .dismissOnBackPress(true)
                                                .enableDismissAfterShown(true)
                                                .usageId("102") //UNIQUE ID
                                                .setListener(new SpotlightListener() {
                                                    @Override
                                                    public void onUserClicked(String s) {

                                                        new SpotlightView.Builder(MainActivity.this)
                                                                .introAnimationDuration(400)
                                                                .enableRevealAnimation(true)
                                                                .performClick(true)
                                                                .fadeinTextDuration(400)
                                                                .headingTvColor(Color.parseColor("#ffffff"))
                                                                .headingTvSize(32)
                                                                .headingTvText("Click here")
                                                                .subHeadingTvColor(Color.parseColor("#ffffff"))
                                                                .subHeadingTvSize(16)
                                                                .subHeadingTvText("Browse your interests from a host of categories.")
                                                                .maskColor(Color.parseColor("#dc000000"))
                                                                .target(findViewById(R.id.slide_up_arrow))
                                                                .lineAnimDuration(400)
                                                                .lineAndArcColor(Color.parseColor("#f9ca10"))
                                                                .dismissOnTouch(true)
                                                                .dismissOnBackPress(true)
                                                                .enableDismissAfterShown(true)
                                                                .usageId("104") //UNIQUE ID
                                                                .setListener(new SpotlightListener() {
                                                                    @Override
                                                                    public void onUserClicked(String s) {


                                                                    }
                                                                })
                                                                .show();


                                                    }
                                                })
                                                .show();

                                    }
                                })
                                .show();

                    }
                })
                .show();


    }

    private void initViews() {



        viewpager =  findViewById(R.id.viewPager);
        viewpager.setPagingEnabled(true);
        mainPageAdpater = new MainPageAdpater(getSupportFragmentManager());
        if(getIntent().getExtras()==null) {

            if(LanguageSelectorActivity.isEnglish) {

               addEnglishFacts();

            }else {

                addHindiFacts();
            }

        }
        else{

            ArrayList<FactObject> SearchedArrayList = (ArrayList<FactObject>) getIntent().getSerializableExtra("searchedFactsList");
            Integer posi = getIntent().getExtras().getInt("listPosi");
            mainPageAdpater.AddFlashCard(SearchedArrayList);
            viewpager.setAdapter(mainPageAdpater);
            viewpager.setPageTransformer(false,new BackgroundToForegroundTransformer());
            viewpager.setCurrentItem(posi);

        }
        sliding_layout = findViewById(R.id.sliding_layout);
        sliding_layout.addPanelSlideListener(this);
        slide_up_arrow = findViewById(R.id.slide_up_arrow);
        slide_up_arrow.setOnClickListener(this);
        findViewById(R.id.explore_TV).setAlpha(0);
        findViewById(R.id.explore_TV_underline).setAlpha(0);
        subCatGrid = findViewById(R.id.subCatGrid);
        subCatGrid.setOnItemClickListener(this);
        like_IV = findViewById(R.id.like_IV);
        like_IV.setOnClickListener(this);
        clap_IV = findViewById(R.id.clap_IV);
        clap_IV.setOnClickListener(this);
        palm_IV = findViewById(R.id.palm_IV);
        palm_IV.setOnClickListener(this);
        thumbs_down_IV = findViewById(R.id.dislike_IV);
        thumbs_down_IV.setOnClickListener(this);
        navigation_drawer = findViewById(R.id.navigation_drawer);
        navigation_view = findViewById(R.id.navigation_view);
        nav_menu_items = findViewById(R.id.nav_menu_items);
        fill_animation_bg = findViewById(R.id.fill_animation_bg);
        overflow_menu = findViewById(R.id.overflow_menu);
        findViewById(R.id.setToDefaultButton).setOnClickListener(this);
        findViewById(R.id.setToDefaultButton).setClickable(false);
        log_in_btn = findViewById(R.id.log_in_btn);
        log_in_btn.setOnClickListener(this);
        sign_in_btn = findViewById(R.id.sign_in_btn);
        sign_in_btn.setOnClickListener(this);
        nav_menu_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){

                    startActivity(new Intent(MainActivity.this,ViewProfile.class));
                }

            }
        });
        customNavDrawerAdapter = new CustomNavDrawerAdapter(DataLoader.getDrawerItemList(),MainActivity.this,MainActivity.this);
        nav_menu_items.setAdapter(customNavDrawerAdapter);

        initGridSubCatKnowledge();


    }

    public void addEnglishFacts(){

        Log.e("Hello ankur",CachingManager.getEnglishFactList().toString());
        mainPageAdpater.AddFlashCard(CachingManager.getEnglishFactList());
        viewpager.setAdapter(mainPageAdpater);
        viewpager.setPageTransformer(false, new BackgroundToForegroundTransformer());

    }

    public void addHindiFacts(){

        mainPageAdpater.AddFlashCard(CachingManager.getHindiFactList());
        viewpager.setAdapter(mainPageAdpater);
        viewpager.setPageTransformer(false, new BackgroundToForegroundTransformer());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){



            case R.id.slide_up_arrow:

                sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                slide_up_arrow.animate().alpha(0).setInterpolator(new DecelerateInterpolator()).setDuration(300).start();
                break;

            case R.id.like_IV:

                startLikeAnimation();

                break;

            case R.id.clap_IV:

                    startClapAnimation();
                break;


            case R.id.palm_IV:



                    startPalmAnimation();



                break;


            case R.id.dislike_IV:

                startDislikeAnimation();

                break;


            case R.id.setToDefaultButton:

                setDefaultInteractions(currentInteractionLayout);

                break;

            case R.id.CopyrightInfringeTV:

                reportCopyrightInfringeBox();

                break;

                case R.id.ObjectionaleContentTV:

                    reportObjectionableBox();

                break;

                case R.id.spellingMistakeTV:

                    createSpellMistakeBox();

                break;

                case R.id.queryTV:

                    createPostQueryBox();

                break;

            case R.id.log_in_btn:

                startActivity(new Intent(MainActivity.this,SignUpActivity.class));

                    break;


            case R.id.sign_in_btn:

                startActivity(new Intent(MainActivity.this,LogInActivity.class));

                break;





        }

    }

    public void disableInteractions(){

        like_IV.setClickable(false);
        palm_IV.setClickable(false);
        clap_IV.setClickable(false);
        thumbs_down_IV.setClickable(false);
        findViewById(R.id.setToDefaultButton).setClickable(true);


    }

    public void enableInteractions(){

        like_IV.setClickable(true);
        palm_IV.setClickable(true);
        clap_IV.setClickable(true);
        thumbs_down_IV.setClickable(true);
        findViewById(R.id.setToDefaultButton).setClickable(false);


    }

    private void createPostQueryBox() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View query_view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.post_query_alert_box,null,false);

        alert.setView(query_view);

        final AlertDialog dialog = alert.create();


        query_view.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });


        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.TOP);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void reportCopyrightInfringeBox(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View copyright_alert_view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.report_copyright_alert_box,null,false);
        alert.setView(copyright_alert_view);
        final AlertDialog dialog = alert.create();

        copyright_alert_view.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.TOP);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void reportObjectionableBox() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View objectionable_view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.report_objectionable_alert_box,null,false);
        alert.setView(objectionable_view);

        final AlertDialog dialog = alert.create();

        objectionable_view.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.TOP);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void createSpellMistakeBox() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View spell_view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.spell_mistake_box,null,false);

        alert.setView(spell_view);

        // disallow cancel of AlertDialog on click of back button and outside touch
        final AlertDialog dialog = alert.create();

        spell_view.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });


        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.TOP);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void startDislikeAnimation() {


        findViewById(R.id.interactionHolderLayout).animate().alpha(0).setDuration(500).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                disableInteractions();
            }
        });
        findViewById(R.id.dislike_layout).animate().alpha(1).setDuration(300).setInterpolator(new AccelerateInterpolator()).start();
        currentInteractionLayout = R.id.dislike_layout;

    }

    private void startLikeAnimation() {


        findViewById(R.id.interactionHolderLayout).animate().alpha(0).setDuration(500).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                disableInteractions();

            }
        });
        findViewById(R.id.like_layout).animate().alpha(1).setDuration(300).setInterpolator(new AccelerateInterpolator()).start();
        currentInteractionLayout = R.id.like_layout;

    }

    private void startClapAnimation() {

        findViewById(R.id.interactionHolderLayout).setClickable(false);
        findViewById(R.id.interactionHolderLayout).animate().alpha(0).setDuration(500).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                disableInteractions();
            }
        });
        findViewById(R.id.clap_layout).animate().alpha(1).setDuration(300).setInterpolator(new AccelerateInterpolator()).start();
        currentInteractionLayout = R.id.clap_layout;

    }

    private void startPalmAnimation() {

        findViewById(R.id.interactionHolderLayout).setClickable(false);
        findViewById(R.id.interactionHolderLayout).animate().alpha(0).setDuration(500).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                disableInteractions();
            }
        });
        findViewById(R.id.palm_layout).animate().alpha(1).setDuration(300).setInterpolator(new AccelerateInterpolator()).start();
        currentInteractionLayout = R.id.palm_layout;

    }

    private void setDefaultInteractions(int layout_ID){

        findViewById(layout_ID).setAlpha(0);
        findViewById(R.id.interactionHolderLayout).animate().alpha(1).setDuration(300).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                enableInteractions();

            }
        });


    }




    public void addBollywoodFacts(){

        ArrayList<FactObject> list;
        if(LanguageSelectorActivity.isEnglish)
        {
            list = CachingManager.getEntertainmentList();
        }
        else
        {

            list = CachingManager.getEntertainmentHindiList();
        }
        if(list.isEmpty())
            return;
        mainPageAdpater.AddFlashCard(list);
        viewpager.getAdapter().notifyDataSetChanged();
        viewpager.setCurrentItem(0,true);


    }

    public void addScienceFacts(String subcategory) {

        mainPageAdpater.FlashCardList.clear();
        mainPageAdpater.AddFlashCard(DataLoader.getSubCategoryFacts(subcategory));
        viewpager.getAdapter().notifyDataSetChanged();
        viewpager.setCurrentItem(0,true);

    }



    public void addNewsCat(){
        ArrayList<FactObject> list;
        if(LanguageSelectorActivity.isEnglish)
        {

            list = CachingManager.getNewsList();

        }
        else {

            list = CachingManager.getNewsHindiList();
        }
        if(list.isEmpty())
            return;
        mainPageAdpater.AddFlashCard(list);
        viewpager.getAdapter().notifyDataSetChanged();
        viewpager.setCurrentItem(0,true);

    }

    public void addKnowledgeCat() {


            mainPageAdpater.FlashCardList.clear();
        ArrayList<FactObject> list = new ArrayList<>();

            if(LanguageSelectorActivity.isEnglish) {


                list.addAll(CachingManager.getKnowledgeList());

            }
            else {

                list.addAll(CachingManager.getKnowledgeListHindi());
            }
              mainPageAdpater.AddFlashCard(list);
            viewpager.getAdapter().notifyDataSetChanged();
            viewpager.setCurrentItem(0, true);

    }


    public void initGridSubCatKnowledge(){

        subCatGrid.setAdapter(new CategoriesGridAdapter(this,subCategoriesListKnowledge));

    }

    public void initGridSubCatNews(){

        subCatGrid.setAdapter(new CategoriesGridAdapter(this,subCategoriesListNews));

    }

    public void initGridSubCatEntertainment(){

        subCatGrid.setAdapter(new CategoriesGridAdapter(this,subCategoriesListEntertainment));

    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {

        findViewById(R.id.interactions_layout).setAlpha(1-slideOffset);
        findViewById(R.id.explore_TV).setAlpha(slideOffset);
        findViewById(R.id.explore_TV_underline).setAlpha(slideOffset);
        slide_up_arrow.setAlpha(1-slideOffset*5);

    }

    @Override
    public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

        if(newState.equals(SlidingUpPanelLayout.PanelState.COLLAPSED)){

            slide_up_arrow.animate().alpha(1).setInterpolator(new DecelerateInterpolator()).setDuration(300).start();
            sliding_layout.setDragView(null);
            sliding_layout.setDragView(R.id.slide_up_arrow);



        }else if(newState.equals(SlidingUpPanelLayout.PanelState.EXPANDED)){

           // sliding_layout.setDragView(R.id.explore_layout);
            sliding_layout.setTouchEnabled(false);
        }

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ModelClassForSubCategories subCategories = (ModelClassForSubCategories) parent.getItemAtPosition(position);

        addScienceFacts(subCategories.getSubCatTitle());

        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

      /* if(subCategories.getSubCatTitle().equalsIgnoreCase("Science")){

            addScienceFacts("Science");
            sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

        }
        else if(subCategories.getSubCatTitle().equalsIgnoreCase("Current Affairs")){

           // addCurrentAffairs();
            addScienceFacts("Current Affairs");
            sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

        }else if(subCategories.getSubCatTitle().equalsIgnoreCase("Nature")){

            //addNatureFacts();
           addScienceFacts("Nature");
            sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

        }else if(subCategories.getSubCatTitle().equalsIgnoreCase("Art")){

            //addSportsFacts();
           addScienceFacts("Art");
            sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

        }else if(subCategories.getSubCatTitle().equalsIgnoreCase("Auto")){

          // addSportsFacts();
           addScienceFacts("Auto");
           sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

       }else if(subCategories.getSubCatTitle().equalsIgnoreCase("Food")){

          // addSportsFacts();
           addScienceFacts("Food");
           sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

       }else if(subCategories.getSubCatTitle().equalsIgnoreCase("Health")){

           //addSportsFacts();
           addScienceFacts("Health");
           sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

       }else if(subCategories.getSubCatTitle().equalsIgnoreCase("Map")){

           //addSportsFacts();
           addScienceFacts("Map");
           sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

       }else if(subCategories.getSubCatTitle().equalsIgnoreCase("Travel")){

           //addSportsFacts();
           addScienceFacts("Travel");
           sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

       }
       else if(subCategories.getSubCatTitle().equalsIgnoreCase("History")){

           //addSportsFacts();
           addScienceFacts("History");
           sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

       }*/


    }

    private void initDataSet() {


        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Science",R.drawable.science));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Current Affairs",R.drawable.current_affairs));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Nature",R.drawable.nature));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Art",R.drawable.art));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Auto",R.drawable.auto));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Food",R.drawable.food));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Health",R.drawable.health));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Map",R.drawable.map));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Travel",R.drawable.travel));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("History",R.drawable.history));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Environment",R.drawable.environment));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("People and Society",R.drawable.people));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Literature",R.drawable.literature));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Geography",R.drawable.geography));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Technology",R.drawable.tech));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Military",R.drawable.soldier));
        subCategoriesListKnowledge.add(new ModelClassForSubCategories("Miscellaneous",R.drawable.misc));


    }

    private void initDataSet2() {


        subCategoriesListNews.add(new ModelClassForSubCategories("Politics",R.drawable.politics));
        subCategoriesListNews.add(new ModelClassForSubCategories("Sports",R.drawable.sports));
        subCategoriesListNews.add(new ModelClassForSubCategories("Business",R.drawable.business));



    }

    private void initDataSet3() {


        subCategoriesListEntertainment.add(new ModelClassForSubCategories("Bollywood",R.drawable.bollywood));
        subCategoriesListEntertainment.add(new ModelClassForSubCategories("Hollywood",R.drawable.hollywood));
        subCategoriesListEntertainment.add(new ModelClassForSubCategories("Bizzare",R.drawable.tollywood));

    }

    public void hideToolbarAndOtherViews() {

        toolbarBottom = findViewById(R.id.toolbar).getBottom();
        isFullScreen=true;

        findViewById(R.id.toolbar).animate().translationY(-toolbarBottom).setInterpolator(new AccelerateInterpolator()).start();

        final SlideFragment slideFragment = mainPageAdpater.fragList.get(viewpager.getCurrentItem());
        categoriesBottom = slideFragment.mainCategories.getHeight();
        viewpager.setPagingEnabled(false);
        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
        slideFragment.readMoreTV.animate().alpha(0);
        slide_up_arrow.animate().alpha(0).setInterpolator(new DecelerateInterpolator()).setDuration(300).start();


        slideFragment.mainCategories.animate().translationY(-findViewById(R.id.toolbar).getBottom()-slideFragment.mainCategories.getBottom()).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {


                final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) slideFragment.fact_IV.getLayoutParams();
                ValueAnimator animator = ValueAnimator.ofInt(params.leftMargin,params.rightMargin,params.topMargin, -20);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator)
                    {
                        params.leftMargin = (Integer) valueAnimator.getAnimatedValue();
                        params.rightMargin = (Integer) valueAnimator.getAnimatedValue();
                        params.topMargin = (Integer) valueAnimator.getAnimatedValue();
                        slideFragment.fact_IV.requestLayout();
                    }
                });
                animator.setDuration(300);
                animator.start();

                findViewById(R.id.toolbar).setVisibility(View.GONE);

                slideFragment.loadWebView();

            }
        });


    }

    public void showToolbarAndOtherViews() {

        findViewById(R.id.toolbar).animate().translationY(0).setInterpolator(new AccelerateInterpolator()).start();


        final SlideFragment slideFragment = mainPageAdpater.fragList.get(viewpager.getCurrentItem());
        isFullScreen=false;
        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        slideFragment.htmlWebView.setVisibility(View.GONE);
        slideFragment.readMoreTV.animate().alpha(1);
        viewpager.setPagingEnabled(true);
        slide_up_arrow.animate().alpha(1).setInterpolator(new DecelerateInterpolator()).setDuration(500).start();


        slideFragment.mainCategories.animate().translationY(0).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) slideFragment.fact_IV.getLayoutParams();

                ValueAnimator animator = ValueAnimator.ofInt(100,0,20,20);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {

                        params.topMargin = findViewById(R.id.toolbar).getBottom();
                        params.bottomMargin = (Integer) valueAnimator.getAnimatedValue();
                        params.leftMargin = (Integer) valueAnimator.getAnimatedValue();
                        params.rightMargin = (Integer) valueAnimator.getAnimatedValue();
                        slideFragment.fact_IV.requestLayout();
                    }
                });
                animator.setDuration(300);
                animator.start();

                findViewById(R.id.toolbar).setVisibility(View.VISIBLE);


            }
        });


    }

    @Override
    public void onBackPressed() {



        if(sliding_layout.getPanelState()== SlidingUpPanelLayout.PanelState.EXPANDED)sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        else if(isFullScreen)showToolbarAndOtherViews();
        else moveTaskToBack(true);


    }

    public void searchFactsOnClick(View view) {

        startActivity(new Intent(this,SearchActivity.class));

    }

    public void overflowMenuOnClick(View view) {


        createInitialDialogBox();
    }

    private void createInitialDialogBox() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View overflow_menu =  LayoutInflater.from(MainActivity.this).inflate(R.layout.initial_overflow_menu,null,false);
        alert.setView(overflow_menu);



        // disallow cancel of AlertDialog on click of back button and outside touch
        final AlertDialog dialog = alert.create();

        overflow_menu.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        overflow_menu.findViewById(R.id.CopyrightInfringeTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reportCopyrightInfringeBox();
            }
        });

        overflow_menu.findViewById(R.id.ObjectionaleContentTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reportObjectionableBox();
            }
        });

        overflow_menu.findViewById(R.id.spellingMistakeTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createSpellMistakeBox();
            }
        });

        overflow_menu.findViewById(R.id.queryTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createPostQueryBox();
            }
        });




        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.TOP);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void NavDrawerOnClick(View view) {

        navigation_drawer.openDrawer(Gravity.START);
    }



}


