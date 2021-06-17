package com.loja.lojavirtual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class Slides : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_slides) #Se fica descomentado, dará o efeito invisível

        isButtonBackVisible = false

        addSlide(

            SimpleSlide.Builder()
                .background(R.color.roxo)
                .image(R.drawable.drawer)
                .backgroundDark(R.color.branco)
                .title("Loja Online de Calçados")
                .description("Entre e confira as promoções que preparamos para você!")
                .build()
        )

        addSlide(

            SimpleSlide.Builder()
                .background(R.color.azul)
                .title("Crie uma conta grátis")
                .description("Cadastre-se agora mesmo! E venha conhecer os nossos produtos.")
                .build()
        )
    }
}