package com.octopepper.yummypets

import android.util.Log


typealias DependencyBuilderBlock<T> = () -> T

class DependencyBuilderkWrapper<T>(val serviceBuilderBlock:DependencyBuilderBlock<T>, val serviceName: String)

object DependencyInjection {

    var serviceBuilderkWrappers = mutableListOf<DependencyBuilderkWrapper<Any>>()

    inline fun <reified T>register(noinline block: DependencyBuilderBlock<T>) {
        val wrapper = DependencyBuilderkWrapper(block, T::class.simpleName ?: "noname") as DependencyBuilderkWrapper<Any>
        serviceBuilderkWrappers.add(wrapper)
    }

    inline fun <reified T> getDependency(): T {
        try{
            val serviceWrapper = serviceBuilderkWrappers.first { it.serviceName == T::class.simpleName }
            val block = serviceWrapper.serviceBuilderBlock as DependencyBuilderBlock<T>
            val instance = block()
            return instance
        }
        catch (e: NoSuchElementException){
            throw NoSuchElementException("Tried to inject a dependency that is missing. " +
                    "It must be added into the MainApplication")
        }
    }
}

interface HasDependencies

inline fun <reified T>HasDependencies.getDependency(): T = DependencyInjection.getDependency()