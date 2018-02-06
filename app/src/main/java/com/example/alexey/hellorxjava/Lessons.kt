package com.example.alexey.hellorxjava

import android.support.v7.app.AppCompatActivity

/**
 * Created by alexey on 06.02.18.
 */
class Lessons {
    companion object {
        val lessons: List<String> = listOf("First lesson")
        val activities: Array<AppCompatActivity> = arrayOf(FirstLesson())
    }

}