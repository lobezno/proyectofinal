package adrsoft.scool.scoolmovil;

import com.example.nuevoclub.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Multimedia extends Activity {

	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multimedia);
		b1 = (Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String link = "http://es.wikipedia.org/wiki/Ajedrez";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_multimedia, menu);
		return true;
	}

}
