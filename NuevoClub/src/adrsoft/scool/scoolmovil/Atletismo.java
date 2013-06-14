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

public class Atletismo extends Activity {

	Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_atletismo);
		MediaPlayer mp = MediaPlayer.create(this, R.raw.chariotsoffire);
		mp.start();
		b2 = (Button)findViewById(R.id.button1);
		b1 = (Button)findViewById(R.id.button2);//m
		b3 = (Button)findViewById(R.id.button4);
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1= new Intent(getBaseContext(),JuegoAtletismo.class);
				startActivity(i1);
			}
		});
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2= new Intent(getBaseContext(),MiembrosAtle.class);
				startActivity(i2);
				
			}
		});
		
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i3= new Intent(getBaseContext(),InfoAtle.class);
				startActivity(i3);
				
			}
		});
		
		
		
	}

	

}
