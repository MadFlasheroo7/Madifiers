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

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.jayeshseth.bionicText.BionicText
import pro.jayeshseth.madifiers.R
import pro.jayeshseth.madifiers.ui.composables.SliderTemplate

private val fontWeightList = listOf(
    FontWeight.W900,
    FontWeight.W800,
    FontWeight.W700,
    FontWeight.W600,
    FontWeight.W500,
    FontWeight.W400,
    FontWeight.W300,
    FontWeight.W200,
    FontWeight.W100,
)

private val textAlignList = listOf(
    TextAlign.Left,
    TextAlign.Center,
    TextAlign.Right,
)

@Composable
fun BionicTextScreen() {
    var fixationOpacity by remember { mutableFloatStateOf(1f) }
    var fixationFontWeight by remember { mutableFloatStateOf(0f) }
    var fixationFontSize by remember { mutableFloatStateOf(35f) }

    var nonFixationOpacity by remember { mutableFloatStateOf(1f) }
    var nonFixationFontWeight by remember { mutableFloatStateOf(0f) }
    var nonFixationFontSize by remember { mutableFloatStateOf(35f) }

    var alignment by remember { mutableFloatStateOf(0f) }
    val rememberScroll = rememberScrollState()

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        BionicTextViewer(
            textAlign = textAlignList[alignment.toInt()],
            fixationSize = fixationFontSize.sp,
            fixationOpacity = fixationOpacity,
            fixationBoldness = fontWeightList[fixationFontWeight.toInt()],
            nonFixationSize = nonFixationFontSize.sp,
            nonFixationOpacity = nonFixationOpacity,
            nonFixationBoldness = fontWeightList.reversed()[nonFixationFontWeight.toInt()],
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(25.dp),
            modifier = Modifier
                .padding(top = 16.dp)
                .animateContentSize()
                .verticalScroll(rememberScroll),
        ) {
            SliderTemplate(
                title = "Alignment: ${textAlignList[alignment.toInt()]}",
                value = alignment,
                onValueChange = { alignment = it },
                valueRange = 0f..textAlignList.size.toFloat() - 1,
                steps = textAlignList.size - 2,
            )

            SliderTemplate(
                title = "Fixation Opacity: $fixationOpacity",
                value = fixationOpacity,
                onValueChange = { fixationOpacity = it },
                valueRange = 0f..1f,
                steps = 10,
            )

            SliderTemplate(
                title = "Fixation FontSize: ${fixationFontSize.sp}",
                value = fixationFontSize,
                onValueChange = { fixationFontSize = it },
                valueRange = 0f..50f,
                steps = 10,
            )

            SliderTemplate(
                title = "Fixation FontWeight: ${fontWeightList[fixationFontWeight.toInt()].weight}",
                value = fixationFontWeight,
                onValueChange = { fixationFontWeight = it },
                valueRange = 0f..fontWeightList.size.toFloat() - 1,
                steps = fontWeightList.size - 2,
            )
            SliderTemplate(
                title = "NonFixation Opacity: $nonFixationOpacity",
                value = nonFixationOpacity,
                onValueChange = { nonFixationOpacity = it },
                valueRange = 0f..1f,
                steps = 10,
            )

            SliderTemplate(
                title = "NonFixation FontSize: ${nonFixationFontSize.sp}",
                value = nonFixationFontSize,
                onValueChange = { nonFixationFontSize = it },
                valueRange = 0f..50f,
                steps = 10,
            )

            SliderTemplate(
                title = "NonFixation FontWeight: ${fontWeightList.reversed()[nonFixationFontWeight.toInt()].weight}",
                value = nonFixationFontWeight,
                onValueChange = { nonFixationFontWeight = it },
                valueRange = 0f..fontWeightList.size.toFloat() - 1,
                steps = fontWeightList.size - 2,
            )
        }
    }
}

@Composable
fun BionicTextViewer(
    textAlign: TextAlign,
    fixationOpacity: Float,
    fixationBoldness: FontWeight,
    nonFixationOpacity: Float,
    nonFixationBoldness: FontWeight,
    modifier: Modifier = Modifier,
    highlightFixation: Boolean = false,
    fixationSize: TextUnit = 35.sp,
    nonFixationSize: TextUnit = 35.sp,
) {
    val rememberScroll = rememberScrollState()
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
    ) {
        val color = LocalContentColor.current

        Box(modifier = Modifier.verticalScroll(rememberScroll)) {
            BionicText(
                text = stringResource(R.string.bionic_text_sample),
                textAlign = textAlign,
                modifier = Modifier.padding(16.dp),
                fixationStyle = SpanStyle(
                    color = color.copy(alpha = fixationOpacity),
                    fontWeight = fixationBoldness,
                    fontSize = fixationSize,
                    background = if (highlightFixation) Color.Yellow.copy(alpha = 0.1f) else Color.Unspecified,
                ),
                nonFixationStyle = SpanStyle(
                    color = color.copy(alpha = nonFixationOpacity),
                    fontWeight = nonFixationBoldness,
                    fontSize = nonFixationSize,
                ),
            )
        }
    }
}