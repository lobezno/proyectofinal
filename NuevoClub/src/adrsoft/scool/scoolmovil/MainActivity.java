package adrsoft.scool.scoolmovil;



import com.example.nuevoclub.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	Spinner sp1,sp2;
	SQLiteHelper sqlh;
	SQLiteDatabase db;
	Button entrar;
	Intent i1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sp1 = (Spinner) this.findViewById(R.id.spinner1);
		sp2 = (Spinner) this.findViewById(R.id.spinner2);
		entrar = (Button) this.findViewById(R.id.button1);
		
		sqlh = new SQLiteHelper(this, "club.db", null, 1);
		db = sqlh.getWritableDatabase();
		db.execSQL("DELETE FROM centros");
		
		String []nombre={"IES Miguel Herrero","IES Zapaton","IES Augusto G. Linares","IES Barajas"};
  		String []provincia={"Cantabria","Cantabria","Cantabria","Madrid"};
  		String []ciudad={"Torrelavega","Torrelavega","Santander","Madrid"};
  		
  		String []nombrec={"Jaque Mate","CorreCorre","ExtraLife","MundoLibro"};
  		String []actividad={"Ajedrez","Atletismo","Videojuegos","Lectura"};
  		String []miembros={"5","6","2","12"};
  		
  		
  		String []nombrem={"Adrian","Alejandro","David","Marcos"};
  		String []apellidosm={"Peña","Gomez","Martinez","Garcia"};
  		int []rango={1,2,3,4};
		
		String sentencia ="";
		for(int i=0;i<4;i++){
  			sentencia="INSERT INTO centros(nombre, provincia,ciudad)"+
  		      "VALUES('"+nombre[i]+"','"+provincia[i]+"','"+ciudad[i]+"')";
  			db.execSQL(sentencia);
  			
  			sentencia="INSERT INTO clubs(nombre, actividad, miembros)"+
  	  		      "VALUES('"+nombrec[i]+"','"+actividad[i]+"','"+miembros[i]+"')";
  			db.execSQL(sentencia);
  			
  			sentencia="INSERT INTO miembros(nombre, apellidos, rango)"+
    	  		      "VALUES('"+nombrem[i]+"','"+apellidosm[i]+"',"+rango[i]+")";
    			db.execSQL(sentencia);
  		}
		
		if(db != null)
  		{
  			
  			Cursor c = db.rawQuery(" SELECT _id, nombre FROM centros", null);
  			//hay que seleccionar obligatoriamente el _id y el campo que quieres ver en el spinner
  		
  			String[] from = new String[] { "nombre" };
  	        int[] to = new int[] { android.R.id.text1 };//este es un campo del sistema Android
  	       SimpleCursorAdapter mAdapter = 
  	    		 new SimpleCursorAdapter
  	    		 (this,android.R.layout.simple_spinner_item, c, from, to);
  	    		        mAdapter.setDropDownViewResource
  	    		 (android.R.layout.simple_spinner_dropdown_item);
  	    		        sp1.setAdapter(mAdapter);
  	    		        
  	    		   
  	    		       c = db.rawQuery(" SELECT _id, nombre FROM clubs", null);
  	      			
  	      		
  	      		
  	      	       
  	      	        mAdapter = 
  	      	    		 new SimpleCursorAdapter
  	      	    		 (this,android.R.layout.simple_spinner_item, c, from, to);
  	      	    		        mAdapter.setDropDownViewResource
  	      	    		 (android.R.layout.simple_spinner_dropdown_item);
  	      	    		        sp2.setAdapter(mAdapter);
  	      	    		        
  	    	  		
  	    		     
  		
  	    db.close();  		
  	
  		}
		{
	

			entrar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i1=new Intent(getBaseContext(), Ajedrez.class);
					Intent i2=new Intent(getBaseContext(), Atletismo.class);
					
					
					long selec=sp2.getSelectedItemId() ;
					 // Para ver que id tiene el seleccionado
					 //Toast.makeText(getBaseContext(), String.valueOf(selec) ,5).show();

				switch((int)selec){
				
				case 1:
					startActivity(i1);
					break;
				case 2:
					startActivity(i2);
					break;
				default:
					Toast.makeText(getBaseContext(), "Lo siento, pero por el momento solo están implementados los clubs 'Jaque Mate' y 'CorreCorre' :(", Toast.LENGTH_LONG).show();
					break;
				
				
					
				}
					 
			        
			        
					
				}
				
			

			
			});
			
		
		
		
	}


	}

}
