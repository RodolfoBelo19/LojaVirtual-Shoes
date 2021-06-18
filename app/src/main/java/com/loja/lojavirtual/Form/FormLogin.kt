package com.loja.lojavirtual.Form

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loja.lojavirtual.R
import com.loja.lojavirtual.Slides
import com.loja.lojavirtual.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        var tela_cadastro = binding.telaCadastro
        tela_cadastro.setOnClickListener {

            var intent = Intent(this,  FormCadastro::class.java)
            startActivity(intent)
        }

    }
}