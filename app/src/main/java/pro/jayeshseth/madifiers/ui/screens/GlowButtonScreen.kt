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
package pro.jayeshseth.madifiers.ui.screens

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import pro.jayeshseth.buttons.GlowingButton
import pro.jayeshseth.buttons.GlowingButtonDefaults
import pro.jayeshseth.madifiers.ui.composables.SliderTemplate

@Composable
fun GlowButtonScreen() {
    var spreadRadius by remember { mutableFloatStateOf(GlowingButtonDefaults.spreadRadius.value) }
    var shape by remember { mutableFloatStateOf(50.dp.value) }
    var glowIntensity by remember { mutableFloatStateOf(GlowingButtonDefaults.glowIntensity) }
    var glowRadius by remember { mutableFloatStateOf(GlowingButtonDefaults.glowRadius.value) }
    val enabled = remember { mutableStateOf(true) }
    var glowBorderRadius by remember { mutableFloatStateOf(GlowingButtonDefaults.glowBorderRadius.value) }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
        ) {
            GlowingButton(
                enabled = enabled.value,
                glowIntensity = glowIntensity,
                spreadRadius = spreadRadius.dp,
                glowRadius = glowRadius.dp,
                glowBorderRadius = glowBorderRadius.dp,
                shape = RoundedCornerShape(shape.dp),
                spreadOffset = Offset(offsetX, offsetY),
                onClick = {
                    Toast.makeText(context, "ACTION: Click", Toast.LENGTH_SHORT).show()
                },
                onLongClick = {
                    Toast.makeText(context, "ACTION: Long Click", Toast.LENGTH_SHORT).show()
                },
                onDoubleTap = {
                    Toast.makeText(context, "ACTION: Double Tap", Toast.LENGTH_SHORT).show()
                },
            ) {
                Text("Madifiers")
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(25.dp),
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .animateContentSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Enabled",
                    style = MaterialTheme.typography.titleLarge,
                )
                Switch(
                    checked = enabled.value,
                    onCheckedChange = { enabled.value = !enabled.value },
                )
            }
            SliderTemplate(
                title = "Spread Radius: ${spreadRadius.dp}",
                value = spreadRadius,
                onValueChange = { spreadRadius = it },
                valueRange = 0f..100f,
                steps = 0,
            )
            SliderTemplate(
                title = "Corner Radius: ${shape.dp}",
                value = shape,
                onValueChange = { shape = it },
                valueRange = 0f..50f,
                steps = 0,
            )
            SliderTemplate(
                title = "Glow Intensity: ${glowIntensity}f",
                value = glowIntensity,
                onValueChange = { glowIntensity = it },
                valueRange = -1f..1f,
                steps = 0,
            )
            SliderTemplate(
                title = "Glow Radius: ${glowRadius.dp}",
                value = glowRadius,
                onValueChange = { glowRadius = it },
                valueRange = 0f..100f,
                steps = 10,
            )
            SliderTemplate(
                title = "Glow Border Radius: ${glowBorderRadius.dp}",
                value = glowBorderRadius,
                onValueChange = { glowBorderRadius = it },
                valueRange = 0f..100f,
                steps = 10,
            )
            SliderTemplate(
                title = "Glow Offset X: ${offsetX}f",
                value = offsetX,
                onValueChange = { offsetX = it },
                valueRange = 0f..100f,
                steps = 10,
            )
            SliderTemplate(
                title = "Glow Offset Y: ${offsetY}f",
                value = offsetY,
                onValueChange = { offsetY = it },
                valueRange = 0f..100f,
                steps = 10,
            )
        }
    }
}