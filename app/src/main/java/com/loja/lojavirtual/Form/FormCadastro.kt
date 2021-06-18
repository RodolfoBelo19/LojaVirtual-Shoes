package com.loja.lojavirtual.Form

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.loja.lojavirtual.R
import com.loja.lojavirtual.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityFormCadastroBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.btRegistrar.setOnClickListener {
            CadastrarUsuario()
        }
    }

    private fun CadastrarUsuario(){
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()

        if(email.isEmpty() || senha.isEmpty()) {
            //Toast.makeText(this, "Preencha todos os dados!", Toast.LENGTH_SHORT).show() #Alert
            var snackbar = Snackbar.make(binding.layoutCadastro, "Preencha todos os dados!", Snackbar.LENGTH_SHORT) //Novo recurso Alert
                .setBackgroundTint(Color.WHITE).setTextColor(Color.BLACK)
            snackbar.show()
        }else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
                if(it.isSuccessful) {
                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show()
            }
        }
    }
}