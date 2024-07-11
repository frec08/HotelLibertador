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

class NuevoCliArch: AppCompatActivity() {
    private lateinit var edtCodigoArch: EditText
    private lateinit var edtNombreArch: EditText
    private lateinit var edtApellidoArch: EditText
    private lateinit var edtDniArch: EditText
    private lateinit var edtTelefonoArch: EditText
    private lateinit var btnGrabarArch: Button
    private lateinit var btnVolverArch: Button

    //Arreglo Global
    var lista=ArrayList<Cliente>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_cli_arch)
        edtCodigoArch=findViewById(R.id.edtCodigoArch)
        edtNombreArch=findViewById(R.id.edtNombresArch)
        edtApellidoArch=findViewById(R.id.edtApellidosArch)
        edtDniArch=findViewById(R.id.edtDniArch)
        edtTelefonoArch=findViewById(R.id.edtTelefonoArch)
        btnGrabarArch=findViewById(R.id.btnGrabarNewCliArch)
        btnVolverArch=findViewById(R.id.btnSalirCliArch)

        btnGrabarArch.setOnClickListener({grabar()})
        btnVolverArch.setOnClickListener({volverArch()})
        leerArchivo()
    }
    fun grabar(){
        //leer cajas
        var codArch=edtCodigoArch.text.toString().toInt()
        var nomArch=edtNombreArch.text.toString()
        var apeArch=edtApellidoArch.text.toString()
        var dniArch=edtDniArch.text.toString().toInt()
        var telefonoArch=edtTelefonoArch.text.toString().toInt()

        //crear objeto de la clase Docente y enviar los valores de las variables
        var cli= Cliente(codArch,nomArch,apeArch,dniArch,telefonoArch)
        lista.add(cli)
        grabarArchivo()

        Toast.makeText(this,"Cliente registrado", Toast.LENGTH_LONG).show()
    }
    fun volverArch(){
        var intent= Intent(this,ArchivoActivity::class.java)
        startActivity(intent)
    }

    fun grabarArchivo(){
        // Indicar acceso al storage
        val sd=Environment.getExternalStorageDirectory();
        val archivo=OutputStreamWriter(openFileOutput("clientes.txt", MODE_PRIVATE))
        //bucle para realizar recorridoo sobre lista
        for (bean in lista){
            archivo.write(bean.codigo.toString()+","+bean.nombre+","+bean.apellido
                    +","+bean.dni.toString()+","+bean.telefono.toString()+"\n")
            archivo.flush()
        }
        //cerrar archivo
        archivo.close()
    }

    fun leerArchivo(){
        // Indicar acceso al storage
        val sd=Environment.getExternalStorageDirectory();
        val archivo=InputStreamReader(openFileInput("clientes.txt"))
        //Crear objeto para leer informacion del archivo
        val bf=BufferedReader(archivo)
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