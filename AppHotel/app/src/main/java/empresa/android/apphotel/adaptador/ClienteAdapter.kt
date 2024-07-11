package empresa.android.apphotel.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.DatosActivity
import empresa.android.apphotel.R
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.utils.appConfig

class ClienteAdapter (val info:ArrayList<Cliente>)
    :RecyclerView.Adapter<VistaCliente>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCliente {
        val vista=LayoutInflater.from(parent.context).inflate(R.layout.item_cliente,parent,false)
        return VistaCliente(vista)
    }

    override fun getItemCount(): Int {
        return info.size
    }

    override fun onBindViewHolder(holder: VistaCliente, position: Int) {
        holder.tvCodigo.text=info.get(position).codigo.toString()
        holder.tvNombre.text=info.get(position).nombre
        holder.tvApellido.text=info.get(position).apellido
        holder.tvDni.text=info.get(position).dni.toString()
        holder.tvTelefono.text=info.get(position).telefono.toString()

        //evento clic a holder
        holder.itemView.setOnClickListener {
            var pantalla=Intent(appConfig.CONTEXT,DatosActivity::class.java)
            //enviar clave dentro de panllata con el valor del cliente actual
            pantalla.putExtra("data",info.get(position))
            pantalla.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(appConfig.CONTEXT, pantalla,null)
        }

    }
}