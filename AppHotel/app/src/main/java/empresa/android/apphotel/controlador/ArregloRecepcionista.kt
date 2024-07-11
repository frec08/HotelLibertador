package empresa.android.apphotel.controlador

import android.content.ContentValues
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.entidad.Recepcionista
import empresa.android.apphotel.utils.appConfig

class ArregloRecepcionista {
    fun listadoRecep():ArrayList<Recepcionista>{
        var lista=ArrayList<Recepcionista>()
        //acceder a la base de datos en modo lectura
        var cn= appConfig.BD.readableDatabase
        //sentencia sql
        var rs=cn.rawQuery("select *from tb_recepcionista",null)
        //bucle
        while (rs.moveToNext()){
            var bean= Recepcionista(rs.getInt(0),rs.getString(1),rs.getString(2),
                rs.getInt(3),rs.getInt(4),rs.getString(5))
            lista.add(bean)
        }

        return lista
    }
    fun saveRecepcionista(bean:Recepcionista){
        //acceder a la base datos en modo escritura
        var CN=appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        var row= ContentValues()
        //crear claves "mismo nombre de los campos de la tabla recepcionista"
        row.put("nomRecep",bean.nombreRecep)
        row.put("apeRecep",bean.apellidoRecep)
        row.put("dniRecep",bean.dniRecep)
        row.put("telefonoRecep",bean.telefonoRecep)
        row.put("posicionRecep",bean.posicionRecep)
        CN.insert("tb_recepcionista","codRecep",row)
    }
    fun updateRecepcionista(bean:Recepcionista){
        //acceder a la base datos en modo escritura
        var CN=appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        var row= ContentValues()
        //crear claves "mismo nombre de los campos de la tabla recepcionista"
        row.put("nomRecep",bean.nombreRecep)
        row.put("apeRecep",bean.apellidoRecep)
        row.put("dniRecep",bean.dniRecep)
        row.put("telefonoRecep",bean.telefonoRecep)
        row.put("posicionRecep",bean.posicionRecep)
        CN.update("tb_recepcionista",row,"codRecep=?", arrayOf(""+bean.codigoRecep))
    }
    fun deleteRecepcionista(codRecep:Int){
        //acceder a la base datos en modo escritura
        var CN=appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        CN.delete("tb_recepcionista","codRecep=?", arrayOf(""+codRecep))
    }
}