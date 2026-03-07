package pro.jayeshseth.glowingButton

import android.graphics.BlurMaskFilter
import androidx.compose.ui.graphics.Paint

actual fun Paint.applyBlur(blurRadius: Float) {
    if (blurRadius > 0f) {
        this.asFrameworkPaint().maskFilter = BlurMaskFilter(
            blurRadius,
            BlurMaskFilter.Blur.NORMAL,
        )
    }
}

actual fun Paint.applySpread(spread: Float) {
    if (spread > 0f) {
        val frameworkPaint = this.asFrameworkPaint()
        frameworkPaint.style = android.graphics.Paint.Style.FILL_AND_STROKE
        frameworkPaint.strokeWidth = spread * 2f
        frameworkPaint.strokeJoin = android.graphics.Paint.Join.ROUND
        frameworkPaint.strokeCap = android.graphics.Paint.Cap.ROUND
    }
}