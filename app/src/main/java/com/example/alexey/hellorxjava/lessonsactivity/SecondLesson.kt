package com.example.alexey.hellorxjava.lessonsactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alexey.hellorxjava.R
import com.example.alexey.hellorxjava.lessonsactivity.FirstLesson.Companion.log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.schedulers.Schedulers


class SecondLesson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_lesson)


        range()
        intervalFunc()
        fromCallableFunc()
        map()
        buffer()
        action()

    }

    private fun action() {
        val observable = Observable
                .fromArray(1, 2, 3, 4, 5, 6, 7, 8)
                .map { item -> item * 100 }

        observable.subscribe( { log("onNext ${it}") } )

    }

    private fun buffer() {
        val observable = Observable
                .fromArray(1, 2, 3, 4, 5, 6, 7, 8)
                .buffer(3)

        // create observer
        val observer = object : Observer<List<Int>> {
            override fun onSubscribe(d: Disposable?) {

            }

            override fun onComplete() {
                log( "onCompleted")
            }

            override fun onError(e: Throwable) {
                log( "onError: " + e)
            }

            override fun onNext(s: List<Int>) {
                log( "onNext: " + s)
            }
        }

        // subscribe
        observable.subscribe(observer)
    }

    private fun map() {


        val observable = Observable
                .fromArray("1", "2", "3", "4", "5", "6")
                .map({str -> str.toInt() })

        // create observer
        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable?) {

            }

            override fun onComplete() {
               log( "onCompleted")
            }

            override fun onError(e: Throwable) {
                log("onError: " + e)
            }

            override fun onNext(s: Int?) {
                log("onNext: " + s!!)
            }
        }

        // subscribe
        observable.subscribe(observer)

    }


    private fun fromCallableFunc() {



        fun longAction(text: String): Int {
            FirstLesson.log("longAction");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (e: InterruptedException) {
                e.printStackTrace();
            }

            return Integer.parseInt(text);
        }

        class CallableLongAction(val data: String) : Callable<Int> {
            override fun call(): Int= longAction(data)
        }

        fun call(integer: Int) {
            log("onNext " + integer)
        }
        Observable.fromCallable(CallableLongAction("5"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({  call(it) })

    }



    private fun intervalFunc() {
        val observable = Observable.interval(500, TimeUnit.MILLISECONDS)

        val observer = object : Observer<Long> {
            override fun onSubscribe(d: Disposable?) {

            }

            override fun onComplete() {
                FirstLesson.log("onComplete")
            }

            override fun onError(e: Throwable?) {
                FirstLesson.log(e.toString())
            }

            override fun onNext(value: Long) {
                FirstLesson.log(value.toString())

            }
        }

//        observable.subscribe(observer)
    }

    private fun range() {
        // create observable
        val observable = Observable.range(10, 4)

        // create observer
        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable?) {

            }

            override fun onComplete() {
                FirstLesson.log("onComplete")
            }

            override fun onError(e: Throwable) {
                FirstLesson.log("onError: " + e)
            }

            override fun onNext(s: Int?) {
                FirstLesson.log("onNext: " + s!!)
            }
        }

        // subscribe
        observable.subscribe(observer)
    }
}

