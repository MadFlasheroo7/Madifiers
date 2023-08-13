![banner art](/art/banner%20art%20-%20madifiers.png)

# What is *Madifiers*?
Madifiers is bunch of pre-made composable, modifiers, extension functions etc...
Basically Anything and everything to make jetpack compose development easy and straight forward

# Libraries
## [Bionic Text](/madifiers-text/bionicText) - ![Maven Central](https://img.shields.io/maven-central/v/pro.jayeshseth.madifiers/windowUtils?style=flat-square)
applies bionic reading affect on text

## [AnimateTextUnitAsState](/madifiers-text/animateTextUnitAsState) - ![Maven Central](https://img.shields.io/maven-central/v/pro.jayeshseth.madifiers/animateTextUnitAsState?style=flat-square)
animates text units like `sp` and `em` to the provided target value

## [Window Util](/madifiers-window/windowUtils) - ![Maven Central](https://img.shields.io/maven-central/v/pro.jayeshseth.madifiers/windowUtils?style=flat-square)
window utils to get usable screen height, width and more in `dp` and `px`

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
You can check out how madifiers came to life and make your own single or multi module library
for android and publish it to maven central here(coming soon)

# How & Why "Madifiers"?
On **June 5th, 2021** while learning about "modifiers" in jetpack compose, I had a thought that the 
term "modifiers" could be playfully referred to as **"madifiers"**. This sparked an idea to create a
library for jetpack compose, which i would name **"Madifiers"**. After discovering libraries like
[Super Extension](https://github.com/AbhishekDoshi26/super_extensions) by Abhishek Doshi and 
[VelocityX](https://velocityx.dev/) by pawan kumar, I was inspired to create a library that would include
a collection of modifiers, extensions and composables which makes jetpack compose development easy and 
straight forward. Thus, Madifiers was born.

# Contribution
Learn about contribution [here](/CONTRIBUTING.md).

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