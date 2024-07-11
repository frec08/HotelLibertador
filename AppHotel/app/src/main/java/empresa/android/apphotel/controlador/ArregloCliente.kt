package empresa.android.apphotel.controlador

import android.content.ContentValues
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.utils.appConfig

class ArregloCliente {
    fun listado():ArrayList<Cliente>{
        var lista=ArrayList<Cliente>()
        //acceder a la base de datos en modo lectura
        var cn=appConfig.BD.readableDatabase
        //sentencia sql
        var rs=cn.rawQuery("select *from tb_cliente",null)
        //bucle
        while (rs.moveToNext()){
            var bean=Cliente(rs.getInt(0),rs.getString(1),rs.getString(2),
                rs.getInt(3),rs.getInt(4))
            lista.add(bean)
        }

        return lista
    }

    fun saveCliente(bean:Cliente){
        //acceder a la base datos en modo escritura
        var CN=appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        var row= ContentValues()
        //crear claves "mismo nombre de los campos de la tabla cliente"
        row.put("nom",bean.nombre)
        row.put("ape",bean.apellido)
        row.put("dni",bean.dni)
        row.put("telefono",bean.telefono)
        CN.insert("tb_cliente","cod",row)
    }
    fun updateCliente(bean:Cliente){
        //acceder a la base datos en modo escritura
        var CN=appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        var row= ContentValues()
        //crear claves "mismo nombre de los campos de la tabla cliente"
        row.put("nom",bean.nombre)
        row.put("ape",bean.apellido)
        row.put("dni",bean.dni)
        row.put("telefono",bean.telefono)
        CN.update("tb_cliente",row,"cod=?", arrayOf(""+bean.codigo))
    }
    fun deleteCliente(cod:Int){
        //acceder a la base datos en modo escritura
        var CN=appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        CN.delete("tb_cliente","cod=?", arrayOf(""+cod))
    }

}