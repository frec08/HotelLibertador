package empresa.android.apphotel.adaptador

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.R

class VistaRecepArch (itemView: View):RecyclerView.ViewHolder(itemView){
    var tvCodigoRecepArch: TextView
    var tvNombreRecepArch: TextView
    var tvApellidoRecepArch: TextView
    var tvDniRecepArch: TextView
    var tvTelefonoRecepArch: TextView
    var tvPosicionRecepArch: TextView

    init {
        //referencia
        tvCodigoRecepArch=itemView.findViewById(R.id.tvCodigoRecepArchI)
        tvNombreRecepArch=itemView.findViewById(R.id.tvNombreRecepArchI)
        tvApellidoRecepArch=itemView.findViewById(R.id.tvApellidoRecepArchI)
        tvDniRecepArch=itemView.findViewById(R.id.tvDniRecepArchI)
        tvTelefonoRecepArch=itemView.findViewById(R.id.tvTelefonoRecepArchI)
        tvPosicionRecepArch=itemView.findViewById(R.id.tvPosicionRecepArchI)
    }
}