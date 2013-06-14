package adrsoft.scool.scoolmovil;

import com.example.nuevoclub.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ajedrez extends Activity {

	Button b,b2,b3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajedrez);
		MediaPlayer mp = MediaPlayer.create(this, R.raw.aje);
		
		b=(Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.button2);
		b3 = (Button)findViewById(R.id.button3);
		mp.start();
		
	b.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getBaseContext(),Miembros.class);
			startActivity(i);
		}
	});
		
	b2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i2 = new Intent(getBaseContext(),JuegoAjedrez.class);
			startActivity(i2);
		}
	});
	
	b3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i3 = new Intent(getBaseContext(),Multimedia.class);
			startActivity(i3);
		}
	});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ajedrez, menu);
		return true;
	}

}
