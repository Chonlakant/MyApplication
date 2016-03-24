package ismart.ipro.com.myapplication;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


import com.squareup.picasso.Picasso;

import ismart.ipro.com.myapplication.activity.CourseActivity;
import ismart.ipro.com.myapplication.adapter.MyRecyclerAdapter;
import ismart.ipro.com.myapplication.event.ActivityResultBus;
import ismart.ipro.com.myapplication.event.ApiBus;
import ismart.ipro.com.myapplication.event.FeedReceivedEvent;
import ismart.ipro.com.myapplication.event.FeedRequestedEvent;
import ismart.ipro.com.myapplication.event.PhotoReceivedEvent;
import ismart.ipro.com.myapplication.event.PhotoRequestedEvent;
import ismart.ipro.com.myapplication.model.Post;

public class MainActivity extends ActionBarActivity   {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    RelativeLayout content_frame;
    ProgressBar progressBar2;

    MyRecyclerAdapter myRecyclerAdapter;

    ArrayList<Post> list = new ArrayList<>();
    private String TAG = MainActivity.class.getSimpleName();
    RecyclerView recList;
    ImageView image_view;

    String photo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        image_view = (ImageView) findViewById(R.id.image_view);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        content_frame = (RelativeLayout) findViewById(R.id.content_frame);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
      //  mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        progressBar2.setVisibility(View.VISIBLE);
        ApiBus.getInstance().postQueue(new FeedRequestedEvent());
        ApiBus.getInstance().postQueue(new PhotoRequestedEvent());


        //String selfUserId = IsmartApp.getInstance().getPrefManager().getUser().getId();
        // String selfUserId =  IsmartApp.getInstance().getPrefManagerPaty().id().getOr("");
        String selfUserId = IsmartApp.getInstance().getPrefManagerPaty().vendeName().getOr("");
        Log.e("ssss", selfUserId);


        setupViews();
        recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);



        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Maintenance Community");
            toolbar.setTitleTextColor(Color.BLACK);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                    this,
                    drawerLayout,
                    toolbar,
                    R.string.drawer_open,
                    R.string.drawer_close);
            drawerLayout.setDrawerListener(drawerToggle);
            drawerToggle.setDrawerIndicatorEnabled(true);

            drawerToggle.syncState();
        }

    }


    private void setupViews() {
        // navigationView.addHeaderView(new DrawerHeaderView(this));
        ImageView user_image = (ImageView) navigationView.findViewById(R.id.user_image);
        LinearLayout News = (LinearLayout) navigationView.findViewById(R.id.News);
        LinearLayout vdo = (LinearLayout) navigationView.findViewById(R.id.vdo);
        LinearLayout About = (LinearLayout) navigationView.findViewById(R.id.About);
        LinearLayout Log = (LinearLayout) navigationView.findViewById(R.id.Log);


        Picasso.with(getApplicationContext())
                .load("http://www.mx7.com/i/9e5/TRzJwU.png")
                .transform(new RoundedTransformation(100, 4))
                .into(user_image);
        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawers();
            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawers();
            }
        });
        vdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), CourseActivity.class);
                startActivity(i);
            }
        });
        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //                        IsmartApp.getInstance().logout(getApplicationContext());
//                IsmartApp.getInstance().getPrefManagerPaty().clear();
//                IsmartApp.getInstance().getPrefManagerPaty().commit();
//                Intent intenLogout = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intenLogout);
                drawerLayout.closeDrawers();
            }
        });
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


    @Override
    protected void onResume() {
        super.onResume();
        ActivityResultBus.getInstance().register(this);
        ApiBus.getInstance().register(this);

    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
        ActivityResultBus.getInstance().unregister(this);
        ApiBus.getInstance().unregister(this);
    }


    @Subscribe
    public void GetFeed(final FeedReceivedEvent event) {
        if (event != null) {
            progressBar2.setVisibility(View.GONE);
            list.add(event.getPost());
            for (int i = 0; i < event.getPost().getPost().size(); i++) {
                Log.e("sssss", event.getPost().getPost().get(i).getFile_img());
            }

            myRecyclerAdapter = new MyRecyclerAdapter(getApplicationContext(), list);
            recList.setAdapter(myRecyclerAdapter);

            myRecyclerAdapter.SetOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                }
            });

            myRecyclerAdapter.SetOnItemClickListenerShare(new MyRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    String image = list.get(position).getPost().get(position).getFile_img();
                    String title = list.get(position).getPost().get(position).getTitle();
                    String link = list.get(position).getPost().get(position).getLink();
                    Uri myUri = Uri.parse(image);

//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_TEXT, title);
//                    shareIntent.putExtra(Intent.EXTRA_TEXT, link);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM, myUri);
//                    shareIntent.setType("image/*");
//                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    startActivity(Intent.createChooser(shareIntent, "Share images..."));

                    Intent share = new Intent(android.content.Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    share.putExtra(Intent.EXTRA_SUBJECT, "ข่าวสารจาก Maintenance Community");
                    share.putExtra(Intent.EXTRA_TEXT, link);

                    startActivity(Intent.createChooser(share, "Share link!"));
                }
            });

            myRecyclerAdapter.SetOnItemClickListenerRead(new MyRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                }
            });
        }

    }

    @Subscribe
    public void GetPhoto(final PhotoReceivedEvent event) {
        if (event != null) {

            photo1 = event.getPost().getPost().get(0).getFile_img();
//            photo2 = event.getPost().getPost().get(1).getFile_img();
//            photo3 = event.getPost().getPost().get(2).getFile_img();
            Picasso.with(getApplicationContext())
                    .load(photo1)
                    .into(image_view);


        }

    }
}

