package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ElReceptor extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, ElServicio.class);

        if (intent.getAction() == null) {
            //APARTADO B
            Bundle data = intent.getExtras();
            String so = data.getString(context.getString(R.string.mess));

            if (so.equals(context.getString(R.string.selectSonido))){
                Toast.makeText(context, R.string.BcasMessSo, Toast.LENGTH_LONG).show();
                context.startService(intent);
            } else if (so.equals(context.getString(R.string.selectCancion))) {
                Toast.makeText(context, R.string.BcasMessCan, Toast.LENGTH_LONG).show();
                context.startService(intent);
            } else if (so.equals(context.getString(R.string.selectDetencion))) {
                Toast.makeText(context, R.string.BcasMessDet, Toast.LENGTH_LONG).show();
                context.stopService(intent);
            }
        } else {
            //APARTADO C
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                if (intent.getIntExtra("state", 0) == 1){
                    Toast.makeText(context, R.string.BcasMessCan1, Toast.LENGTH_LONG).show();
                    intent.putExtra(context.getString(R.string.mess), context.getString(R.string.selectCancion));
                    context.startService(intent);
                } else {
                    Toast.makeText(context, R.string.BcasMessDet1, Toast.LENGTH_LONG).show();
                    context.stopService(intent);
                }
            }
        }



    }
}
