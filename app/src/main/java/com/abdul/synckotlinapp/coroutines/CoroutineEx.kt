package com.abdul.synckotlinapp.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    repeat(3) {
        GlobalScope.launch {
            sayHi()
        }
    }
}

private fun sayHi() {
    println("Hi from ${Thread.currentThread()}")
}