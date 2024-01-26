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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import pro.jayeshseth.buttons.GlowingButton
import pro.jayeshseth.buttons.GlowingButtonDefaults
import pro.jayeshseth.madifiers.ui.composables.SliderTemplate

@Composable
fun GlowButtonScreen() {
    var spreadRadius by remember { mutableFloatStateOf(GlowingButtonDefaults.spreadRadius.value) }
    var shape by remember { mutableFloatStateOf(50.dp.value) }
    var glowIntensity by remember { mutableFloatStateOf(GlowingButtonDefaults.glowIntensity) }
    var buttonGlowIntensity by remember { mutableFloatStateOf(0f) }
    var glowRadius by remember { mutableFloatStateOf(GlowingButtonDefaults.glowRadius.value) }
    val enabled = remember { mutableStateOf(true) }
    var glowBorderRadius by remember { mutableFloatStateOf(GlowingButtonDefaults.glowBorderRadius.value) }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    val controller = rememberColorPickerController()
    val defaultContainerColor = MaterialTheme.colorScheme.primary
    val defaultContentColor = MaterialTheme.colorScheme.onPrimary
    val defaultGlowColor = MaterialTheme.colorScheme.primary

    val containerColor = remember { mutableStateOf(defaultContainerColor) }
    val contentColor = remember { mutableStateOf(defaultContentColor) }
    val glowColor = remember { mutableStateOf(defaultGlowColor) }
    val changeContainerColor = remember { mutableStateOf(false) }
    val changeContentColor = remember { mutableStateOf(false) }
    val changeGlowColor = remember { mutableStateOf(false) }
    val showColorPicker = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        if (showColorPicker.value) {
            Dialog(
                onDismissRequest = { showColorPicker.value = !showColorPicker.value },
            ) {
                Column {
                    HsvColorPicker(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(450.dp)
                            .padding(10.dp),
                        controller = controller,
                        onColorChanged = { colorEnvelope ->
                            if (changeContainerColor.value) containerColor.value =
                                colorEnvelope.color
                            if (changeContentColor.value) contentColor.value = colorEnvelope.color
                            if (changeGlowColor.value) glowColor.value = colorEnvelope.color
                        },
                    )
                    BrightnessSlider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(35.dp)
                            .align(Alignment.CenterHorizontally),
                        controller = controller,
                    )
                }
            }
        }
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
                colors = GlowingButtonDefaults.glowingButtonColors(
                    containerColor = containerColor.value,
                    containerGlowIntensity = buttonGlowIntensity,
                    contentColor = contentColor.value,
                    glowColor = glowColor.value,
                ),
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
            ColorPicker(
                title = "Container Color",
                color = containerColor.value,
                onClick = {
                    showColorPicker.value = !showColorPicker.value
                    changeContainerColor.value = true
                    changeContentColor.value = false
                    changeGlowColor.value = false
                },
            )
            ColorPicker(
                title = "Content Color", color = contentColor.value,
                onClick = {
                    showColorPicker.value = !showColorPicker.value
                    changeContentColor.value = true
                    changeContainerColor.value = false
                    changeGlowColor.value = false
                },
            )
            ColorPicker(
                title = "Glow Color", color = glowColor.value,
                onClick = {
                    showColorPicker.value = !showColorPicker.value
                    changeGlowColor.value = true
                    changeContainerColor.value = false
                    changeContentColor.value = false
                },
            )
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
                title = "Button Glow Intensity: ${buttonGlowIntensity}f",
                value = buttonGlowIntensity,
                onValueChange = { buttonGlowIntensity = it },
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

@Composable
private fun ColorPicker(
    title: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = "$title :",
            style = MaterialTheme.typography.titleLarge,
        )
        Box(
            modifier = Modifier
                .background(color)
                .size(25.dp)
                .clickable(onClick = onClick),
        )
    }
}