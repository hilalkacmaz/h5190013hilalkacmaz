package com.h5190013.hilal_kacmaz_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190013.hilal_kacmaz_final.R;

public class PhotographyViewHolder extends RecyclerView.ViewHolder {
    ImageView imgPhotography;
    TextView txtPhotographyName;
    TextView txtTurunEnIyiFotografcilari;
    TextView txtKullanilabilenLensler;
    public PhotographyViewHolder(@NonNull View cardView, PhotographyAdaptor.OnItemClickListener listener) {
        super(cardView);
        imgPhotography =cardView.findViewById(R.id.imgPhotography);
        txtPhotographyName =cardView.findViewById(R.id.txtPhotographyName);
        txtTurunEnIyiFotografcilari =cardView.findViewById(R.id.txtTurunEnIyiFotografcilari);
        txtKullanilabilenLensler =cardView.findViewById(R.id.txtKullanilabilenLensler);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}