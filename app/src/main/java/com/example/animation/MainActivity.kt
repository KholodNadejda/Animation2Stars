package com.example.animation

import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onStart(view: View) {
        val whiteStar: ImageView = findViewById(R.id.ivWhiteStar)
        val goldStar: ImageView = findViewById(R.id.ivGoldStar)
        val textWin: TextView = findViewById(R.id.tvResult)
        animation(goldStar, R.anim.gold_star)
        animation(whiteStar, R.anim.white_star)
        animationText(textWin,R.anim.text, "Gold Star WIN!")
    }
    fun onCancel(view: View){
        val goldStar: ImageView = findViewById(R.id.ivGoldStar)
        animation(goldStar, R.anim.white_star_cancel)

        val whiteStar: ImageView = findViewById(R.id.ivWhiteStar)
        animation(whiteStar, R.anim.white_star_cancel)

        val textWin: TextView = findViewById(R.id.tvResult)
        animationText(textWin,R.anim.text_cancel, "Who'll win?!")
    }

    fun animation(name: ImageView, id: Int){
        val animation: Animation = AnimationUtils.loadAnimation(this, id)
        name.startAnimation(animation)
    }

    fun animationText(name: TextView, id: Int, text: String){
        val animation: Animation = AnimationUtils.loadAnimation(this, id)
        name.startAnimation(animation)
        name.text = text
    }
}