package adrsoft.scool.scoolmovil;








import com.example.nuevoclub.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class JuegoAjedrez extends Activity {
	Canvas canvas;
	Dibuja lienzo;
	LinearLayout la;
	Bitmap bm;
	boolean pulsado=false;
	  int z=100,p=100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_juego_ajedrez);
		   la=(LinearLayout)findViewById(R.id.layoutjuego);
	        lienzo=new Dibuja(this);
	        la.addView(lienzo);
		
	}
	
	
	public class Dibuja extends View{

		Paint paint = new Paint();
		public Dibuja(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			bm=BitmapFactory.decodeResource(context.getResources(), R.drawable.rey);
			
	;
			
			
		}
		
		public void onDraw(Canvas canvas){
			int x=la.getWidth() / 6,y=la.getHeight() / 6;
			for(int j = 1;j<10;j++){
			 for(int i = 1;i<10;i++){
				 if(i%2==0 && j%2==0){
				
						Paint pincel=new Paint();
						pincel.setStrokeWidth(1);
						pincel.setColor(Color.WHITE);
						canvas.drawRect(x, y, x+50, y+50, pincel);
						x+=50;
				 }
				 else{
						Paint pincel=new Paint();
						pincel.setStrokeWidth(1);
						pincel.setColor(Color.BLACK);
						canvas.drawRect(x, y, x+50, y+50, pincel);
						x+=50;
				 }
			 }
			 
			 x=la.getWidth() / 6;
			 y+=50;
			}
			canvas.drawBitmap(bm, z, p, null);
	
	
			
			
			     
		    		}
		
		public boolean onTouchEvent(MotionEvent e){
		  
			switch(e.getAction()){
			case MotionEvent.ACTION_DOWN:
				if(e.getX()>z && e.getX()<(z+bm.getWidth()) 
				&& e.getY()>p && e.getY()<(p+bm.getHeight())){
				  pulsado=true;
				}
				break;
			case MotionEvent.ACTION_MOVE:
				//for
				if(pulsado){
					z=(int)e.getX()-bm.getWidth()/2;
					p=(int)e.getY()-bm.getHeight()/2;
				}
			    break;
			case MotionEvent.ACTION_UP:
				if(pulsado){
			      pulsado=false;
				}	    		
			   break;
			
			
			}
			 invalidate(); 
			
			
			return true;
		}
		    		
		        }

		
	


	}
