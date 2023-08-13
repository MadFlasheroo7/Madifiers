/*
 * Copyright 2023 Jayesh Seth
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
import pro.jayeshseth.madifiers.ui.theme.MadifiersTheme
import pro.jayeshseth.windowUtils.NavigationBar
import pro.jayeshseth.windowUtils.ScreenDimensions
import pro.jayeshseth.windowUtils.StatusBars
import pro.jayeshseth.windowUtils.isGestureNavigation
import pro.jayeshseth.windowUtils.isInLandscapeMode

@Composable
fun WindowInfoScreen() {
  Column {
    InfoTemplate(
      title = "Screen Height x Width - Dp",
      info = "${ScreenDimensions().heightInDp} x ${ScreenDimensions().widthInDp}",
    )
    InfoTemplate(
      title = "Screen Height x Width - Px",
      info = "${ScreenDimensions().heightInPx} x ${ScreenDimensions().widthInPx}",
    )
    InfoTemplate(
      title = "Status Bar Size - Dp & Px",
      info = "Dp = ${StatusBars().heightInDp}\n" +
        "Px = ${StatusBars().heightInPx}",
    )
    InfoTemplate(
      title = "Navigation Bar Size - Dp & Px",
      info = "Dp = ${NavigationBar().heightInDp}\n" +
        "Px = ${NavigationBar().heightInPx}",
    )
    InfoTemplate(
      title = "is in landscape mode?",
      info = isInLandscapeMode().toString(),
    )
    InfoTemplate(
      title = "is using gesture navigation?",
      info = isGestureNavigation().toString(),
    )
  }
}

@Composable
fun InfoTemplate(
  title: String,
  info: String,
  modifier: Modifier = Modifier,
) {
  Card(modifier = Modifier.padding(8.dp)) {
    Column(modifier = modifier.fillMaxWidth().padding(8.dp)) {
      Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
          .fillMaxWidth()
          .padding(4.dp),
      )
      Text(
        text = info,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp),
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
