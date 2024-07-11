package empresa.android.apphotel.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.DatosActivity
import empresa.android.apphotel.DatosCliArchActivity
import empresa.android.apphotel.R
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.utils.appConfig

class CliArchAdapter (val info:ArrayList<Cliente>)
    :RecyclerView.Adapter<VistaCliArch>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCliArch {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_cli_arch,parent,false)
        return VistaCliArch(vista)
    }

    override fun onBindViewHolder(holder: VistaCliArch, position: Int) {
        holder.tvCodigoArch.text=info.get(position).codigo.toString()
        holder.tvNombreArch.text=info.get(position).nombre
        holder.tvApellidoArch.text=info.get(position).apellido
        holder.tvDniArch.text=info.get(position).dni.toString()
        holder.tvTelefonoArch.text=info.get(position).telefono.toString()

        //evento clic a holder
        holder.itemView.setOnClickListener {
            var pantalla= Intent(appConfig.CONTEXT, DatosCliArchActivity::class.java)
            //enviar clave dentro de panllata con el valor del cliente actual
            pantalla.putExtra("data",info.get(position))
            pantalla.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(appConfig.CONTEXT, pantalla,null)
        }
    }

    override fun getItemCount(): Int {
        return info.size
    }
}