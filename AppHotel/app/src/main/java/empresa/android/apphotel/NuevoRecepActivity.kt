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

class NuevoRecepActivity:AppCompatActivity() {
    private lateinit var edtNombreRecep: EditText
    private lateinit var edtApellidoRecep: EditText
    private lateinit var edtDniRecep: EditText
    private lateinit var edtTelefonoRecep: EditText
    private lateinit var edtPosicionRecep: EditText
    private lateinit var btnGrabarRecep: Button
    private lateinit var btnVolverRecep: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nuevo_recepcionista)
        edtNombreRecep=findViewById(R.id.edtNombresRecep)
        edtApellidoRecep=findViewById(R.id.edtApellidosRecep)
        edtDniRecep=findViewById(R.id.edtDniRecep)
        edtTelefonoRecep=findViewById(R.id.edtTelefonoRecep)
        edtPosicionRecep=findViewById(R.id.edtPosicionRecep)
        btnGrabarRecep=findViewById(R.id.btnGrabarRecep)
        btnVolverRecep=findViewById(R.id.btnVolverRecep)

        btnGrabarRecep.setOnClickListener({grabarRecep()})
        btnVolverRecep.setOnClickListener({volverRecep()})
    }

    private fun grabarRecep() {
        //leer cajas
        var nomRecep=edtNombreRecep.text.toString()
        var apeRecep=edtApellidoRecep.text.toString()
        var dniRecepString=edtDniRecep.text.toString()
        var telefonoRecepString=edtTelefonoRecep.text.toString()
        var posicionRecep=edtTelefonoRecep.text.toString()

        // Verificar si algún campo está vacío
        if (nomRecep.isEmpty() || apeRecep.isEmpty() || dniRecepString.isEmpty() ||
            telefonoRecepString.isEmpty() || posicionRecep.isEmpty()) {
            Toast.makeText(this,"Por favor, completa todos los campos", Toast.LENGTH_LONG).show()
            return
        }

        var dniRecep = dniRecepString.toInt()
        var telefonoRecep = telefonoRecepString.toInt()


        //crear objeto de la clase Docente y enviar los valores de las variables
        var doc= Recepcionista(0,nomRecep,apeRecep,dniRecep,telefonoRecep,posicionRecep)
        //invocar al mètodo saveRecepcionista
        ArregloRecepcionista().saveRecepcionista(doc)
        Toast.makeText(this,"Recepcionista registrado", Toast.LENGTH_LONG).show()
    }

    private fun volverRecep() {
        var intent= Intent(this,SQLiteActivity::class.java)
        startActivity(intent)
    }
}