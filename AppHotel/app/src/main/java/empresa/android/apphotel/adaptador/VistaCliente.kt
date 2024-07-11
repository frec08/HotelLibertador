package empresa.android.apphotel.adaptador

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.R

class VistaCliente (itemView: View):RecyclerView.ViewHolder(itemView) {
    var tvCodigo:TextView
    var tvNombre:TextView
    var tvApellido:TextView
    var tvDni:TextView
    var tvTelefono:TextView

    init {
        //referencia
        tvCodigo=itemView.findViewById(R.id.tvCodigoI)
        tvNombre=itemView.findViewById(R.id.tvNombreI)
        tvApellido=itemView.findViewById(R.id.tvApellidoI)
        tvDni=itemView.findViewById(R.id.tvDniI)
        tvTelefono=itemView.findViewById(R.id.tvTelefonoI)
    }
}