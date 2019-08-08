# Inje.kt
[![Language: Kotlin](https://img.shields.io/badge/language-Kotlin-7963FE.svg?style=flat)](https://kotlinlang.org)
![Platform: Android 8+](https://img.shields.io/badge/platform-Android-68b846.svg?style=flat)
[![License: MIT](http://img.shields.io/badge/license-MIT-lightgrey.svg?style=flat)](https://github.com/Yummypets/Inje.kt/blob/master/LICENSE)

Simple Kotlin injection under 30 lines

### 1. Import the file DependencyInjection.kt in your project
### 2. Declare your dependencies

``` kotlin
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }
    
    private fun injectDependencies() {
        DependencyInjection.apply {
            register<UserRepository> { ApiUserRepository }
        }
    }
}

``` 

### 3. Get the dependency anywhere you want from the injector

``` kotlin
class UserFragment : Fragment(), HasDependencies {

    override fun onViewCreated() {
        val user = getDependency<UserRepository>().getUser()
    }
   
}

``` 

> Don't forget to use the interface HasDependencies for a cleaner implementation
