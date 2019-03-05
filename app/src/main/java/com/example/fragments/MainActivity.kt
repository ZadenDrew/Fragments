package com.example.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Añadimos una activity nueva (activity_main -- New -- Layout Resource File)
        // Al cambiar a horizontal sale un toast
        if (txtHorizontal != null) {
            toast("Horizontal")

            if (savedInstanceState == null) {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.frameH, Detalles.newInstance(), "Detalles")
                    .commit()
            }
        }
        // Hacemos que cada vez que cliquemos el boton cambiemos de activity
        botonC.setOnClickListener {
            startActivity(intentFor<New>("id" to 5).singleTop())
        }
    }
}
