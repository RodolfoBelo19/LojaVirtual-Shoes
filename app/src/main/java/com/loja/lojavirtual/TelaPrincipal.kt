package com.loja.lojavirtual

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.firebase.auth.FirebaseAuth
import com.loja.lojavirtual.Form.FormLogin
import com.loja.lojavirtual.Fragments.CadastroProdutos
import com.loja.lojavirtual.Fragments.Produtos
import com.loja.lojavirtual.databinding.ActivityTelaPrincipalBinding

class TelaPrincipal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTelaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarTelaPrincipal.toolbar)

        val produtosFragment = Produtos()
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.frameContainer, produtosFragment)
        fragment.commit()


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.appBarTelaPrincipal.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()
            navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if(id == R.id.nav_produtos){

            val produtosFragment = Produtos()
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.frameContainer, produtosFragment)
            fragment.commit()

        }else if(id == R.id.nav_cadastrar_produtos){

            var intent = Intent(this, CadastroProdutos::class.java)
            startActivity(intent)

        }else if(id == R.id.nav_contato){



        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.tela_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if(id == R.id.action_settings){
            FirebaseAuth.getInstance().signOut()
            VoltarParaLogin()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun VoltarParaLogin(){
        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
    }
}