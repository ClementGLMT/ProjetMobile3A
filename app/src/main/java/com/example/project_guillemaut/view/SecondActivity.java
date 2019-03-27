package com.example.project_guillemaut.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.project_guillemaut.R;
import com.example.project_guillemaut.model.Cat;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    private Cat catToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        catToShow = (Cat) getIntent().getSerializableExtra("Cat");

        TextView catage = findViewById(R.id.cat_age2);
        TextView catname = findViewById(R.id.cat_name2);
        TextView catmood = findViewById(R.id.cat_mood2);
        TextView catcoat = findViewById(R.id.cat_coat2);
        ImageView catface = findViewById(R.id.cat_face2);
        TextView catheight = findViewById(R.id.cat_height2);
        TextView catnum = findViewById(R.id.cat_num2);
        TextView catcolor = findViewById(R.id.cat_color);

        catage.setText(getResources().getString(R.string.age)+catToShow.getCatAge());
        catname.setText(catToShow.getCatName());
        catmood.setText(getResources().getString(R.string.caractere)+catToShow.getCatMood());
        catcoat.setText(getResources().getString(R.string.pelage)+catToShow.getCatCoat());
        Picasso.with(getApplicationContext()).load(catToShow.getCatPic()).into(catface);
        catheight.setText(getResources().getString(R.string.taille)+catToShow.getCatHeight()+getResources().getString(R.string.cm));
        catnum.setText(getResources().getString(R.string.tel)+catToShow.getCatNum());
        catcolor.setText(getResources().getString(R.string.couleur)+catToShow.getCatColor());
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateSlideRight(this); //fire the slide left animation
    }
}
