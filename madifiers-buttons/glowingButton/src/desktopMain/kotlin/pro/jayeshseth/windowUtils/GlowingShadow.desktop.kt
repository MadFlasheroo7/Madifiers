package pro.jayeshseth.windowUtils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Preview
@Composable
fun SampleDesk() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(500.dp)
                .glowingShadow {
                    blurRadius = 100f
//                    spread = 100f
                    shape = CutCornerShape(50.dp)
//                    this.alpha = 0.1f
                    this.canvas { canvas ->
                        val customPaint = Paint().apply {
                            color = Color.White
//                            style = PaintingStyle.Stroke
                            strokeWidth = 4f
                        }

                        canvas.drawCircle(
                            center = Offset(size.width / 2f, size.height / 2f),
                            radius = (size.width / 2f) + spread,
                            paint = customPaint,
                        )
                    }
//                    color = Color.Cyan
                },
        )
    }
}
