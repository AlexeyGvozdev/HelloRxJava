package com.example.alexey.hellorxjava.lessonsactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alexey.hellorxjava.R
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import com.example.alexey.hellorxjava.lessonsactivity.FirstLesson.Companion.log
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscription
import org.reactivestreams.Subscriber



class ThirdLesson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_lesson)


        subscriptionFunc()
    }



    private fun subscriptionFunc() {
        val observable = Observable.interval(500, TimeUnit.MILLISECONDS)

        val subscription: Disposable = observable.subscribe({ it -> log("onNext ${it}")})
        window.decorView.postDelayed({
            log("unsubscribe")
            subscription.dispose()},4500)
    }
}
