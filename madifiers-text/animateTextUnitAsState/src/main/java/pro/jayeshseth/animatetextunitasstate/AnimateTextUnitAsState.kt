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
package pro.jayeshseth.animatetextunitasstate

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
  finishedListener: ((TextUnit) -> Unit)? = null,
): State<TextUnit> {
  return animateValueAsState(
    targetValue = targetValue,
    typeConverter = TwoWayConverter(
      convertToVector = { AnimationVector1D(it.value) },
      convertFromVector = { it.value.sp },
    ),
    animationSpec = animationSpec,
    label = label,
    finishedListener = finishedListener,
  )
} // Make Functions Public due to Xexplicit Api mode
