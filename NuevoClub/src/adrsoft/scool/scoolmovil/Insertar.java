package adrsoft.scool.scoolmovil;

import com.example.nuevoclub.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Insertar extends Activity {
	
	EditText nombre,apellidos,rango;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar);
		b1 = (Button)findViewById(R.id.button1);
		nombre = (EditText)findViewById(R.id.editText1);
		apellidos = (EditText)findViewById(R.id.editText2);
		rango = (EditText)findViewById(R.id.editText3);		
		b1 = (Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Grabar();
				Intent data=new Intent();
				setResult(RESULT_OK,data);
				finish();
				
			}
		});
	}
	

	protected void Grabar() {
   	
       SQLiteHelper base=new SQLiteHelper(this, "club.db", null, 1);
       SQLiteDatabase db = base.getWritableDatabase();
       //
       String nom=nombre.getText().toString();
       String ape=apellidos.getText().toString();
       String rank= rango.getText().toString();
     
     
       if(nom.equals("")|| ape.equals("")){
       	Toast.makeText(getBaseContext(),"faltan de llenar campos", 1).show();
       }
       else{
       	String sentencia="INSERT INTO miembros (nombre,apellidos,rango)"+
           "VALUES('"+nom+"','"+ape+"','"+rank+"')";
       	if(db!=null){
       		db.execSQL(sentencia);
       		Toast.makeText(getBaseContext(), "se ha grabado "+nom, 1).show();
       	}
       }
       db.close();
       
		
	}



}
