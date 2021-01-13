package com.h5190013.hilal_kacmaz_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190013.hilal_kacmaz_final.util.Constants;
import com.h5190013.hilal_kacmaz_final.util.GlideUtil;
import com.h5190013.hilal_kacmaz_final.util.ObjectUtil;
import com.h5190013.hilal_kacmaz_final.model.PhotographyModel;
import com.h5190013.hilal_kacmaz_final.R;


public class PhotographyDetailActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtHeader;
    TextView txtDetail;
    TextView txtFirst;
    TextView txtSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photography_detail);
        init();

    }
    private void init(){

        String carriedOverPhotographyString=getIntent().getStringExtra(Constants.CLICKED_ITEM_NAME);
        PhotographyModel photographyModel= ObjectUtil.jsonStringToPhotography(carriedOverPhotographyString);

        imgKapak=findViewById(R.id.imgKapak);
        txtHeader=findViewById(R.id.txtHeader);
        txtDetail=findViewById(R.id.txtDetail);
        txtFirst=findViewById(R.id.txtFirst);
        txtSecond=findViewById(R.id.txtSecond);

        txtHeader.setText((photographyModel.getAdi()));
        txtFirst.setText(photographyModel.getKullanLabilenLensler());
        txtSecond.setText(photographyModel.getTurunEnIyFotografcilari());

        String aciklama = photographyModel.getAciklama();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtDetail.setText(Html.fromHtml(aciklama, Html.FROM_HTML_MODE_LEGACY));
        } else{
            txtDetail.setText(Html.fromHtml(aciklama));
        }

        GlideUtil.imageDownload(getApplicationContext(),photographyModel.getKapakFotoUrl(),imgKapak);


    }
}