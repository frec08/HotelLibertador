package empresa.android.apphotel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import empresa.android.apphotel.adaptador.ClienteAdapter
import empresa.android.apphotel.adaptador.RecepcionistaAdapter
import empresa.android.apphotel.controlador.ArregloCliente
import empresa.android.apphotel.controlador.ArregloRecepcionista
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.entidad.Recepcionista
import empresa.android.apphotel.utils.appConfig

class SQLiteActivity:AppCompatActivity() {
    private lateinit var rvClientes: RecyclerView
    private lateinit var rvRecepcionista: RecyclerView
    private lateinit var btnNuevoCliente: Button
    private lateinit var btnNuevoRecepcionista: Button
    private lateinit var btnVolverSql: Button
    var datos = ArrayList<Cliente>()
    var datosR = ArrayList<Recepcionista>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvClientes = findViewById(R.id.rvClientes)
        rvRecepcionista = findViewById(R.id.rvRecepcionistas)

        btnNuevoCliente = findViewById(R.id.btnNuevoCliente)
        btnNuevoCliente.setOnClickListener({ nuevoCliente() })

        btnNuevoRecepcionista = findViewById(R.id.btnNuevoRecepcionista)
        btnNuevoRecepcionista.setOnClickListener({nuevoRecepcionista()})


        btnVolverSql = findViewById(R.id.btnVolverSql)
        btnVolverSql.setOnClickListener({ volverHome() })


        var adaptador = ClienteAdapter(ArregloCliente().listado())
        rvClientes.adapter = adaptador
        rvClientes.layoutManager = LinearLayoutManager(appConfig.CONTEXT)
        var adaptorR = RecepcionistaAdapter(ArregloRecepcionista().listadoRecep())
        rvRecepcionista.adapter = adaptorR
        rvRecepcionista.layoutManager = LinearLayoutManager(appConfig.CONTEXT)
    }

    fun nuevoCliente() {
        var intent = Intent(this, NuevoActivity::class.java)
        startActivity(intent)
    }

    private fun nuevoRecepcionista() {
        var intent = Intent(this, NuevoRecepActivity::class.java)
        startActivity(intent)
    }

    private fun volverHome() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}