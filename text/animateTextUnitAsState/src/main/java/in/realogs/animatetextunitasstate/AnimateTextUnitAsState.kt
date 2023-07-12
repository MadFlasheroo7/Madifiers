package `in`.realogs.animatetextunitasstate

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * A simple animation function to animate text units like [sp] or [em].
 *
 * [animateTextUnitAsState] returns a [State] object. The value of the state object will continuously
 * be updated by the animation until the animation finishes.
 *
 * @param targetValue TargetValue of animation accepts [sp] or [em]
 * @param animationSpec The animation spec stores the specification of animation like type and duration.
 *                    By default it uses simple tween with linear easing.
 * @param label An optional label to differentiate from other animations in Android Studio.
 * @param finishedListener An optional end listener to notified when the animation is finished
 * @return A [State] object, the value of which is updated by animation.
 */
@Composable
fun animateTextUnitAsState(
    targetValue: TextUnit,
    animationSpec: AnimationSpec<TextUnit> = tween(easing = LinearEasing),
    label: String = "TextUnit Animation",
    finishedListener: ((TextUnit) -> Unit)? = null
): State<TextUnit> {
    return animateValueAsState(
        targetValue = targetValue,
        typeConverter = TwoWayConverter(
            convertToVector = { AnimationVector1D(it.value) },
            convertFromVector = { it.value.sp }
        ),
        animationSpec = animationSpec,
        label = label,
        finishedListener = finishedListener
    )
}