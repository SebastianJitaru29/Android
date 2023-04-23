package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer player;
	private MediaPlayer player1;
	private MediaPlayer player2; // OPTATIVO D

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show();		
		player = MediaPlayer.create(this, R.raw.train);
		player1 = MediaPlayer.create(this, R.raw.bob_marley_cybl);
		player.setLooping(true);
		player1.setLooping(true);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show();
		player.stop();
		player1.stop();
		try{
			player2.stop();
		} catch (Exception e){}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show();

		Bundle data = intent.getExtras();
		String so = data.getString(getString(R.string.mess));

		if (so.equals(getString(R.string.selectSonido))) {
			player.start();
		} else if (so.equals(getString(R.string.selectCancion))) {
			player1.start();


		} else if (so.equals(getString(R.string.messAudio))){
			// OPTATIVO D i E
			Toast.makeText(this, R.string.iniserv3, Toast.LENGTH_LONG).show();

			try{
				if(player2.isPlaying()) {
					player2.stop();
				}
			} catch (Exception e){}

			Uri audio = intent.getData();
			player2 = MediaPlayer.create(this, audio);
			player2.setLooping(true);
			player2.start();
		}
		return startid;
	}	

}
