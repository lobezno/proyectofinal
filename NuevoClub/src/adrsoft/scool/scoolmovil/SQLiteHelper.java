package adrsoft.scool.scoolmovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
	
	static String createBDSQL = "CREATE TABLE centros (_id integer primary key autoincrement,  nombre TEXT, provincia TEXT, ciudad  TEXT)";
	static String createBDSQL2 = "CREATE TABLE clubs (_id integer primary key autoincrement,  nombre TEXT, actividad TEXT, miembros  TEXT)";
	static String createMiembros = "CREATE TABLE miembros (_id integer primary key autoincrement,  nombre TEXT, apellidos TEXT, rango  INTEGER)";

	public SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		 db.execSQL(createBDSQL);
		 db.execSQL(createBDSQL2);
		 db.execSQL(createMiembros);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS centros");
		db.execSQL(createBDSQL);
		db.execSQL("DROP TABLE IF EXISTS clubs");
		db.execSQL(createBDSQL2);
		db.execSQL("DROP TABLE IF EXISTS miembros");
		db.execSQL(createMiembros);
	}

}
