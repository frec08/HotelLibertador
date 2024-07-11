package empresa.android.apphotel.entidad

import java.io.Serializable

class Recepcionista(var codigoRecep: Int,
                    var nombreRecep: String,
                    var apellidoRecep: String,
                    var dniRecep: Int,
                    var telefonoRecep: Int,
                    var posicionRecep: String):Serializable {
}