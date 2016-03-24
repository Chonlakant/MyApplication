package ismart.ipro.com.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import ismart.ipro.com.myapplication.R;
import ismart.ipro.com.myapplication.adapter.CourseListviewAdapter;
import ismart.ipro.com.myapplication.event.ActivityResultBus;
import ismart.ipro.com.myapplication.event.ApiBus;


public class CourseActivity extends AppCompatActivity {
    ProgressBar progressBar4;
    ListView listView;
    CourseListviewAdapter courseListviewAdapter;
    private Toolbar toolbar;
    String[] str = {"การสื่อสารเบื้องต้น ตอนที่ 1", "การสื่อสารเบื้องต้น ตอนที่ 2", "ภาวะความเป็นผู้นำ ตอนที่ 1", "ภาวะความเป็นผู้นำ ตอนที่ 2"
            , "ความปลอดภัยในที่ทำงาน ตอนที่ 1", "ความปลอดภัยในที่ทำงาน ตอนที่ 2"};
int[] res = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3,R.drawable.slide4,R.drawable.slide5,R.drawable.slide6};
    String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_course);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar4.setVisibility(View.GONE);
        listView = (ListView) findViewById(R.id.listView);
//        cat = getIntent().getStringExtra("cat");
//        if (cat.equals("2")) {
//            ApiBus.getInstance().postQueue(new TraingRequestedEvent("dd"));
//        }


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("สื่อการสอนอนนไลน์");
            toolbar.setTitleTextColor(Color.BLACK);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }
        courseListviewAdapter = new CourseListviewAdapter(getApplicationContext(), str,res);
        listView.setAdapter(courseListviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(getApplicationContext(), DetailCourseActivity.class);
                    i.putExtra("key","http://mn-community.com/video/Communication1rev1.mp4");
                    i.putExtra("title",str[0]);
                    startActivity(i);
                }
                if (position == 1) {
                    Intent i = new Intent(getApplicationContext(), DetailCourseActivity.class);
                    i.putExtra("key","http://mn-community.com/video/Communication2.mp4");
                    i.putExtra("title",str[1]);
                    startActivity(i);
                }
                if (position == 2) {
                    Intent i = new Intent(getApplicationContext(), DetailCourseActivity.class);
                    i.putExtra("key","http://mn-community.com/video/Leadership1.mp4");
                    i.putExtra("title",str[2]);
                    startActivity(i);
                }
                if (position == 3) {
                    Intent i = new Intent(getApplicationContext(), DetailCourseActivity.class);
                    i.putExtra("key","http://mn-community.com/video/leadership2.mp4");
                    i.putExtra("title",str[3]);
                    startActivity(i);
                }
                if (position == 4) {
                    Intent i = new Intent(getApplicationContext(), DetailCourseActivity.class);
                    i.putExtra("key","http://mn-community.com/video/safetyinworkplace1.mp4");
                    i.putExtra("title",str[4]);
                    startActivity(i);
                }
                if (position == 5) {
                    Intent i = new Intent(getApplicationContext(), DetailCourseActivity.class);
                    i.putExtra("key","http://mn-community.com/video/safetyinworkplace2.mp4");
                    i.putExtra("title",str[5]);
                    startActivity(i);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityResultBus.getInstance().register(this);
        ApiBus.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityResultBus.getInstance().unregister(this);
        ApiBus.getInstance().unregister(this);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
