package empresa.android.apphotel

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CotizaActivity:AppCompatActivity() {

    // Precios de las habitaciones
    private val roomPrices = mapOf("Habitación grande" to 100.0, "Habitación mediana" to 60.0, "Habitación pequeña" to 30.0)

    // Costos de los servicios adicionales
    private val serviceCosts = mapOf("Desayuno" to 10.0, "Almuerzo" to 15.0, "Cena" to 20.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotiza)

        // Encuentra las vistas
        val cbHabitacionGrande = findViewById<CheckBox>(R.id.cbHabitaciónGrande)
        val cbHabitacionMediana = findViewById<CheckBox>(R.id.cbHabitaciónMediana)
        val cbHabitacionPequena = findViewById<CheckBox>(R.id.cbHabitaciónPequeña)
        val edtHabitacionGrande = findViewById<EditText>(R.id.edtHabitacionGrande)
        val edtHabitacionMediana = findViewById<EditText>(R.id.edtHabitacionMediana)
        val edtHabitacionPequena = findViewById<EditText>(R.id.edtHabitacionPequeña)
        val edtCantidadDias = findViewById<EditText>(R.id.edtCantidadDias)
        val cbDesayuno = findViewById<CheckBox>(R.id.cbDesayuno)
        val cbAlmuerzo = findViewById<CheckBox>(R.id.cbAlmuerzo)
        val cbCena = findViewById<CheckBox>(R.id.cbCena)
        val rbEfectivo = findViewById<RadioButton>(R.id.rbEfectivo)
        val textViewTotalCost = findViewById<TextView>(R.id.textView_total_cost)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        // Maneja el clic en el botón "Calcular costo"
        btnCalcular.setOnClickListener {
            // Obtiene los valores de las vistas
            val habitacionGrande = cbHabitacionGrande.isChecked
            val habitacionMediana = cbHabitacionMediana.isChecked
            val habitacionPequena = cbHabitacionPequena.isChecked
            val cantidadHabitacionGrande = if (habitacionGrande) edtHabitacionGrande.text.toString().toInt() else 0
            val cantidadHabitacionMediana = if (habitacionMediana) edtHabitacionMediana.text.toString().toInt() else 0
            val cantidadHabitacionPequena = if (habitacionPequena) edtHabitacionPequena.text.toString().toInt() else 0
            val days = edtCantidadDias.text.toString().toInt()
            val breakfast = cbDesayuno.isChecked
            val lunch = cbAlmuerzo.isChecked
            val dinner = cbCena.isChecked
            val cash = rbEfectivo.isChecked

            // Calcula el costo de la habitación
            val roomCost = roomPrices["Habitación grande"]!! * cantidadHabitacionGrande * days +
                    roomPrices["Habitación mediana"]!! * cantidadHabitacionMediana * days +
                    roomPrices["Habitación pequeña"]!! * cantidadHabitacionPequena * days

            // Calcula el costo de los servicios adicionales
            var serviceCost = 0.0
            if (breakfast) serviceCost += serviceCosts["Desayuno"]!! * days
            if (lunch) serviceCost += serviceCosts["Almuerzo"]!! * days
            if (dinner) serviceCost += serviceCosts["Cena"]!! * days

            // Calcula el costo total
            var totalCost = roomCost + serviceCost

            // Aplica el recargo si el pago es con tarjeta
            if (!cash) totalCost *= 1.1

            // Muestra el costo total
            textViewTotalCost.text = "$totalCost"
        }
    }
}