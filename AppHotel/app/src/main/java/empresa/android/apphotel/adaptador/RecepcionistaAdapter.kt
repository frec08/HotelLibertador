package empresa.android.apphotel.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.DatosActivity
import empresa.android.apphotel.DatosRecepActivity
import empresa.android.apphotel.R
import empresa.android.apphotel.entidad.Recepcionista
import empresa.android.apphotel.utils.appConfig

class RecepcionistaAdapter(val info:ArrayList<Recepcionista>)
    :RecyclerView.Adapter<VistaRecepcionista>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaRecepcionista {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_recepcionista,parent,false)
        return VistaRecepcionista(vista)
    }

    override fun getItemCount(): Int {
        return info.size
    }

    override fun onBindViewHolder(holder: VistaRecepcionista, position: Int) {
        holder.tvCodigoRecep.text=info.get(position).codigoRecep.toString()
        holder.tvNombreRecep.text=info.get(position).nombreRecep
        holder.tvApellidoRecep.text=info.get(position).apellidoRecep
        holder.tvDniRecep.text=info.get(position).dniRecep.toString()
        holder.tvTelefonoRecep.text=info.get(position).telefonoRecep.toString()
        holder.tvPosicionRecep.text=info.get(position).posicionRecep

        //evento clic a holder
        holder.itemView.setOnClickListener {
            var pantalla= Intent(appConfig.CONTEXT, DatosRecepActivity::class.java)
            //enviar clave dentro de panllata con el valor del recepcionista actual
            pantalla.putExtra("data",info.get(position))
            pantalla.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(appConfig.CONTEXT, pantalla,null)
        }
    }


}