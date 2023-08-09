# Animate Text Unit

**AnimateTextUnit** animates text unit values like `sp` and `em`. When the provided targetValue is 
changed, the animation will run automatically. If there is already an animation in-flight when 
targetValue changes, the on-going animation will adjust course to animate towards the new target value.

# Sample
```kotlin
val fontSize by animateTextUnitAsState (
        targetValue =  ...,
        animationSpec = tween(...),
        label = "...",
        finishedListener = {}
)
```
Check Out Working Sample [here](../../sample/src/main/java/in/realogs/madifiers/ui/screens/AnimateTextUnit.kt)

# Video
https://github.com/MadFlasheroo7/Madifiers/assets/57130085/21630674-6ee0-42cb-a981-7bad0408d0f6
