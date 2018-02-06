package com.example.alexey.hellorxjava

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {



    private val adapter = MyAdapter({ chooseLessonActivity(it) })

    private fun chooseLessonActivity(position: Int) {
        startActivity(Intent(this, Lessons.activities[position]::class.java))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        adapter.setListLessons(Lessons.lessons)
    }
}
