# Window Utils 
Window Utils contains many useful composable functions to provide useful window info like
screen dimensions and system bar size in `Dp` and `Px` and more 

You can learn more about Dimensions [here](https://developer.android.com/guide/topics/resources/more-resources#Dimension)

- [ScreenDimensions](https://github.com/MadFlasheroo7/Madifiers/blob/Main/window/windowUtils/src/main/java/in/realogs/windowUtils/WindowInfo.kt#L19)
- [StatusBars](https://github.com/MadFlasheroo7/Madifiers/blob/Main/window/windowUtils/src/main/java/in/realogs/windowUtils/WindowInfo.kt#L38)
- [NavigationBar](https://github.com/MadFlasheroo7/Madifiers/blob/Main/window/windowUtils/src/main/java/in/realogs/windowUtils/WindowInfo.kt#L50)
- [isGestureNavigation](https://github.com/MadFlasheroo7/Madifiers/blob/Main/window/windowUtils/src/main/java/in/realogs/windowUtils/WindowInfo.kt#L62)
- [isInLandscapeMode](https://github.com/MadFlasheroo7/Madifiers/blob/Main/window/windowUtils/src/main/java/in/realogs/windowUtils/WindowInfo.kt#L72)

# Screen Dimensions
**ScreenDimensions** returns the screen height and width in `Dp` and `Px`

# Status Bars
**Status Bars** returns the status bar height in `Dp` and `Px`
``` kotlin
val statusBarSize = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
```
```
+----------------+
|   Top          |
|   Padding      |
+----------------+
|                |
|     Content    |
|                |
+----------------+
```

# Navigation Bar
**NavigationBar** returns the navigation bar height in `Dp` and `Px`
```kotlin
val navigationBarSize = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()
```
```
+----------------+
|                |
|     Content    |
|                |
+----------------+
|   Bottom       |
|   Padding      |
+----------------+
```

# isGestureNavigation
**isGestureNavigation** is a hacky way to check if device is using gesture navigation bar or 
3 button nav bar

# isInLandscapeMode
**isInLandscapeMode** checks if device is in landscape orientation

# Screenshots
```kotlin
    TODO("Add Screenshot")
```