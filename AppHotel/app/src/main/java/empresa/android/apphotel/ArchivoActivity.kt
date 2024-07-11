package empresa.android.apphotel

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.adaptador.CliArchAdapter
import empresa.android.apphotel.adaptador.ClienteAdapter
import empresa.android.apphotel.controlador.ArregloCliente
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.utils.appConfig
import java.io.BufferedReader
import java.io.InputStreamReader

class ArchivoActivity:AppCompatActivity() {
    private lateinit var rvClientesArch: RecyclerView
    private lateinit var btnNuevoClienteArch: Button
    //Arreglo Global
    var lista=ArrayList<Cliente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archivo)

        rvClientesArch = findViewById(R.id.rvClientesArch)
        btnNuevoClienteArch = findViewById(R.id.btnNewClientArch)
        btnNuevoClienteArch.setOnClickListener({ nuevoClienteArch() })
        leerArchivo()

        var adaptador = CliArchAdapter(lista)
        rvClientesArch.adapter = adaptador
        rvClientesArch.layoutManager = LinearLayoutManager(appConfig.CONTEXT)

    }

    private fun nuevoClienteArch() {
        var intent = Intent(this, NuevoCliArch::class.java)
        startActivity(intent)
    }

    fun leerArchivo(){
        // Indicar acceso al storage
        val sd= Environment.getExternalStorageDirectory();
        val archivo= InputStreamReader(openFileInput("clientes.txt"))
        //Crear objeto para leer informacion del archivo
        val bf= BufferedReader(archivo)
        // bucle para realizar recorrido sobre bf
        var linea=bf.readLine()
        while (linea!=null){
            //separar el valor de linea
            var sep=linea.split(",")
            // crear objeto de la clase cliente con los valores del arreglo sep
            val cli=Cliente(sep[0].toInt(),sep[1],sep[2],sep[3].toInt(),sep[4].toInt())
            //adicionar al arreglo lista
            lista.add(cli)
            linea=bf.readLine()
        }
        archivo.close()
        bf.close()
    }


}