package com.example.classhangman.game

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.core.view.children
import androidx.core.view.updateLayoutParams
import com.example.classhangman.databinding.ActivityGameBinding


class GameAnimationsBinder(binding: ActivityGameBinding) {

    val balloons = binding.balloons.children.toList() as ArrayList
    val allBalloons = binding.balloons.children.toList()

    fun startAnimations(): GameAnimationsBinder {

        return this
    }

    fun failAnimation() {

        // balloon animations
        val balloon = balloons.randomOrNull() ?: return
        balloons.remove(balloon)
        ObjectAnimator.ofFloat(
            balloon, "scaleX",
            0.5f, 2f, 0.5f, 2f, 0.5f, 2f, 0.5f, 2f, 0.5f, 2f,
        ).apply {
            duration = 1500
            repeatCount = ValueAnimator.RESTART
            repeatMode = ValueAnimator.REVERSE
            start()
        }.doOnEnd {
            ObjectAnimator.ofFloat(
                balloon, "alpha",
                0f
            ).apply {
                duration = 2000
                start()
            }
        }
    }

    fun winGame() {
        allBalloons.forEach {
            if (it !in balloons) {
                it.alpha = 1f
                ObjectAnimator.ofFloat(
                    it, "scaleX",
                    0f, 1f
                ).apply {
                    duration = 1000
                    start()
                }
            }
        }
    }
}