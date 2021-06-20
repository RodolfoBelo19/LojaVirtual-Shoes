package com.loja.lojavirtual

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import com.loja.lojavirtual.Form.FormLogin

class Slides : IntroActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_slides) #Se fica descomentado, dará o efeito invisível

        //Funções para desabilitar botões voltar/avançar
        isButtonBackVisible = false
        isButtonNextVisible = false

        addSlide(SimpleSlide.Builder()
                .background(R.color.roxo)
                .image(R.drawable.drawer)
                .backgroundDark(R.color.branco)
                .title("Loja Online de Calçados")
                .description("Entre e confira as promoções que preparamos para você!")
                .build())


        addSlide(SimpleSlide.Builder()
            .background(R.color.azul)
            .title("Crie uma conta grátis")
            //.canGoBackward(false) #Função para desabilitar a opção de voltar
            .description("Cadastre-se agora mesmo! E venha conhecer os nossos produtos.")
            .build())

    }
    
    public override fun onPause() {
        super.onPause()

        var intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
    }


}

