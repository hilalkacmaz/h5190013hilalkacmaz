package com.h5190013.hilal_kacmaz_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190013.hilal_kacmaz_final.util.GlideUtil;
import com.h5190013.hilal_kacmaz_final.model.PhotographyModel;
import com.h5190013.hilal_kacmaz_final.R;

import java.util.List;

public class PhotographyAdaptor extends RecyclerView.Adapter<PhotographyViewHolder> {

    List<PhotographyModel> photographys;
    Context context;
    OnItemClickListener listener;
    public interface OnItemClickListener {
        void onClik(int position);
    }
    public PhotographyAdaptor(List<PhotographyModel> photographys, Context context, OnItemClickListener listener) {
        this.photographys = photographys;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public PhotographyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_photography,parent,false);
        return new PhotographyViewHolder(itemView,listener);
    }
    @Override
    public void onBindViewHolder(@NonNull PhotographyViewHolder viewHolder, int position) {
        viewHolder.txtPhotographyName.setText(photographys.get(position).getAdi());
        viewHolder.txtKullanilabilenLensler.setText(photographys.get(position).getKullanLabilenLensler());
        viewHolder.txtTurunEnIyiFotografcilari.setText(photographys.get(position).getTurunEnIyFotografcilari());
        GlideUtil.imageDownload(context,photographys.get(position).getLogoUrl(),viewHolder.imgPhotography);
    }
    @Override
    public int getItemCount() {
        return photographys.size();
    }
}