package `in`.realogs.bionicText

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

/**
 * Bionic Text creates a fixation point within a text by bolding
 * the first part of each word for our eyes to jump between. It applies bold style to fixated part of
 * the text.
 *
 * This Bionic text is inspired by [Bionic Reading](https://bionic-reading.com/)
 *
 * @param text the text to be displayed
 * @param modifier the [Modifier] to be applied to this layout node
 * @param fontSize the size of glyphs to use when painting the text. See [TextStyle.fontSize].
 * @param fontFamily the font family to be used when rendering the text. See [TextStyle.fontFamily].
 * @param color [Color] to apply to the text. If [Color.Unspecified], and [style] has no color set,
 * this will be [LocalContentColor].
 * @param style style configuration for the text such as color, font, line height etc.
 * @param textAlign the alignment of the text within the lines of the paragraph.
 * See [TextStyle.textAlign].
 * @param lineHeight line height for the [Paragraph] in [TextUnit] unit, e.g. SP or EM.
 * See [TextStyle.lineHeight].
 * @param softWrap whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param overflow how visual overflow should be handled.
 * @param maxLines An optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. It is required that 1 <= [minLines] <= [maxLines].
 * @param minLines The minimum height in terms of minimum number of visible lines. It is required
 * that 1 <= [minLines] <= [maxLines].
 * @param inlineContent a map storing composables that replaces certain ranges of the text, used to
 * insert composables into text layout. See [InlineTextContent].
 * @param onTextLayout callback that is executed when a new text layout is calculated. A
 * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 * text, baselines and other details. The callback can be used to add additional decoration or
 * functionality to the text. For example, to draw selection around the text.
 */
@Composable
fun BionicText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontFamily: FontFamily? = null,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    inlineContent: Map<String, InlineTextContent> = mapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    // TODO(improve fixation logic)
    // TODO(Add saccade)
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
        textAlign = textAlign,
        lineHeight = lineHeight,
        softWrap = softWrap,
        overflow = overflow,
        maxLines = maxLines,
        minLines = minLines,
        inlineContent = inlineContent,
        onTextLayout = onTextLayout
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBionicText() {
    val string = "Animations can be a powerful tool for creating engaging and interactive user " +
            "interfaces. With Jetpack Compose, creating animations has become easier than ever. In " +
            "this blog post, we'll walk through the basics of using animations in Jetpack Compose " +
            "and explore some examples to get you started."
    BionicText(
        text = string
    )
}

