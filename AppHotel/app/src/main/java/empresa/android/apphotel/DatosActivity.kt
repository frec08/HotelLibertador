package empresa.android.apphotel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import empresa.android.apphotel.controlador.ArregloCliente
import empresa.android.apphotel.entidad.Cliente

class DatosActivity: AppCompatActivity() {
    private lateinit var edtCodigo: EditText
    private lateinit var edtNombre: EditText
    private lateinit var edtApellido: EditText
    private lateinit var edtDni: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var btnActualizar: Button
    private lateinit var btnEliminar: Button
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datos_cliente)

        edtCodigo=findViewById(R.id.edtCodigoA)
        edtNombre=findViewById(R.id.edtNombresA)
        edtApellido=findViewById(R.id.edtApellidosA)
        edtDni=findViewById(R.id.edtDniA)
        edtTelefono=findViewById(R.id.edtTelefonoA)
        btnActualizar=findViewById(R.id.btnActualizarCliente)
        btnVolver=findViewById(R.id.btnVolverA)
        btnEliminar=findViewById(R.id.btnEliminarCliente)
        btnEliminar.setOnClickListener({eliminar()})
        btnActualizar.setOnClickListener({actualizar()})
        btnVolver.setOnClickListener({volver()})
        verDatos()
    }
    fun eliminar(){
        //leer caja
        var cod=edtCodigo.text.toString().toInt()
        //invocar al mètodo deleteCliente
        ArregloCliente().deleteCliente(cod)
        Toast.makeText(this,"Cliente eliminado", Toast.LENGTH_LONG).show()
    }

    fun actualizar(){
        //leer cajas
        var cod=edtCodigo.text.toString().toInt()
        var nom=edtNombre.text.toString()
        var ape=edtApellido.text.toString()
        var dni=edtDni.text.toString().toInt()
        var telefono=edtTelefono.text.toString().toInt()
        //crear objeto de la clase Cliente y enviar los valores de las variables
        var doc=Cliente(cod,nom,ape,dni,telefono)
        //invocar al mètodo upadteDocente
        ArregloCliente().updateCliente(doc)
        Toast.makeText(this,"Cliente actualizado", Toast.LENGTH_LONG).show()
    }
    fun volver(){
        var intent= Intent(this,SQLiteActivity::class.java)
        startActivity(intent)
    }
    fun verDatos(){
        //recuperar clave "data" que es de tipo Cliente
        val bean=intent.getSerializableExtra("data") as Cliente
        edtCodigo.setText(""+bean.codigo)
        edtNombre.setText(bean.nombre)
        edtApellido.setText(bean.apellido)
        edtDni.setText(""+bean.dni)
        edtTelefono.setText(""+bean.telefono)
    }
}