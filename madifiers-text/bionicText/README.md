# Bionic Text
![Maven Central](https://img.shields.io/maven-central/v/pro.jayeshseth.madifiers/bionicText?style=flat-square)

Bionic Text or Bionic Reading means creating “artificial fixation points” within a text by bolding
the first part of each word for our eyes to jump between, “guiding the eyes” across the page and
letting the brain complete the rest of the word on its own rather than having to stop and see the
entirety of every word on a page. This Bionic text is heavily inspired by [Bionic Reading](https://bionic-reading.com/)

# Setup
add maven central repo to your root `settings.gradle.kts`
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
```
add the dependency to your module's `build.gradle.kts`
```kotlin
dependencies {
    implementation("pro.jayeshseth.madifiers:bionicText:<version>")
}
```

# Sample
```kotlin
BionicText(
    text = "...",
    textAlign = ...,
    modifier = ...,
    fixationStyle = SpanStyle(),
    nonFixationStyle = SpanStyle()
    ...
)
```
Check Out Working Sample [here](../../app/src/main/java/pro/jayeshseth/madifiers/ui/screens/BionicText.kt)

# Video
https://github.com/MadFlasheroo7/Madifiers/assets/57130085/16dea78a-8597-4ffd-81c0-726a6425f405

