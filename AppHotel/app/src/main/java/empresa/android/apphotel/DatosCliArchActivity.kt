package empresa.android.apphotel

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import empresa.android.apphotel.controlador.ArregloCliente
import empresa.android.apphotel.entidad.Cliente
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class DatosCliArchActivity: AppCompatActivity() {
    private lateinit var edtCodigo: EditText
    private lateinit var edtNombre: EditText
    private lateinit var edtApellido: EditText
    private lateinit var edtDni: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var btnActualizar: Button
    private lateinit var btnEliminar: Button
    private lateinit var btnVolver: Button

    //Arreglo Global
    var lista=ArrayList<Cliente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datos_cli_arch)

        edtCodigo=findViewById(R.id.edtCodigoArchA)
        edtNombre=findViewById(R.id.edtNombresArchA)
        edtApellido=findViewById(R.id.edtApellidosArchA)
        edtDni=findViewById(R.id.edtDniArchA)
        edtTelefono=findViewById(R.id.edtTelefonoArchA)
        btnActualizar=findViewById(R.id.btnActualizarClienteArch)
        btnVolver=findViewById(R.id.btnVolverArchA)
        btnEliminar=findViewById(R.id.btnEliminarClienteArch)
        btnEliminar.setOnClickListener({eliminar()})
        btnActualizar.setOnClickListener({actualizar()})
        btnVolver.setOnClickListener({volver()})
        verDatos()
        leerArchivo()
    }
    fun eliminar(){
        //leer caja
        var cod=edtCodigo.text.toString().toInt()
        //invocar al mètodo deleteCliente
        val pos=buscarPosicion(cod)
        lista.removeAt(pos)
        grabarArchivo()
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
        var cli= Cliente(cod,nom,ape,dni,telefono)
        //invocar al mètodo upadteDocente
        val pos=buscarPosicion(cod)
        lista.set(pos,cli)
        grabarArchivo()
        Toast.makeText(this,"Cliente actualizado", Toast.LENGTH_LONG).show()
    }
    fun volver(){
        var intent= Intent(this,ArchivoActivity::class.java)
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

    // Funcion que retorna la posicion dentro del arreglo "lista" de un cliente segun su codigo
    fun buscarPosicion(cod:Int):Int{
        var pos=-1
        var index=0;

        for (bean in lista){
            if (bean.codigo==cod){
                pos=index
                break
            }
            index++
        }

        return pos
    }

    fun grabarArchivo(){
        // Indicar acceso al storage
        val sd=Environment.getExternalStorageDirectory();
        val archivo= OutputStreamWriter(openFileOutput("clientes.txt", MODE_PRIVATE))
        //bucle para realizar recorridoo sobre lista
        for (bean in lista){
            archivo.write(bean.codigo.toString()+","+bean.nombre+","+bean.apellido
                    +","+bean.dni.toString()+","+bean.telefono.toString()+"\n")
            archivo.flush()
        }
        //cerrar archivo
        archivo.close()
    }

}