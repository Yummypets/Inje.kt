# Inje.kt
[![Language: Kotlin](https://img.shields.io/badge/language-Kotlin-7963FE.svg?style=flat)](https://kotlinlang.org)
![Platform: Android 8+](https://img.shields.io/badge/platform-Android-68b846.svg?style=flat)
[![License: MIT](http://img.shields.io/badge/license-MIT-lightgrey.svg?style=flat)](https://github.com/Yummypets/Inje.kt/blob/master/LICENSE)

Simple Kotlin injection under 30 lines

```kotlin
// Register dependency on App start.
DependencyInjection.register<UserRepository> { ApiUserRepository }

// Get it later on.
val userRepository = DependencyInjection.getDependency<UserRepository>()
```

## About
- [x] Simple & type-safe api (generics FTW)
- [x] Lightweight: 1 file ~ 30 lines of pure kotlin
- [x] Does NOT rely on evil Annotations

## Installation
- Copy and paste `Inje.kt` file in your project.  
- Make sure  you import the `kotlin-reflect` on which Inject relies:  
`implementation "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"`
- There is no step 3 \o/

## Usage
### 1. Register your dependencies on App Start

``` kotlin
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Register your dependency by providing
        // a concrete object for a given Interface.
        DependencyInjection.register<UserRepository> { ApiUserRepository }
    }
}
```

### 2. Add the `HasDependencies` interface

### 3. Get the dependency anywhere you want

``` kotlin
class UserFragment : Fragment(), HasDependencies {

  // Get your dependency.
  val userRepository = getDependency<UserRepository>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      // Use it!
      userRepository.someCoolStuff()
  }
}
```

## Contributors
[PAFagniez](https://github.com/PAFagniez), [S4cha](https://github.com/s4cha)
