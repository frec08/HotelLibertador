package empresa.android.apphotel.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import empresa.android.apphotel.utils.appConfig

class InitBD:SQLiteOpenHelper(appConfig.CONTEXT,
                                appConfig.BD_NAME,null,
                                appConfig.VERSION){
    override fun onCreate(db: SQLiteDatabase) {
        // Creación de la tabla tb_cliente
        db.execSQL("create table tb_cliente("+
            "cod integer primary key autoincrement,"+
            "nom varchar(30),"+
            "ape varchar(30),"+
            "dni int,"+
            "telefono int)")
        db.execSQL("insert into tb_cliente values(null,'Antony','Lima',77777777,999999999)")

        // Creación de la tabla tb_recepcionista
        db.execSQL("create table tb_recepcionista("+
                "codRecep integer primary key autoincrement,"+
                "nomRecep varchar(30),"+
                "apeRecep varchar(30),"+
                "dniRecep int,"+
                "telefonoRecep int,"+
                "posicionRecep varchar(30))")
        db.execSQL("insert into tb_recepcionista values(null,'Juan','Perez',88888888,111111111,'loby')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}