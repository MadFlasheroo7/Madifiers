package `in`.realogs.funtext

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Composable
fun BionicText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontFamily: FontFamily? = null,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    val words = text.split(" ")
    val formattedWord = buildAnnotatedString {
        words.forEach { word ->
            val fixation = word.length / 2

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(word.take(fixation))
            }

            append(word.drop(fixation) + " ")
        }
    }

    Text(
        text = formattedWord,
        modifier = modifier,
        fontSize = fontSize,
        fontFamily = fontFamily,
        color = color,
        style = style,
        softWrap = softWrap,
        overflow = overflow,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBionicText() {
    val string = "Animations can be a powerful tool for creating engaging and interactive user interfaces. With Jetpack Compose, creating animations has become easier than ever. In this blog post, we'll walk through the basics of using animations in Jetpack Compose and explore some examples to get you started."
    BionicText(
        text = string
    )
}

