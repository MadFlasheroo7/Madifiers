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

import  android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pro.jayeshseth.buttons.BackButton
import pro.jayeshseth.buttons.ForwardButton
import pro.jayeshseth.buttons.GlowingButton

@Composable
fun ButtonsScreen(navigateToGlow: () -> Unit) {
    val context = LocalContext.current
    Column {
        Text(
            text = "Directional Button",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 12.dp),
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            BackButton(onClick = { Toast.makeText(context, "Back", Toast.LENGTH_SHORT).show() })
            BackButton(
                onClick = { Toast.makeText(context, "Up", Toast.LENGTH_SHORT).show() },
                modifier = Modifier.rotate(90f),
            )
            BackButton(
                onClick = { Toast.makeText(context, "Down", Toast.LENGTH_SHORT).show() },
                modifier = Modifier.rotate(-90f),
            )
            ForwardButton(
                onClick = {
                    Toast.makeText(context, "Forward", Toast.LENGTH_SHORT).show()
                },
            )
        }

        Text(
            text = "Glow Button",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 12.dp),
        )
        GlowingButton(
            onClick = navigateToGlow,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
        ) {
            Text("✨✨ Customize GLOW ✨✨")
        }
    }
}