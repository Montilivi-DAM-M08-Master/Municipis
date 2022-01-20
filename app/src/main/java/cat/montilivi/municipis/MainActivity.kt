package cat.montilivi.municipis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.montilivi.municipis.dades.Fitxers
import cat.montilivi.municipis.models.Municipi
import cat.montilivi.municipis.models.Provincia
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var provinciaActual = 0
    var municipiActual = 0

    var provincies: List<Provincia>? = null
    var municipis: Map<String, ArrayList<Municipi>>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        municipis = Fitxers.obteMunicipisClassificats(this)
        provincies = Fitxers.obteTaulaNomProvincies(this)
    }

    fun provinciaSeguent() {

    }


    fun provinciaAnterior() {

    }

    private fun actualitzaProvincia() {

    }

    private fun municipiSeguent() {

    }

    private fun municipiAnterior() {

    }
}