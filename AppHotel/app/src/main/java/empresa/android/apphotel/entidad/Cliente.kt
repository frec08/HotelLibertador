package empresa.android.apphotel.entidad

import java.io.Serializable


class Cliente (var codigo: Int,
               var nombre: String,
               var apellido: String,
               var dni: Int,
               var telefono: Int):Serializable {
}