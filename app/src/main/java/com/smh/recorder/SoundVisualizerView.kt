package com.smh.recorder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SoundVisualizerView (
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    val amplitudePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.getColor(R.color.purple_500)
        strokeWidth = LINE_WIDTH
        strokeCap = Paint.Cap.ROUND//라인의 양끝을 어떻게 표시할것인지
    } // 각져서 그려지는걸 방지하는 클래스
    var drawingWidth: Int = 0
    var drawingHeight: Int = 0
    var drawingAmplitudes: List<Int> = emptyList() // test : (0..10).map {Random.nextInt(Short.MAX_VALUE.toInt())}

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        drawingWidth = w
        drawingHeight = h
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas ?: return // canvas가 null일 경우

        val centerY = drawingHeight / 2f
        var offsetX = drawingWidth.toFloat()

        drawingAmplitudes.forEach { amplitude ->
            val lineLength = amplitude / MAX_AMPLITUDE * drawingHeight * 0.8F

            offsetX -= LINE_SPACE
            if(offsetX < 0) return@forEach

            canvas.drawLine(
                offsetX,
                centerY - lineLength / 2F,
                offsetX,
                centerY + lineLength / 2F,
                amplitudePaint
            )

        }

    }

    companion object {
        private const val LINE_WIDTH = 10F
        private  const val LINE_SPACE = 15F
        private const val MAX_AMPLITUDE = Short.MAX_VALUE.toFloat()
    }

}
