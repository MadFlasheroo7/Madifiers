package `in`.realogs.madifiers.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.realogs.madifiers.ui.theme.MadifiersTheme
import `in`.realogs.windowUtils.NavigationBar
import `in`.realogs.windowUtils.ScreenDimensions
import `in`.realogs.windowUtils.StatusBars
import `in`.realogs.windowUtils.isGestureNavigation
import `in`.realogs.windowUtils.isInLandscapeMode

@Composable
fun WindowInfoScreen() {
    Column {
        InfoTemplate(
            title = "Screen Height x Width - Dp",
            info = "${ScreenDimensions().heightInDp} x ${ScreenDimensions().widthInDp}"
        )
        InfoTemplate(
            title = "Screen Height x Width - Px",
            info = "${ScreenDimensions().heightInPx} x ${ScreenDimensions().widthInPx}"
        )
        InfoTemplate(
            title = "Status Bar Size - Dp & Px",
            info = "Dp = ${StatusBars().heightInDp}\n" +
                    "Px = ${StatusBars().heightInPx}"
        )
        InfoTemplate(
            title = "Navigation Bar Size - Dp & Px",
            info = "Dp = ${NavigationBar().heightInDp}\n" +
                    "Px = ${NavigationBar().heightInPx}"
        )
        InfoTemplate(
            title = "is in landscape mode?",
            info = isInLandscapeMode().toString()
        )
        InfoTemplate(
            title = "is using gesture navigation?",
            info = isGestureNavigation().toString()
        )
    }
}

@Composable
fun InfoTemplate(
    title: String,
    info: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = modifier.fillMaxWidth().padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
            Text(
                text = info,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewInfoTemplate() {
    MadifiersTheme {
        WindowInfoScreen()
    }
}