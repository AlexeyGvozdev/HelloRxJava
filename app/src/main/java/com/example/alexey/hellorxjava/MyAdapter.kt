package com.example.alexey.hellorxjava

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by alexey on 06.02.18.
 */
class MyAdapter(private val listener: (Int) -> Unit) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var lessons: List<String> = emptyList()

    fun setListLessons(list: List<String>) {
        lessons = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = lessons.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lessons[position])
    }


    class ViewHolder(itemView: View, private val listener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val tvNameLesson: TextView = itemView.findViewById(R.id.tv_name_lesson)

        fun bind(name: String) {
            tvNameLesson.text = name
            itemView.setOnClickListener { listener(adapterPosition) }
        }

    }

}