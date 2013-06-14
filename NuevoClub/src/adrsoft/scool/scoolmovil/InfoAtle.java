package adrsoft.scool.scoolmovil;

import com.example.nuevoclub.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class InfoAtle extends Activity {

	Button b1,b2,b3,b4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_atle);
		b1 = (Button)findViewById(R.id.Button03);
		b2 = (Button)findViewById(R.id.Button02);
		b3 = (Button)findViewById(R.id.Button01);
		b4 = (Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String link = "http://es.wikipedia.org/wiki/Atletismo#Velocidad";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String link = "http://es.wikipedia.org/wiki/Atletismo#Carreras_en_ruta";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
			}
		});
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String link = "http://es.wikipedia.org/wiki/Atletismo#Saltos_de_vallas";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
			}
		});
		b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String link = "http://es.wikipedia.org/wiki/Atletismo#Carreras_de_fondo_y_de_media_distancia";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
			}
		});
	}


}
