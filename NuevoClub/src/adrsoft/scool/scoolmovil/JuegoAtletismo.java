package adrsoft.scool.scoolmovil;

import com.example.nuevoclub.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class JuegoAtletismo extends Activity {

	Canvas canvas;
	LinearLayout la;
	Bitmap bm,bm2;
	Dibuja lienzo;
	Button b1,b2;
	int x,y=0,x2=200,y2=0;
	WindowManager wm;
	private Display display;
	private int alto;
	private int ancho;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_juego_atletismo);
		la = (LinearLayout)findViewById(R.id.layoutjuegoatletismo);
		lienzo = new Dibuja(this);
		la.addView(lienzo);
		MediaPlayer mp = MediaPlayer.create(this, R.raw.chariotsoffire);
		mp.start();
		b1 = (Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.button2);
		x=50;
		y=0;
		wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		display = wm.getDefaultDisplay();
		ancho = display.getWidth();
		alto = display.getHeight();
		Log.d("debug", String.valueOf(alto));
		Log.d("debug", String.valueOf(ancho));
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				y+=(int)Math.round(Math.random()*100);
				Log.d("debug", "Jugador 1 Y: " + y );
				chechCampeon();
				lienzo.invalidate();
			}
		});
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				y2+=(int)Math.round(Math.random()*100);
				Log.d("debug", "Jugador 2 Y: " + y2 );
				chechCampeon();
				lienzo.invalidate();
			}
		});
		
	}

	protected void chechCampeon() {
		if(y >= 875){
			Log.d("debug", "Campeon j1");
			AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		    //seleccionamos la cadena a mostrar
		    dialogBuilder.setMessage("CAMPEON: JUGADOR 1! Felicidades :)");
		    //elegimo un titulo y configuramos para que se pueda quitar
		    dialogBuilder.setCancelable(true).setTitle("FINAL DE LA CARRERA");
		    //mostramos el dialogBuilder
		    dialogBuilder.create().show();
		    b1.setEnabled(false);
		    b2.setEnabled(false);

		}
		if(y2 >= 875){
			Log.d("debug", "Campeon j2");
			AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		    //seleccionamos la cadena a mostrar
		    dialogBuilder.setMessage("CAMPEON: JUGADOR 1! Felicidades :)");
		    //elegimo un titulo y configuramos para que se pueda quitar
		    dialogBuilder.setCancelable(true).setTitle("FINAL DE LA CARRERA");
		    //mostramos el dialogBuilder
		    dialogBuilder.create().show();
		    b1.setEnabled(false);
		    b2.setEnabled(false);
		}
		
	}

	public class Dibuja extends View{

		public Dibuja(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			bm=BitmapFactory.decodeResource(context.getResources(), R.drawable.corredor1);
			bm2=BitmapFactory.decodeResource(context.getResources(), R.drawable.corredor1);
		}
		
		public void onDraw(Canvas canvas){
			Paint pincel1 = new Paint();
			pincel1.setStrokeWidth(30);
			pincel1.setARGB(255, 255, 0, 0);
		    canvas.drawBitmap(bm, x,y,pincel1);
		    
		    Paint pincel2 = new Paint();
			pincel2.setStrokeWidth(30);
			pincel2.setARGB(255, 255, 0, 0);
		    canvas.drawBitmap(bm, x2,y2,pincel2);
		}
		
		
	}

}
