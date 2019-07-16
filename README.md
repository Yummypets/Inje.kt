# Inje.kt
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
class UserFragment : Fragment() {

    override fun onViewCreated() {
        DependencyInjection.getDependency<UserRepository>().getUser()
    }
   
}

``` 
