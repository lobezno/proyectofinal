package adrsoft.scool.scoolmovil;

import java.util.ArrayList;

import com.example.nuevoclub.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Miembros extends Activity {
	ListView lista;
	public ArrayList <ficha> datos=new ArrayList();
	AdaptadorOpciones adaptador;
	SQLiteHelper base;
	AdapterView.AdapterContextMenuInfo info;
	SQLiteDatabase db;
	Button b1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_miembros);
		lista = (ListView)findViewById(R.id.listView1);
		adaptador = new AdaptadorOpciones(this);
		b1 = (Button)findViewById(R.id.button1);				
		lista.setAdapter(adaptador);
		registerForContextMenu(lista);
		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				Intent i=new Intent(view.getContext(), Perfil.class);
				startActivity(i);
			}
		});
		cargar();
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1 = new Intent(getBaseContext(),Insertar.class);
				startActivity(i1);
			}
		});
	}
	 public void onCreateContextMenu(ContextMenu menu, View v,
	 			ContextMenuInfo menuInfo)
	 	{
	 		super.onCreateContextMenu(menu, v, menuInfo);
	 		MenuInflater inflater = getMenuInflater();	
	 			 info =	(AdapterView.AdapterContextMenuInfo)menuInfo;
	 			menu.setHeaderTitle("Quiere borrar "+datos.get(info.position).getNombre());
	 			inflater.inflate(R.menu.contextual, menu);
	 		
	 	}

	private void cargar() {
		// TODO Auto-generated method stub
		base=new SQLiteHelper(this, "club.db", null, 1);
	     SQLiteDatabase db = base.getReadableDatabase();
	     
	     if (db!=null){
	    	 Cursor c=db.rawQuery("SELECT nombre, apellidos,rango FROM miembros", null);
	    	 if(c.moveToFirst()){
	    		 do{
	    			 datos.add(new ficha(c.getString(0),c.getString(1),c.getInt(2)));
	    			
	    		 }while(c.moveToNext());
	    	 }
	     }
	     db.close();   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_miembros, menu);
		return true;
	}
	
	class AdaptadorOpciones extends ArrayAdapter<ficha> {
		Activity contexto;
		// Contructor del adaptador usando el contexto de la aplicación actual
		AdaptadorOpciones(Activity contexto) {
			// Llamamos al constructor de la clase superior
			super(contexto, R.layout.ficha, datos);
			this.contexto = contexto;
		}
		// Método que dibuja la Vista de cada Opción
		// Se invoca cada vez que haya que mostrar un elemento de la lista.
		public View getView(int position, View convertView, ViewGroup parent)
		{
			// Vista que Android indica como reutilizable
			View item = convertView;
			// Esta variable se usa para almacenar un objeto dentro
			// de la Vista que dibuja la opción
			VistaTag vistaTag;
			// Si Android indica que no hay una Vista reutilizable para la opción,
			// la definimos, inflamos el diseño que se define en el fichero
			//  listitem_opcion.xml y establecemos su contenido
			if(item == null)
				{
				// Usamos un Inflater para inflar el diseño
				// Ahora tenemos una Vista que se asocia al elemento
				LayoutInflater inflater = contexto.getLayoutInflater();
				// Definimos en la vista de vuelta el tipo de diseño
				item = inflater.inflate(R.layout.ficha, null);
				// Definimos el objeto que vamos a almacenar en el nuevo elemento
				vistaTag = new VistaTag();
				// Obtenemos los punteros a las etiquetas recién infladas
				vistaTag.nombre = (TextView)item.findViewById(R.id.textView1);
				vistaTag.apellidos=(TextView)item.findViewById(R.id.textView2);
				// Guardamos el objeto en el elemento
				
				item.setTag(vistaTag);
				}
			else
				{
				// Si estamos reutilizando una Vista, recuperamos el objeto interno
				vistaTag = (VistaTag)item.getTag();
				}
				// Cargamos las opciones de la matriz de datos
			
			vistaTag.nombre.setText(datos.get(position).getNombre());
			vistaTag.apellidos.setText(datos.get(position).getApellidos());
			// Devolvemos la Vista (nueva o reutilizada) que dibuja la opción
			return(item);	}
	} // end class AdaptadorOpciones
	// Clase que se usa para almacenar las 2  etiquetas de tipo TextView de una opción
	static class VistaTag {
		TextView nombre;
		TextView apellidos;
	}
	
 public boolean onContextItemSelected(MenuItem item) {
     	 
         AdapterContextMenuInfo info =
             (AdapterContextMenuInfo) item.getMenuInfo();
      
         switch (item.getItemId()) {
             case R.id.Borrar:
             	PedirConfirmacion();
                 return true;
              
             default:
                 return super.onContextItemSelected(item);
         }
     }
     private void PedirConfirmacion(){
     	Builder ventana = new AlertDialog.Builder(this);
     	ventana.setIcon(android.R.drawable.ic_dialog_info);
     	ventana.setTitle("Confirmacion");
     	ventana.setMessage("Esta seguro de borrar");
     	ventana.setCancelable(false);
     	ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
 			
 			@Override
 			public void onClick(DialogInterface dialog, int which) {
 				Borrar();
 				
 			}
 		});
     	ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
 			
 			@Override
 			public void onClick(DialogInterface dialog, int which) {
 				// TODO Auto-generated method stub
 				Toast.makeText(getApplicationContext(), "has cancelado el borrado",Toast.LENGTH_SHORT).show();
 			}
 		});
     	ventana.show();
     }
     public void Borrar(){
     	String x=datos.get(info.position).getNombre();
     	base =
   				new SQLiteHelper(this, "club.db", null, 1);

   		db = base.getWritableDatabase();
   		if(db!=null){
   			String[] args = new String[]{x};
   			db.execSQL("DELETE FROM miembros WHERE nombre=?", args);
   			Toast.makeText(getBaseContext(),"se ha borrado "+x,1).show();
   			adaptador.clear();
   			cargarDatos();
    		adaptador.notifyDataSetChanged();
   		}
   		db.close();
   		
     	
     }

    private void cargarDatos() {
        SQLiteHelper base=new SQLiteHelper(this, "club.db", null, 1);
        SQLiteDatabase db = base.getReadableDatabase();
        if(db!=null){
        	Cursor c=db.rawQuery("SELECT nombre, apellidos,rango FROM miembros",null);
        	if(c.moveToFirst()){
        		do{
        			
        		datos.add(new ficha(c.getString(0),c.getString(1), R.drawable.caballo));	
        			
        		}while(c.moveToNext());       	
        	
              }
          else
        	Toast.makeText(getApplicationContext(), "no hay registros, pulse MENU para agregar", 1).show();
		
	     }
        db.close();
    }


}
