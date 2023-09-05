![banner art](/art/banner%20art%20-%20madifiers.png)
<p align="center">
    <a href="https://jetc.dev/issues/180.html"><img src="https://img.shields.io/badge/As_Seen_In-jetc.dev_Newsletter_Issue_%23180-blue?logo=Jetpack+Compose&amp;logoColor=white" alt="As Seen In - jetc.dev Newsletter Issue #180"></a>
</p>

# What is Madifiers?
Madifiers are a bunch of pre-made modifiers *(get it?)*, composables, extension functions and so on with an aim to make development with Jetpack Compose easier and more straightforward.

# Libraries
## [Bionic Text](/madifiers-text/bionicText) - ![Maven Central](https://img.shields.io/maven-central/v/pro.jayeshseth.madifiers/windowUtils?style=flat-square)
Applies [bionic reading](https://bionic-reading.com/) effect to text.

## [AnimateTextUnitAsState](/madifiers-text/animateTextUnitAsState) - ![Maven Central](https://img.shields.io/maven-central/v/pro.jayeshseth.madifiers/animateTextUnitAsState?style=flat-square)
Interpolates text units like `sp` and `em` to the provided target value.

## [Window Util](/madifiers-window/windowUtils) - ![Maven Central](https://img.shields.io/maven-central/v/pro.jayeshseth.madifiers/windowUtils?style=flat-square)
Window utils to get usable screen height, width and more in `dp` and `px`.

# Project Structure
```
Madifiers                         # Root Project
├── app                           # Sample App showcasing library usage
├── art                           # contains screenshots and videos of the library usage 
├── build-logic                   # contains conventional plugins to mitigate code duplication
├── buildSrc                      # used to manage versioning of modules
├── scripts                       # contains scripts to publish modules to maven central
│
├── madifiers-example             # an example module for developers to help contribute new modules
├── madifiers-text                # directory for all text or string related modules 
│   ├── animateTextUnitAsState    # animates text units like sp and em to the provided target value
│   ├── bionicText                # applies bionic reading affect on text 
│   ├── extensions                # TODO
│
├── madifiers-window              # directory for window related modules 
│   ├── windowUtils               # window utils to get usable screen height, width and more in dp and px 
```

# Blog 
Learn more about how Madifiers came to life, create your own single or multi-module library for Android, and publish it effortlessly to Maven Central!
[here](https://blog.realogs.in/build-and-publish-multi-module-android-library-to-maven-central/)

# How & Why "Madifiers"?
In June of 2021, while learning about modifiers in Jetpack Compose, I had a thought -- the 
term "modifiers" could be playfully referred to as **"madifiers"**, which correlates with my internet alias.
This sparked an idea to create a library for Jetpack Compose, which I would name **Madifiers**. After discovering
libraries like [Super Extension](https://github.com/AbhishekDoshi26/super_extensions) by Abhishek Doshi and 
[VelocityX](https://velocityx.dev/) by Pawan Kumar, I was inspired to create a library that would include
a collection of modifiers, composables, and extension functions, and help make development with Jetpack Compose
easier and more straightforward. Thus, Madifiers was born.

# Contribution
Learn more about contributing [here](/CONTRIBUTING.md).

# License
```
Copyright 2023 Jayesh Seth

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
