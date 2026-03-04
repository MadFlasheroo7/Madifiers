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
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.withSave
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Applies a customizable glowing shadow effect behind the content.
 *
 * This modifier allows for fine-grained control over shadow properties such as color,
 * blur radius, spread, offset, and shape through the [GlowingShadowScope].
 *
 * @param block A lambda used to configure the shadow properties using [GlowingShadowScope].
 */
fun Modifier.glowingShadow(
    block: GlowingShadowScope.() -> Unit,
): Modifier = this then GlowingShadowElement(
    block = block,
)

/**
 * A [ModifierNodeElement] that creates and updates a [GlowingShadowNode].
 *
 * This element is responsible for bridging the [glowingShadow] modifier function
 * with the underlying node logic, ensuring that the configuration block is
 * properly applied and updated during recomposition.
 *
 * @property block The configuration lambda applied to the [GlowingShadowScope].
 */
internal data class GlowingShadowElement(
    val block: GlowingShadowScope.() -> Unit,
) : ModifierNodeElement<GlowingShadowNode>() {

    override fun create(): GlowingShadowNode = GlowingShadowNode(block)

    override fun update(node: GlowingShadowNode) {
        node.update(block)
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "glowingShadow"
        properties["block"] = block
    }
}

/**
 * A [Modifier.Node] that handles the custom drawing logic for the glowing shadow effect.
 *
 * This node implements [DrawModifierNode] to intercept the draw phase, where it:
 * 1. Creates a [GlowingShadowScope] to resolve shadow configuration (color, blur, shape, etc.).
 * 2. Computes the path based on the provided shape and size.
 * 3. Applies a blur mask filter to the paint.
 * 4. Draws the resulting shadow path onto the canvas.
 *
 * @property block The configuration lambda that defines the shadow's visual properties.
 */
internal class GlowingShadowNode(
    var block: GlowingShadowScope.() -> Unit,
) : Modifier.Node(),
    DrawModifierNode {
    private val shadowPath = Path()
    override fun ContentDrawScope.draw() {
        drawIntoCanvas { canvas ->
            val scope = GlowingShadowScopeImpl().apply {
                this.size = this@draw.size
                this.reset(this.size)
                block()
            }

            val outline = scope.shape.createOutline(
                size = this@draw.size,
                layoutDirection = this@draw.layoutDirection,
                density = this,
            )
            val paint = Paint().apply {
                if (scope.brush == null) this.color = scope.color
                this.alpha = scope.alpha
                this.blendMode = scope.blendMode
                this.applyBlur(scope.blurRadius)
                this.applySpread(scope.spread)
            }

            scope.brush?.applyTo(this.size, paint, alpha = scope.alpha)
            shadowPath.addOutline(outline)

            canvas.withSave {
                canvas.drawPath(
                    shadowPath, paint,
                )
            }
            scope.canvasDrawBlock?.invoke(canvas)
            drawContent()
        }
    }

    fun update(block: GlowingShadowScope.() -> Unit) {
        this.block = block
    }
}

/**
 * Applies a blur mask filter to the [Paint] object.
 *
 * This function converts the [blurRadius] into a native mask filter to create
 * the soft glow effect. If the radius is less than or equal to zero, no blur is applied.
 *
 * @param blurRadius The radius of the blur in pixels.
 */
expect fun Paint.applyBlur(blurRadius: Float)


/**
 * Scales the paint's stroke width or adjusts the drawing bounds to simulate a spread effect.
 *
 * Spread increases or decreases the size of the shadow relative to the original shape
 * before the blur is applied.
 *
 * @param spread The distance to expand (positive) or contract (negative) the shadow.
 */
expect fun Paint.applySpread(spread: Float)

// TODO add expect actual for android & non android


@Preview
@Composable
fun SampleCommon() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(500.dp)
                .glowingShadow {
                    blurRadius = 10f
                    shape = CutCornerShape(50.dp)
//                    this.alpha = 0.1f
                    this.canvas { canvas ->
                        val customPaint = Paint().apply {
                            color = Color.White
                            style = PaintingStyle.Stroke
                            strokeWidth = 4f
                        }

                        canvas.drawCircle(
                            center = Offset(size.width / 2f, size.height / 2f),
                            radius = (size.width / 2f) + spread,
                            paint = customPaint,
                        )
                    }
                    color = Color.Cyan
                },
        )
    }
}
