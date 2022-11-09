package com.example.instagram.data

import androidx.compose.runtime.traceEventEnd

open class Event<out T>(private val content: T) {

    private var hasBeenHandled = false

    fun getContentOfNull(): T?{
        return if(hasBeenHandled){
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}