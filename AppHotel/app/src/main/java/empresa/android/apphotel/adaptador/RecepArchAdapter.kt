package empresa.android.apphotel.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.DatosCliArchActivity
import empresa.android.apphotel.DatosRecepArchActivity
import empresa.android.apphotel.R
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.entidad.Recepcionista
import empresa.android.apphotel.utils.appConfig

class RecepArchAdapter (val info:ArrayList<Recepcionista>)
    : RecyclerView.Adapter<VistaRecepArch>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaRecepArch {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_recep_arch,parent,false)
        return VistaRecepArch(vista)
    }

    override fun getItemCount(): Int {
        return info.size
    }

    override fun onBindViewHolder(holder: VistaRecepArch, position: Int) {
        holder.tvCodigoRecepArch.text=info.get(position).codigoRecep.toString()
        holder.tvNombreRecepArch.text=info.get(position).nombreRecep
        holder.tvApellidoRecepArch.text=info.get(position).apellidoRecep
        holder.tvDniRecepArch.text=info.get(position).dniRecep.toString()
        holder.tvTelefonoRecepArch.text=info.get(position).telefonoRecep.toString()
        holder.tvPosicionRecepArch.text=info.get(position).posicionRecep

        //evento clic a holder
        holder.itemView.setOnClickListener {
            var pantalla= Intent(appConfig.CONTEXT, DatosRecepArchActivity::class.java)
            //enviar clave dentro de panllata con el valor del cliente actual
            pantalla.putExtra("data",info.get(position))
            pantalla.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(appConfig.CONTEXT, pantalla,null)
        }
    }

}