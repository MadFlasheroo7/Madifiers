package `in`.realogs.madifiers.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import `in`.realogs.bionicText.BionicText
import `in`.realogs.madifiers.R

val fontWeightList = listOf(
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

val textAlignList = listOf(
    TextAlign.Left,
    TextAlign.Center,
    TextAlign.Right
)

@Composable
fun BionicTextScreen() {
    var fixationOpacity by remember { mutableStateOf(1f) }
    var fixationFontWeight by remember { mutableStateOf(0f) }
    var fixationFontSize by remember { mutableStateOf(35f) }

    var nonFixationOpacity by remember { mutableStateOf(1f) }
    var nonFixationFontWeight by remember { mutableStateOf(0f) }
    var nonFixationFontSize by remember { mutableStateOf(35f) }

    var alignment by remember { mutableStateOf(0f) }
    val rememberScroll = rememberScrollState()

    Column {
        BionicTextViewer(
            textAlign = textAlignList[alignment.toInt()],
            modifier = Modifier.padding(16.dp),
            fixationSize = fixationFontSize.sp,
            fixationOpacity = fixationOpacity,
            fixationBoldness = fontWeightList[fixationFontWeight.toInt()],
            nonFixationSize = nonFixationFontSize.sp,
            nonFixationOpacity = nonFixationOpacity,
            nonFixationBoldness = fontWeightList.reversed()[nonFixationFontWeight.toInt()] )

        Column(modifier = Modifier
            .verticalScroll(rememberScroll)
            .padding(start = 20.dp, bottom = 25.dp, end = 20.dp)) {

            SliderTemplate(
                title = "Alignment: ${textAlignList[alignment.toInt()]}",
                value = alignment,
                onValueChange = { alignment = it },
                valueRange = 0f..textAlignList.size.toFloat() - 1,
                steps = textAlignList.size - 2 )

            SliderTemplate(
                title = "Fixation Opacity: $fixationOpacity",
                value = fixationOpacity,
                onValueChange = { fixationOpacity = it },
                valueRange = 0f..1f,
                steps = 10 )

            SliderTemplate(
                title = "Fixation FontSize: ${fixationFontSize.sp}",
                value = fixationFontSize,
                onValueChange = { fixationFontSize = it },
                valueRange = 0f..50f,
                steps = 10 )

            SliderTemplate(
                title = "Fixation FontWeight: ${fontWeightList[fixationFontWeight.toInt()].weight}",
                value = fixationFontWeight,
                onValueChange = { fixationFontWeight = it },
                valueRange = 0f..fontWeightList.size.toFloat() - 1,
                steps = fontWeightList.size - 2
            )
            SliderTemplate(
                title = "NonFixation Opacity: $nonFixationOpacity",
                value = nonFixationOpacity,
                onValueChange = { nonFixationOpacity = it },
                valueRange = 0f..1f,
                steps = 10 )

            SliderTemplate(
                title = "NonFixation FontSize: ${nonFixationFontSize.sp}",
                value = nonFixationFontSize,
                onValueChange = { nonFixationFontSize = it },
                valueRange = 0f..50f,
                steps = 10 )

            SliderTemplate(
                title = "NonFixation FontWeight: ${fontWeightList.reversed()[nonFixationFontWeight.toInt()].weight}",
                value = nonFixationFontWeight,
                onValueChange = { nonFixationFontWeight = it },
                valueRange = 0f..fontWeightList.size.toFloat() - 1,
                steps = fontWeightList.size - 2 )
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
    nonFixationSize: TextUnit = 35.sp
) {
    val rememberScroll = rememberScrollState()
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        val color = LocalContentColor.current

        Box(modifier = Modifier.verticalScroll(rememberScroll)) {
            BionicText(
                text = stringResource(id = R.string.bionic_text_sample),
                textAlign = textAlign,
                modifier = Modifier.padding(16.dp),
                fixationStyle = SpanStyle(
                    color = color.copy(alpha = fixationOpacity),
                    fontWeight = fixationBoldness,
                    fontSize = fixationSize,
                    background = if (highlightFixation) Color.Yellow.copy(alpha = 0.1f) else Color.Unspecified
                ),
                nonFixationStyle = SpanStyle(
                    color = color.copy(alpha = nonFixationOpacity),
                    fontWeight = nonFixationBoldness,
                    fontSize = nonFixationSize
                )
            )
        }
    }
}

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
) {
    Column(
        modifier = modifier
            .padding(18.dp)
    ) {
        Text(
            text = title,
            modifier = textModifier,
            style = MaterialTheme.typography.titleLarge
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