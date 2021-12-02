package com.example.e_ducate

import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.ActivityMenuBarBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class MenuBar : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuBarBinding

    val params = Bundle()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMenuBar.toolbar)

        val idUsuario : Int = intent.getIntExtra("id_usuario", 0)
//        params.putInt("id_usuario", idUsuario)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView


        val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()


            clientAPIBiblioteca?.getUsuario(idUsuario)?.enqueue(object :
                Callback<Usuario> {
                override fun onResponse(
                    call: Call<Usuario>,
                    response: Response<Usuario>
                ) {
                    if (response.isSuccessful) {

                        params.putSerializable("usuario", response.body())
                        Toast.makeText(applicationContext, "Usuário de ID ${response.body()?.id} resgatado com sucesso!", Toast.LENGTH_SHORT).show()

                    }

                }


                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    Log.e("API Biblioteca", t.message!!)
                    //                    Toast.makeText(context, "Erro na chamada da API", Toast.LENGTH_SHORT).show()
                }

            })



        val navController = findNavController(R.id.nav_host_fragment_content_menu_bar)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_profile,
                R.id.nav_contact,
                R.id.nav_help,

            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }




    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_menu_bar)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun perfil(item: android.view.MenuItem) {
        val navController = findNavController(R.id.nav_host_fragment_content_menu_bar)
        navController.navigate(R.id.nav_profile, params)
    }

    fun contato(item: android.view.MenuItem) {
        val navController = findNavController(R.id.nav_host_fragment_content_menu_bar)
        navController.navigate(R.id.nav_contact, params)
    }


    fun logout(item: android.view.MenuItem) {
        finish()
        startActivity(Intent(this, Login::class.java))
    }
}