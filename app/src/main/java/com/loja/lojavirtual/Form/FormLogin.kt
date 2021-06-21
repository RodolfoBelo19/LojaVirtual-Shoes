package com.loja.lojavirtual.Form

import android.content.Intent
import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.core.os.postDelayed
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.loja.lojavirtual.R
import com.loja.lojavirtual.Slides
import com.loja.lojavirtual.TelaPrincipal
import com.loja.lojavirtual.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        VerificarUsuarioLogado()

        supportActionBar!!.hide()

        var tela_cadastro = binding.telaCadastro
        tela_cadastro.setOnClickListener {

            var intent = Intent(this,  FormCadastro::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            login()
        }
    }

    private fun login(){

        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()

        if(email.isEmpty() || senha.isEmpty()) {
            var snackbar = Snackbar.make(binding.layoutLogin, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.WHITE).setTextColor(Color.BLACK)
                snackbar.show()
        }else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
                if(it.isSuccessful){
                    binding.FrameLayout.visibility = View.VISIBLE
                    Handler().postDelayed({AbrirTelaPrincipal()}, 2000)
                    Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()

                }
            }.addOnFailureListener {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun VerificarUsuarioLogado(){

        val usuarioLocal = FirebaseAuth.getInstance().currentUser

        if(usuarioLocal != null){
            AbrirTelaPrincipal()
        }
    }

    private fun AbrirTelaPrincipal(){

        var intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)

    }

}