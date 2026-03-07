package pro.jayeshseth.windowUtils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

interface GlowingShadowScope {
    /** Blur radius of the shadow, in pixels. Defaults to 0. */
    var blurRadius: Float

    /** Spread parameter that adds to the size of the shadow, in pixels. Defaults to 0. */
    var spread: Float

    /**
     * Color of the shadow, Defaults to [Color.Black]. Attempts to provide Color.Unspecified will
     * fallback to rendering with [Color.Black]. This parameter is consumed if [brush] is null.
     */
    var color: Color

    /** The brush to use for the shadow. If null, the color parameter is consumed instead */
    var brush: Brush?

    /** Opacity of the shadow. Defaults to 1f indicating a fully opaque shadow */
    var alpha: Float

    /** Blending algorithm used by the shadow. Defaults to [BlendMode.SrcOver] */
    var blendMode: BlendMode

    /** Offset of the shadow. Defaults to [Offset.Zero]. */
    var offset: Offset

    /** Size of the canvas the shadow is drawn into*/
    var size: Size

    /** Shape of the canvas the shadow is drawn into*/
    var shape: Shape

    /** Lambda to expose the canvas the shadow is rendering on */
    fun canvas(canvas: (Canvas) -> Unit)
}

internal class GlowingShadowScopeImpl : GlowingShadowScope {
    override var blurRadius: Float = 0f
    override var spread: Float = 0f
    override var color: Color = Color.Black
    override var brush: Brush? = null
    override var alpha: Float = 1f
    override var blendMode: BlendMode = BlendMode.SrcOver
    override var offset: Offset = Offset.Zero
    override var size: Size = Size.Zero
    override var shape: Shape = RoundedCornerShape(0.dp)

    internal var canvasDrawBlock: ((Canvas) -> Unit)? = null

    override fun canvas(canvas: (Canvas) -> Unit) {
        canvasDrawBlock = canvas
    }

    fun reset(newSize: Size) {
        blurRadius = 0f
        spread = 0f
        color = Color.Black
        brush = null
        alpha = 1f
        blendMode = BlendMode.SrcOver
        offset = Offset.Zero
        size = newSize
        shape = RoundedCornerShape(0.dp)
        canvasDrawBlock = null
    }
}