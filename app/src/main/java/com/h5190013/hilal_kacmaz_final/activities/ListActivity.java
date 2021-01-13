package com.h5190013.hilal_kacmaz_final.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190013.hilal_kacmaz_final.util.AlertDialogUtil;
import com.h5190013.hilal_kacmaz_final.util.Constants;
import com.h5190013.hilal_kacmaz_final.util.ObjectUtil;
import com.h5190013.hilal_kacmaz_final.adaptor.PhotographyAdaptor;
import com.h5190013.hilal_kacmaz_final.model.PhotographyModel;
import com.h5190013.hilal_kacmaz_final.R;
import com.h5190013.hilal_kacmaz_final.network.Service;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ListActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();

    }

    private  void  init()
    {
        getPhotography();
        progress();
    }

    public void progress(){
        progressDialog = new ProgressDialog(ListActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.wait));
        progressDialog.show();
    }

    void  getPhotography()
    {

        new Service().getServiceApi().getPhotography().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PhotographyModel>>() {

                    List<PhotographyModel> photographys=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<PhotographyModel> photographyList) {
                        Log.e("RETROFIT","onNext : ");
                        photographys=photographyList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        initRecycleView(photographys);
                        if(photographys.size()>0) {
                            progressDialog.dismiss();
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        AlertDialogUtil.alertDialog(ListActivity.this,getResources().getString(R.string.exit),getResources().getString(R.string.want_to_quit),getResources().getString(R.string.yes),getResources().getString(R.string.no),getResources().getString(R.string.listActivityScreen));
    }


    private  void  initRecycleView(List<PhotographyModel> photographyList)
    {
        recyclerView =findViewById(R.id.rcvPhotographys);
        PhotographyAdaptor photographyAdaptor =new PhotographyAdaptor(photographyList, getApplicationContext(), new PhotographyAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                PhotographyModel clickedPhotography =photographyList.get(position);
                opennextActivity(clickedPhotography);

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(photographyAdaptor);
    }
    private void opennextActivity(PhotographyModel clickedPhotography){
        Intent photographyDetailActivity=new Intent(getApplicationContext(), PhotographyDetailActivity.class);
        String clickedPhotographyString= ObjectUtil.photographyToJsonString(clickedPhotography);
        photographyDetailActivity.putExtra(Constants.CLICKED_ITEM_NAME,clickedPhotographyString);
        startActivity(photographyDetailActivity);
    }

}