package empresa.android.apphotel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import empresa.android.apphotel.controlador.ArregloCliente
import empresa.android.apphotel.controlador.ArregloRecepcionista
import empresa.android.apphotel.entidad.Cliente
import empresa.android.apphotel.entidad.Recepcionista

class DatosRecepActivity:AppCompatActivity() {
    private lateinit var edtCodigoRecep: EditText
    private lateinit var edtNombreRecep: EditText
    private lateinit var edtApellidoRecep: EditText
    private lateinit var edtDniRecep: EditText
    private lateinit var edtTelefonoRecep: EditText
    private lateinit var edtPosicionRecep: EditText
    private lateinit var btnActualizarRecep: Button
    private lateinit var btnEliminarRecep: Button
    private lateinit var btnVolverRecep: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datos_recepcionista)

        edtCodigoRecep=findViewById(R.id.edtCodigoRecepA)
        edtNombreRecep=findViewById(R.id.edtNombresRecepA)
        edtApellidoRecep=findViewById(R.id.edtApellidosRecepA)
        edtDniRecep=findViewById(R.id.edtDniRecepA)
        edtTelefonoRecep=findViewById(R.id.edtTelefonoRecepA)
        edtPosicionRecep=findViewById(R.id.edtPosicionRecepA)

        btnActualizarRecep=findViewById(R.id.btnActualizarRecepcionista)
        btnVolverRecep=findViewById(R.id.btnVolverRecepcionistaA)
        btnEliminarRecep=findViewById(R.id.btnEliminarRecepcionista)

        btnEliminarRecep.setOnClickListener({eliminarRecep()})
        btnActualizarRecep.setOnClickListener({actualizarRecep()})
        btnVolverRecep.setOnClickListener({volverRecep()})
        verDatosRecep()
    }

    private fun eliminarRecep() {
        //leer caja
        var codRecep=edtCodigoRecep.text.toString().toInt()
        //invocar al mètodo deleteRecepcionista
        ArregloRecepcionista().deleteRecepcionista(codRecep)
        Toast.makeText(this,"Recepcionista eliminado", Toast.LENGTH_LONG).show()
    }

    private fun actualizarRecep() {
        //leer cajas
        var codRecep=edtCodigoRecep.text.toString().toInt()
        var nomRecep=edtNombreRecep.text.toString()
        var apeRecep=edtApellidoRecep.text.toString()
        var dniRecep=edtDniRecep.text.toString().toInt()
        var telefonoRecep=edtTelefonoRecep.text.toString().toInt()
        var posicionRecep=edtPosicionRecep.text.toString()
        //crear objeto de la clase Recepcionista y enviar los valores de las variables
        var doc= Recepcionista(codRecep,nomRecep,apeRecep,dniRecep,telefonoRecep,posicionRecep)
        //invocar al mètodo upadteDocente
        ArregloRecepcionista().updateRecepcionista(doc) //posible falla
        Toast.makeText(this,"Recepcionista actualizado", Toast.LENGTH_LONG).show()
    }

    private fun volverRecep() {
        var intent= Intent(this,SQLiteActivity::class.java)
        startActivity(intent)
    }

    private fun verDatosRecep() {
        //recuperar clave "data" que es de tipo Recepcionista
        val bean=intent.getSerializableExtra("data") as Recepcionista
        edtCodigoRecep.setText(""+bean.codigoRecep)
        edtNombreRecep.setText(bean.nombreRecep)
        edtApellidoRecep.setText(bean.apellidoRecep)
        edtDniRecep.setText(""+bean.dniRecep)
        edtTelefonoRecep.setText(""+bean.telefonoRecep)
        edtPosicionRecep.setText(""+bean.posicionRecep)
    }

}