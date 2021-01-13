package com.h5190013.hilal_kacmaz_final.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.h5190013.hilal_kacmaz_final.R;

public class AlertDialogUtil {
    public static void alertDialog(Context context, String titleInfo, String messageInfo, String possitiveButtonInfo, String negativeButtonInfo , String screenInfo)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(titleInfo);
        builder.setMessage(messageInfo);
        builder.setPositiveButton(possitiveButtonInfo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(screenInfo.toString() == context.getResources().getString(R.string.mainActivityScreen)){
                    context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                }
                else{
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(negativeButtonInfo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(screenInfo.toString() == context.getResources().getString(R.string.mainActivityScreen)){
                    ((Activity)context).finish();
                }
                else{
                    window.dismiss();
                }

            }
        });
        builder.show();
    }
}
