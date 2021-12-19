package com.smh.recorder

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatImageButton

class RecordButton (
    context: Context,
    attrs: AttributeSet
): AppCompatImageButton(context, attrs) {
// AppCompat은 기존 클래스를 랩핑해서 이전버전에서도 새로출시한 기능 중 대부분의 기능을 정상적으로 작동하게 해주는 라이브러리

    fun updateIconWithState(state: State) {
        when(state) {
            State.BEFORE_RECORDING -> {
                setImageResource(R.drawable.ic_record)
            }
            State.ON_RECORDING -> {
                setImageResource(R.drawable.ic_stop)
            }
            State.AFTER_RECORDING -> {
                setImageResource(R.drawable.ic_play)
            }
            State.ON_PLAYING -> {
                setImageResource(R.drawable.ic_stop)
            }
        }
    }

}