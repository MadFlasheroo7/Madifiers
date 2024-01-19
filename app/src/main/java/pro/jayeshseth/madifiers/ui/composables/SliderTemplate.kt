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
package pro.jayeshseth.madifiers.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SliderTemplate(
    title: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    steps: Int,
    modifier: Modifier = Modifier,
    sliderModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textColor: Color = Color.Unspecified,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            modifier = textModifier,
            style = MaterialTheme.typography.titleLarge,
            color = textColor,
        )
        Slider(
            value = value,
            onValueChange = onValueChange,
            modifier = sliderModifier,
            valueRange = valueRange,
            steps = steps,
        )
    }
}