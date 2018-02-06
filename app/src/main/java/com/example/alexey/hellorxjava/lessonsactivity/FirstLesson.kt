package com.example.alexey.hellorxjava.lessonsactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.alexey.hellorxjava.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class FirstLesson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_lesson)

        val observable: Observable<String> = Observable.fromArray("one", "two", "three")

        val observer = object : Observer<String> {

            override fun onSubscribe(d: Disposable?) {

            }

            override fun onNext(s: String) {
                log("onNext: " + s)
            }

            override fun onError(e: Throwable) {
                log("onError: " + e)
            }

            override fun onComplete() {
                log("onComplete")
            }
        }

        observable.subscribe(observer)
    }

    companion object {
        fun log(str: String) {
            Log.d("My Tag", str)
        }
    }
}
