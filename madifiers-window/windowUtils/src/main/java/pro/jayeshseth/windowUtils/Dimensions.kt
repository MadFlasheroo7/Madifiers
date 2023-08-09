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
package pro.jayeshseth.windowUtils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

public data class Dimensions(
  val heightInDp: Dp = 0.dp,
  val widthInDp: Dp = 0.dp,
  val heightInPx: Int = 0,
  val widthInPx: Int = 0,
)
