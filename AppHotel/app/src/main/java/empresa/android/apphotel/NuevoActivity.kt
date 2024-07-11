package empresa.android.apphotel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import empresa.android.apphotel.controlador.ArregloCliente
import empresa.android.apphotel.entidad.Cliente

class NuevoActivity: AppCompatActivity() {
    private lateinit var edtNombre: EditText
    private lateinit var edtApellido: EditText
    private lateinit var edtDni: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var btnGrabar: Button
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nuevo_activity)
        edtNombre=findViewById(R.id.edtNombres)
        edtApellido=findViewById(R.id.edtApellidos)
        edtDni=findViewById(R.id.edtDni)
        edtTelefono=findViewById(R.id.edtTelefono)
        btnGrabar=findViewById(R.id.btnGrabar)
        btnVolver=findViewById(R.id.btnVolver)

        btnGrabar.setOnClickListener({grabar()})
        btnVolver.setOnClickListener({volver()})
    }
    fun grabar(){
        //leer cajas
        var nom=edtNombre.text.toString()
        var ape=edtApellido.text.toString()
        var dniString=edtDni.text.toString()
        var telefonoString=edtTelefono.text.toString()

        // Verificar si algún campo está vacío
        if (nom.isEmpty() || ape.isEmpty() || dniString.isEmpty() || telefonoString.isEmpty()) {
            Toast.makeText(this,"Por favor, completa todos los campos", Toast.LENGTH_LONG).show()
            return
        }

        var dni = dniString.toInt()
        var telefono = telefonoString.toInt()

        //crear objeto de la clase Docente y enviar los valores de las variables
        var doc=Cliente(0,nom,ape,dni,telefono)
        //invocar al mètodo saveCliente
        ArregloCliente().saveCliente(doc)
        Toast.makeText(this,"Cliente registrado", Toast.LENGTH_LONG).show()
    }
    fun volver(){
        var intent= Intent(this,SQLiteActivity::class.java)
        startActivity(intent)
    }
}