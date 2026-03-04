package pro.jayeshseth.windowUtils

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

@Preview
@Composable
fun Sample() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(500.dp)
                .glowingShadow {
                    this.size = Size(500f, 500f)
//                    blurRadius = 100f
//                    spread = 100f
                    shape = CutCornerShape(50.dp)
//                    this.alpha = 0.1f
//                    this.canvas { canvas ->
//                        val customPaint = Paint().apply {
//                            color = Color.White
////                            style = PaintingStyle.Stroke
//                            strokeWidth = 4f
//                        }
//
//                        canvas.drawCircle(
//                            center = Offset(size.width / 2f, size.height / 2f),
//                            radius = (size.width / 2f) + spread,
//                            paint = customPaint,
//                        )
//                    }
                    color = Color.Cyan
                },
        )
    }
}
