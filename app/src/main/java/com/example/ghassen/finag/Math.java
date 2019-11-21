package com.example.ghassen.finag;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ghassen.finag.Entities.User;

public class Math extends AppCompatActivity {
    public static final int REQUEST_CODE = 10 ;
    ImageView image1,image2,image3,image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        final Bundle extras = getIntent().getExtras();
        assert extras != null;
        image1 = findViewById(R.id.im1);
        image2 = findViewById(R.id.im2);
        image3 = findViewById(R.id.im3);
        image4 = findViewById(R.id.im4);

        image1.setVisibility(View.INVISIBLE);
        final Button niveau1 = findViewById(R.id.Niveau1);
        Button niveau2 = findViewById(R.id.Niveau2);
        Button niveau3 = findViewById(R.id.Niveau3);
        Button niveau4 = findViewById(R.id.Niveau4);

        if(User.scoremath >=30)
        {
            image2.setVisibility(View.INVISIBLE);
        }
        if (User.scoremath >=60)
        {
            image3.setVisibility(View.INVISIBLE);
        }
        if(User.scoremath >= 90)
        {
            image4.setVisibility(View.INVISIBLE);
        }

        niveau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quizn = new Intent(Math.this, MathNiveau.class);
                quizn.putExtra("niveau","Niveau1");
                quizn.putExtra("catt","Math");
                startActivityForResult(quizn,REQUEST_CODE);

            }
        });
        niveau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(User.scoremath>=30)
                {
                    Intent quizn = new Intent(Math.this, MathNiveau.class);
                    quizn.putExtra("niveau","Niveau2");
                    quizn.putExtra("catt","Math");
                    startActivityForResult(quizn,REQUEST_CODE);
                }
            }
        });
        niveau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(User.scoremath>=60)
                {
                    Intent quizn = new Intent(Math.this,MathNiveau.class);
                    quizn.putExtra("niveau","Niveau3");
                    quizn.putExtra("catt","Math");
                    startActivityForResult(quizn,REQUEST_CODE);
                }


            }
        });
        niveau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.scoremath>=90)
                {
                    Intent quizn = new Intent(Math.this,MathNiveau.class);
                    quizn.putExtra("niveau","Niveau4");
                    quizn.putExtra("catt","Math");
                    startActivityForResult(quizn,REQUEST_CODE);
                }

            }
        });
    }

}
