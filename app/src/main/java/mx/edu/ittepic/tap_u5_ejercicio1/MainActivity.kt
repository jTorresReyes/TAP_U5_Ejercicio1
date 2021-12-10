package mx.edu.ittepic.tap_u5_ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //VARIABLES
    var numero = 9
    var sueldo = 1200.99 //double
    var altura = 1.8f //float
    var direccionCasa = "Allende 200" //String
    var resultado = true //boolean

    var nombreCompleto : String = ""
    var edad : Int = 0
    var nombreCampoTexto : EditText ?= null //Contruyendo una variable EditText SIN ASOCIAR con XML aun
    var boton : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asignar evento CLICK al boton
        botonsaludador.setOnClickListener {
            var nombre = camponombrepersona.text.toString()
            //SI NOMBRE ESTA VACIO, QUE MARQUE UN MENSAJE DE ERROR!
            if (nombre.isEmpty() == true){
                AlertDialog.Builder(this)
                    .setTitle("ERROR!")
                    .setMessage("Debes ingresar un nombre en el campo de texto!")
                    .setPositiveButton("OK",{d,i-> d.dismiss()})
                    .show()
            } else {

                //Alertdialog = JOptionPane
                val alerta = AlertDialog.Builder(this)
                //Val declara un objeto semi estatico, requiere menos memoria que Var

                alerta.setTitle("ATENCION")
                alerta.setMessage("Hola, ${nombre}! Como estas?") //${variable} esto se llama PRECOMPILADOR
                alerta.setPositiveButton("ACEPTAR", { d, i ->
                    //D = Dialog. Informa a ANDROID si el AlertDialog se cerro de manera positiva o negativa
                    //I = Excepcion. Se ejecuta en caso de error, cuando no hay error, esta null

                    d.dismiss() //de manera positiva
                })
                alerta.setNegativeButton("CANCELAR", { d, i ->
                    d.cancel()//de forma negativa
                })

                alerta.show()
            }
        }

        radioButton.setOnClickListener {
            Toast.makeText(this, "Usted es CASADO (A)", Toast.LENGTH_LONG).show()
        }

        radioButton2.setOnClickListener {
            Toast.makeText(this, "Usted es SOLTERO (A)", Toast.LENGTH_LONG).show()
        }

    }
}