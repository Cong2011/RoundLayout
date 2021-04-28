package cn.cong.roundapp

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

// Kotlin测试代码，仅显示圆角效果；Java同理
class MainActivity : AppCompatActivity(), View.OnTouchListener {
    private var downX = 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        v_bg.setOnTouchListener(this)

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
            }
            MotionEvent.ACTION_MOVE -> {
                v_bg.translationX = event.x - downX
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                v_bg.translationX = 0F
            }
        }
        return true
    }

}