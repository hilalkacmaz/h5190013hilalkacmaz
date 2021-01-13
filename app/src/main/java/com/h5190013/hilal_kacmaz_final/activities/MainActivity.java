package com.h5190013.hilal_kacmaz_final.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190013.hilal_kacmaz_final.R;
import com.h5190013.hilal_kacmaz_final.network.Network;
import com.h5190013.hilal_kacmaz_final.util.AlertDialogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeShift();
    }

    public void alertDialog(){
        AlertDialogUtil.alertDialog(MainActivity.this,getResources().getString(R.string.attention),getResources().getString(R.string.internet_problem),getResources().getString(R.string.go_to_settings),getResources().getString(R.string.exit),getResources().getString(R.string.mainActivityScreen) );
    }

    public void timeShift() {
        CountDownTimer countDownTimer = new
                CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        if(Network.checkInternet(getApplicationContext())) {
                            Intent listActivity = new Intent(getApplicationContext(), ListActivity.class);
                            startActivity(listActivity);
                            finish();
                        }
                        else {
                            alertDialog();
                        }
                    }
                };
        countDownTimer.start();
    }
}