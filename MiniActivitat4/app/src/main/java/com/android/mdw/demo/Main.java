package com.android.mdw.demo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
  ElReceptor receiver;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
    receiver = new ElReceptor();
    this.registerReceiver(receiver, filter);

    Button btnInicio = findViewById(R.id.btnInicio);
    Button btnCancion = findViewById(R.id.btnCancion);
    Button btnFin = findViewById(R.id.btnFin);
    Button audioSelec = findViewById(R.id.button1);
    Button uriSelec = findViewById(R.id.button2);

    btnInicio.setOnClickListener(this);
    btnCancion.setOnClickListener(this);
    btnFin.setOnClickListener(this);
    audioSelec.setOnClickListener(this);
    uriSelec.setOnClickListener(this);

    if (Build.VERSION.SDK_INT >= 23)
      if (! ckeckPermissions())
        requestPermissions();
  }

  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    //APARTADO D
    if (resultCode == RESULT_OK){
      if (requestCode == 0){
          Uri uri = data.getData();
          Intent in = new Intent(this, ElServicio.class);
          in.setData(uri);
          in.putExtra(getString(R.string.mess), getString(R.string.messAudio));
          startService(in);
      }
    }
  }

  public void onClick(View src) {
    Intent in;

    // APARTADO A
    switch (src.getId()) {
    case R.id.btnInicio:
      Toast.makeText(this, R.string.select, Toast.LENGTH_LONG).show();
      in = new Intent(this, ElServicio.class);
      in.putExtra(getString(R.string.mess), getString(R.string.selectSonido));
      startService(in);
      break;

      //APARTADO B
//      Toast.makeText(this, R.string.select, Toast.LENGTH_LONG).show();
//      in = new Intent(this, ElReceptor.class);
//      in.putExtra(getString(R.string.mess), getString(R.string.selectSonido));
//      sendBroadcast(in);
//      break;

    case R.id.btnCancion:
      Toast.makeText(this, R.string.select2, Toast.LENGTH_LONG).show();
      in = new Intent(this, ElServicio.class);
      in.putExtra(getString(R.string.mess), getString(R.string.selectCancion));
      startService(in);
      break;

      //APARTADO B
//      Toast.makeText(this, R.string.select2, Toast.LENGTH_LONG).show();
//      in = new Intent(this, ElReceptor.class);
//      in.putExtra(getString(R.string.mess), getString(R.string.selectCancion));
//      sendBroadcast(in);
//      break;

    case R.id.btnFin:
      Toast.makeText(this, R.string.select3, Toast.LENGTH_LONG).show();
      stopService(new Intent(this, ElServicio.class));
      break;

      //APARTADO B
//      Toast.makeText(this, R.string.select3, Toast.LENGTH_LONG).show();
//      in = new Intent(this, ElReceptor.class);
//      in.putExtra(getString(R.string.mess), getString(R.string.selectDetencion));
//      sendBroadcast(in);
//      break;

    // OPTATIVO D
    case R.id.button1:
      in = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
      startActivityForResult(in, 0);
      break;

    // OPTATIVO E
    case R.id.button2:
      in = new Intent(this, ElServicio.class);
      in.setData(Uri.parse("content://media/external/audio/media/70"));
      in.putExtra(getString(R.string.mess), getString(R.string.messAudio));
      startService(in);
      break;

    }

  }

  private boolean ckeckPermissions() {
    if (Build.VERSION.SDK_INT >= 23) {
      if (ActivityCompat.checkSelfPermission(getApplicationContext(),
              Manifest.permission.READ_EXTERNAL_STORAGE) ==
              PackageManager.PERMISSION_GRANTED)
        return true;
      else
        return false;
    }
    else
      return true;
  }

  private void requestPermissions() {
    ActivityCompat.requestPermissions(Main.this,
            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
            0);
  }
}