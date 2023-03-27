package com.example.classhangman.game

import android.content.Context
import android.media.MediaPlayer
import com.example.classhangman.R
import com.example.classhangman.databinding.ActivityGameBinding

class GameSoundBinder(binding: ActivityGameBinding) {

    lateinit var backgroundPlayer: MediaPlayer
    lateinit var keyPressedPlayer: MediaPlayer
    lateinit var balloonsPlayer: MediaPlayer

    lateinit var winPlayer: MediaPlayer
    lateinit var losePlayer: MediaPlayer

    fun initMedia(context: Context){
        backgroundPlayer = MediaPlayer.create(context, R.raw.background_music)
        keyPressedPlayer = MediaPlayer.create(context, R.raw.click_button)
        balloonsPlayer = MediaPlayer.create(context, R.raw.balloons)
        winPlayer = MediaPlayer.create(context, R.raw.instant_win)
        losePlayer = MediaPlayer.create(context, R.raw.losing_bleeps)
        playBackgroundMusic()
    }

    private fun playBackgroundMusic(){
        backgroundPlayer.start()
    }

    fun playKeyPressedEffect(){
        keyPressedPlayer.start()
    }

    fun balloongsEffect(){
        balloonsPlayer.start()
    }

    fun winGameEffect(){
        winPlayer.start()
    }

    fun loseGameEffect(){
        losePlayer.start()
    }

    fun stopBackgroundMusic(){
        backgroundPlayer.stop()
    }
}