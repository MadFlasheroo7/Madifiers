/*
 * Copyright 2024 Jayesh Seth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pro.jayeshseth.buttons

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Glowing Button
 *
 * the button provides the glowing effect to the button using [Modifier.glowingShadow] and provides
 * full control of the effect.
 *
 * @param onClick called when this button is clicked.
 * @param modifier the [Modifier] to be applied to this button.
 * @param colors [GlowingButtonColors] that will be used to resolve the colors used for this button.
 * @param shape shape of button.
 * @param spreadRadius spread radius of the glow effect.
 * @param glowIntensity glow intensity of the glow effect for glow effect of container check out
 * [GlowingButtonDefaults.glowingButtonColors].
 * @param glowRadius radius of the glow effect.
 * @param onLongClick called when this button is long clicked.
 * @param onDoubleTap called when this button is double tapped.
 * @param longClickDescription description of the long click action.
 * @param clickDescription description of the click action.
 * @param enabled controls the enabled state of this button. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param border the border to draw around the container of this button.
 * @param glowBorderRadius border radius of the glow effect.
 * @param spreadOffset spread offset of the glow effect.
 * @param outerPadding padding applied out of the container.
 * @param contentPadding the spacing values to apply internally between the container and the
 * content.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param content content to be displayed in this button, usually a [Text]
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GlowingButton(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  colors: GlowingButtonColors = GlowingButtonDefaults.glowingButtonColors(),
  shape: Shape = GlowingButtonDefaults.shape,
  spreadRadius: Dp = GlowingButtonDefaults.spreadRadius,
  glowIntensity: Float = GlowingButtonDefaults.glowIntensity,
  glowRadius: Dp = GlowingButtonDefaults.glowRadius,
  onLongClick: () -> Unit = {},
  onDoubleTap: () -> Unit = {},
  longClickDescription: String? = null,
  clickDescription: String? = null,
  enabled: Boolean = true,
  border: BorderStroke? = null,
  glowBorderRadius: Dp = GlowingButtonDefaults.glowBorderRadius,
  spreadOffset: Offset = GlowingButtonDefaults.spreadOffset,
  outerPadding: PaddingValues = GlowingButtonDefaults.outerPadding,
  contentPadding: PaddingValues = GlowingButtonDefaults.contentPadding,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  content: @Composable RowScope.() -> Unit,
) {
  val containerColor = colors.containerColor(enabled).value
  val contentColor = colors.contentColor(enabled).value
  val glowColor = colors.glowColor(enabled).value
  Surface(
    color = containerColor,
    contentColor = contentColor,
    border = border,
    modifier = modifier
      .semantics { role = Role.Button }
      .padding(outerPadding)
      .glowingShadow(
        color = glowColor.brightness(glowIntensity),
        borderRadius = glowBorderRadius,
        blurRadius = glowRadius,
        offsetY = spreadOffset.x.dp,
        offsetX = spreadOffset.y.dp,
        spread = spreadRadius,
      )
      .clip(shape)
      .combinedClickable(
        interactionSource = interactionSource,
        indication = rememberRipple(),
        enabled = enabled,
        onClickLabel = clickDescription,
        role = Role.Button,
        onLongClickLabel = longClickDescription,
        onLongClick = onLongClick,
        onDoubleClick = onDoubleTap,
        onClick = onClick,
      ),
  ) {
    CompositionLocalProvider(LocalContentColor provides contentColor) {
      ProvideTextStyle(value = MaterialTheme.typography.labelLarge) {
        Row(
          Modifier
            .defaultMinSize(
              minWidth = GlowingButtonDefaults.MinWidth,
              minHeight = GlowingButtonDefaults.MinHeight,
            )
            .padding(contentPadding),
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically,
          content = content,
        )
      }
    }
  }
}

/**
 * Default Values for [GlowingButton]
 */
object GlowingButtonDefaults {

  /**
   * Default glow radius of [GlowingButton]
   */
  val glowRadius = 10.dp

  /**
   * Default shape of [GlowingButton]
   */
  val shape: Shape = RoundedCornerShape(50.dp)

  /**
   * Default glow border radius of [GlowingButton]
   */
  val glowBorderRadius = 50.dp

  /**
   * Default glow intensity of [GlowingButton]
   */
  val glowIntensity = 0.5f

  /**
   * Default offset of [GlowingButton]
   */
  val spreadOffset = Offset(0f, 0f)

  /**
   * Default spread radius of [GlowingButton]
   */
  val spreadRadius = 10.dp

  /**
   * Default padding applied to the content in [GlowingButton]
   */
  val contentPadding = PaddingValues(16.dp)

  /**
   * Default padding applied to [GlowingButton]
   */
  val outerPadding = PaddingValues(16.dp)

  /**
   * The default min width applied to [GlowingButton]. Note that you can override it by applying
   * Modifier.widthIn directly on the button composable.
   */
  val MinWidth = 58.dp

  /**
   * The default min height applied to [GlowingButton]. Note that you can override it by applying
   * Modifier.heightIn directly on the button composable.
   */
  val MinHeight = 40.dp

  /**
   * Creates [GlowingButtonColors] that represents default colors used in [GlowingButton]
   *
   * @param containerColor color applied to the container when enabled
   * @param contentColor color applied to the content when enabled
   * @param containerGlowIntensity glow intensity applied to the container
   * @param glowColor color applied to the glow
   * @param disabledContainerColor color applied to the container when disabled
   * @param disabledContentColor color applied to the content when disabled
   */
  @Composable
  fun glowingButtonColors(
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    containerGlowIntensity: Float = 0f,
    glowColor: Color = containerColor,
    disabledContainerColor: Color = Color.LightGray,
    disabledContentColor: Color = Color.White,
  ) = GlowingButtonColors(
    containerColor = containerColor.brightness(containerGlowIntensity),
    contentColor = contentColor,
    glowColor = glowColor,
    disabledContainerColor = disabledContainerColor,
    disabledContentColor = disabledContentColor,
  )
}

/**
 * Represents the default color values used by [GlowingButton] in different states
 */
@Immutable
class GlowingButtonColors internal constructor(
  private val containerColor: Color,
  private val contentColor: Color,
  private val glowColor: Color,
  private val disabledContainerColor: Color,
  private val disabledContentColor: Color,
) {

  /**
   * Default container color
   */
  @Composable
  internal fun containerColor(enabled: Boolean): State<Color> {
    return rememberUpdatedState(if (enabled) containerColor else disabledContainerColor)
  }

  /**
   * Default content color
   */
  @Composable
  internal fun contentColor(enabled: Boolean): State<Color> {
    return rememberUpdatedState(if (enabled) contentColor else disabledContentColor)
  }

  /**
   * Default glow color and [Color.Transparent] to represent disabled state
   */
  @Composable
  internal fun glowColor(enabled: Boolean): State<Color> {
    return rememberUpdatedState(if (enabled) glowColor else Color.Transparent)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || other !is GlowingButtonColors) return false

    if (containerColor != other.containerColor) return false
    if (contentColor != other.contentColor) return false
    if (glowColor != other.glowColor) return false
    if (disabledContainerColor != other.disabledContainerColor) return false
    if (disabledContentColor != other.disabledContentColor) return false

    return true
  }

  override fun hashCode(): Int {
    var result = containerColor.hashCode()
    result = 31 * result + contentColor.hashCode()
    result = 31 * result + glowColor.hashCode()
    result = 31 * result + disabledContainerColor.hashCode()
    result = 31 * result + disabledContentColor.hashCode()
    return result
  }
}

/**
 * Control the brightness of the color
 *
 * @param amount brightness intensity of the color ranges from **-1f(darker)** to **1f(brightest)**
 */
fun Color.brightness(amount: Float = 0.1f): Color {
  val red = this.red
  val green = this.green
  val blue = this.blue
  val alpha = this.alpha
  val colorSpace = this.colorSpace

  val brightenedRed = (red * (1f + amount)).coerceIn(0f, 1f)
  val brightenedGreen = (green * (1f + amount)).coerceIn(0f, 1f)
  val brightenedBlue = (blue * (1f + amount)).coerceIn(0f, 1f)

  return Color(brightenedRed, brightenedGreen, brightenedBlue, alpha, colorSpace)
}

/**
 * Draws a **Canvas** behind the modified content giving it a glowing effect
 *
 * @param color color of the glowing shadow
 * @param borderRadius border radius of the glowing shadow
 * @param blurRadius glow radius of the shadow
 * @param offsetX X offset of the shadow
 * @param offsetY Y offset of the shadow
 * @param spread spread radius of the shadow
 */
fun Modifier.glowingShadow(
  color: Color,
  borderRadius: Dp = 0.dp,
  blurRadius: Dp = 0.dp,
  offsetX: Dp = 0.dp,
  offsetY: Dp = 0.dp,
  spread: Dp = 0.dp,
): Modifier {
  return this.drawBehind {
    this.drawIntoCanvas {
      val paint = Paint()
      val frameworkPaint = paint.asFrameworkPaint()
      val spreadPixel = spread.toPx()
      val leftPixel = (0f - spreadPixel) + offsetX.toPx()
      val topPixel = (0f - spreadPixel) + offsetY.toPx()
      val rightPixel = (this.size.width + spreadPixel)
      val bottomPixel = (this.size.height + spreadPixel)

      if (blurRadius != 0.dp) {
        frameworkPaint.maskFilter =
          (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
      }
      frameworkPaint.color = color.toArgb()
      it.drawRoundRect(
        left = leftPixel,
        top = topPixel,
        right = rightPixel,
        bottom = bottomPixel,
        radiusX = borderRadius.toPx(),
        radiusY = borderRadius.toPx(),
        paint = paint,
      )
    }
  }
}
