package com.taboola.hp4udemoapplication.view

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.taboola.hp4udemoapplication.R

class AnimatedBackgroundTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    private var colorAnimation: ValueAnimator

    init {
        val colorFrom = ContextCompat.getColor(context, R.color.swapped_semi_transparent)
        val colorTo = ContextCompat.getColor(context, R.color.swapped)
        colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        startColorAnimation()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        colorAnimation.cancel()
    }

    private fun startColorAnimation() {
        colorAnimation.duration = 800 // milliseconds
        colorAnimation.addUpdateListener { animator -> setBackgroundColor(animator.animatedValue as Int) }
        colorAnimation.repeatCount = ValueAnimator.INFINITE
        colorAnimation.repeatMode = ValueAnimator.REVERSE
        colorAnimation.start()
    }

}