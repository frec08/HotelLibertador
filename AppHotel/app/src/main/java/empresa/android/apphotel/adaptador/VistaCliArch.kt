package empresa.android.apphotel.adaptador

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.R

class VistaCliArch (itemView: View): RecyclerView.ViewHolder(itemView){
    var tvCodigoArch: TextView
    var tvNombreArch: TextView
    var tvApellidoArch: TextView
    var tvDniArch: TextView
    var tvTelefonoArch: TextView

    init {
        //referencia
        tvCodigoArch=itemView.findViewById(R.id.tvCodigoArchI)
        tvNombreArch=itemView.findViewById(R.id.tvNombreArchI)
        tvApellidoArch=itemView.findViewById(R.id.tvApellidoArchI)
        tvDniArch=itemView.findViewById(R.id.tvDniArchI)
        tvTelefonoArch=itemView.findViewById(R.id.tvTelefonoArchI)
    }
}