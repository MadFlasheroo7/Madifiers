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

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.jayeshseth.animatetextunitasstate.animateTextUnitAsState
import pro.jayeshseth.madifiers.ui.theme.MadifiersTheme

@Composable
fun AnimateTextUnitScreen() {
  var animateTween by remember { mutableStateOf(true) }
  var animateSpring by remember { mutableStateOf(true) }

  val textSizeTween by animateTextUnitAsState(
    targetValue = if (animateTween) 30.sp else 16.sp,
    animationSpec = tween(
      durationMillis = 1000,
      easing = LinearEasing,
    ),
  )
  val textSizeSpring by animateTextUnitAsState(
    targetValue = if (animateSpring) 30.sp else 16.sp,
    animationSpec = spring(
      dampingRatio = Spring.DampingRatioHighBouncy,
      stiffness = Spring.StiffnessLow,
    ),
  )

  Column {
    TextCard(
      text = "Animate Text - tween",
      onClick = { animateTween = !animateTween },
      fontSize = textSizeTween,
    )
    TextCard(
      text = "Animate Text - spring",
      onClick = { animateSpring = !animateSpring },
      fontSize = textSizeSpring,
    )
  }
}

@Composable
fun TextCard(
  text: String,
  fontSize: TextUnit = 16.sp,
  onClick: () -> Unit,
) {
  Card(modifier = Modifier.padding(8.dp)) {
    Column(
      Modifier
        .fillMaxWidth()
        .padding(8.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Text(
        text = text,
        fontSize = fontSize,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(20.dp),
      )
      Button(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Change Size")
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextCard() {
  TextCard(text = "Text Size", onClick = {})
}

@Preview
@Composable
fun PreviewAnimateTextUnitScreen() {
  MadifiersTheme {
    AnimateTextUnitScreen()
  }
}
