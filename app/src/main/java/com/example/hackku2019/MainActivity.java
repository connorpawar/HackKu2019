package com.example.hackku2019;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
         {
    private SwipeRefreshLayout mSwipeLayout;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listview);


        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        Button btn5 = (Button)findViewById(R.id.button5);
        Button btn6 = (Button)findViewById(R.id.button6);
        Button btn7 = (Button)findViewById(R.id.button7);
        Button btn8 = (Button)findViewById(R.id.button8);
        Button btn9 = (Button)findViewById(R.id.button9);
        Button btn10 = (Button)findViewById(R.id.button10);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                //intent.putExtra("position", position);
                startActivity(intent);
//your stuff here.
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                writeOnImage();


//your stuff here.
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//your stuff here.
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final RSSRead rSSRead = new RSSRead(this, listView);
        rSSRead.execute();




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            public void onItemClick(AdapterView parentView, View childView,
                                    int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(0)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(1)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(2)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(3)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(4)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(5)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(6)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 7){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(7)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 8){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(8)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
                if(position == 9){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rSSRead.gameLinks.get(9)));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }

        }
    });

    }

        public void writeOnImage() {
            Bitmap bitmap = BitmapFactory.decodeFile("res/drawable/backboard_new.jpg");
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setTextSize(10);
            int x = 50;
            int y = 50;
            canvas.drawText("Some Text here", x, y, paint);
        }


             @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
