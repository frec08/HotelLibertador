package empresa.android.apphotel.adaptador

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.R

class VistaRecepcionista (itemView: View):RecyclerView.ViewHolder(itemView) {
    var tvCodigoRecep: TextView
    var tvNombreRecep: TextView
    var tvApellidoRecep: TextView
    var tvDniRecep: TextView
    var tvTelefonoRecep: TextView
    var tvPosicionRecep: TextView

    init {
        //referencia
        tvCodigoRecep=itemView.findViewById(R.id.tvCodigoRecepI)
        tvNombreRecep=itemView.findViewById(R.id.tvNombreRecepI)
        tvApellidoRecep=itemView.findViewById(R.id.tvApellidoRecepI)
        tvDniRecep=itemView.findViewById(R.id.tvDniRecepI)
        tvTelefonoRecep=itemView.findViewById(R.id.tvTelefonoRecepI)
        tvPosicionRecep=itemView.findViewById(R.id.tvPosicionRecepI)
    }
}