package com.example.alexey.hellorxjava

import android.support.v7.app.AppCompatActivity
import com.example.alexey.hellorxjava.lessonsactivity.FirstLesson
import com.example.alexey.hellorxjava.lessonsactivity.SecondLesson
import com.example.alexey.hellorxjava.lessonsactivity.ThirdLesson

/**
 * Created by alexey on 06.02.18.
 */
class Lessons {
    companion object {
        val lessons: List<String> = listOf("First lesson", "Second lesson", "Third lesson")
        val activities: Array<AppCompatActivity> = arrayOf(FirstLesson(), SecondLesson(), ThirdLesson())
    }

}