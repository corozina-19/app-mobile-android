package com.latam.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.latam.covid.ui.topics.ContagioFragment;
import com.latam.covid.ui.topics.EstadisticasFragment;
import com.latam.covid.ui.topics.NoticiasFalsasFragment;
import com.latam.covid.ui.topics.PrevencionFragment;
import com.latam.covid.ui.topics.SintomasFragment;

public class TopicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topics_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));


        Bundle b = getIntent().getExtras();
        int topic = b.getInt("TOPICS", 0);

        if (savedInstanceState == null) {

             if (topic == 1){
                 getSupportFragmentManager().beginTransaction()
                         .replace(R.id.container, SintomasFragment.newInstance())
                         .commitNow();

             }else if(topic == 2){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, ContagioFragment.newInstance())
                        .commitNow();
             } else if (topic == 3) {
                 getSupportFragmentManager().beginTransaction()
                         .replace(R.id.container, PrevencionFragment.newInstance())
                         .commitNow();
             }else if (topic == 4) {
                 getSupportFragmentManager().beginTransaction()
                         .replace(R.id.container, EstadisticasFragment.newInstance())
                         .commitNow();
             }else if (topic == 5){
                 getSupportFragmentManager().beginTransaction()
                         .replace(R.id.container, NoticiasFalsasFragment.newInstance())
                         .commitNow();
             }


        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
