package pro.jayeshseth.windowUtils

import androidx.compose.ui.graphics.Paint
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter

actual fun Paint.applyBlur(blurRadius: Float) {
    if (blurRadius > 0f) {
        this.asFrameworkPaint().maskFilter = MaskFilter.makeBlur(
            FilterBlurMode.NORMAL,
            blurRadius,
        )
    }
}

actual fun Paint.applySpread(spread: Float) {
    if (spread > 0f) {
        val skiaPaint = this.asFrameworkPaint()
        skiaPaint.mode = org.jetbrains.skia.PaintMode.STROKE_AND_FILL
        skiaPaint.strokeWidth = spread * 2f
        skiaPaint.strokeJoin = org.jetbrains.skia.PaintStrokeJoin.ROUND
        skiaPaint.strokeCap = org.jetbrains.skia.PaintStrokeCap.ROUND
    }
}