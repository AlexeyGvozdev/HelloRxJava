package com.example.alexey.hellorxjava.lessonsactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alexey.hellorxjava.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import com.example.alexey.hellorxjava.lessonsactivity.FirstLesson.Companion.log
import java.util.concurrent.TimeUnit

class FourthLesson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_lesson)

//        coldObservable()
//        hotObservable()
//        replay()
//        refCount()
        cache()
    }

    private fun cache() {
        log("cache")

        var subscription1 : Disposable? = null
        var subscription2 : Disposable? = null
        val observer1 = object : Observer<Long> {
            override fun onComplete() {
                log("observer1 onCompleted")
            }

            override fun onSubscribe(d: Disposable) {
                subscription1 = d
            }

            override fun onNext(value: Long?) {
                log("observer1 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }

        val observer2 = object : Observer<Long> {
            override fun onComplete() {
                log("observer2 onCompleted")
            }

            override fun onSubscribe(d: Disposable?) {
                subscription2 = d
            }

            override fun onNext(value: Long?) {
                log("observer2 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }


        log("observable create")

        val observable = Observable
                .interval(1, TimeUnit.SECONDS)
                .take(10)
                .cache()


        window.decorView.postDelayed({
            log("observer1 subscribe")
            observable.subscribe(observer1)
        }, 1500)

        window.decorView.postDelayed({
            log("observer2 subscribe")
            observable.subscribe(observer2)
        }, 4000)

        window.decorView.postDelayed({
            log("observer1 unsubscribe")
            subscription1?.dispose()
        }, 5500)

        window.decorView.postDelayed({
            log("observer2 unsubscribe")
            subscription2?.dispose()
        }, 6500)
        window.decorView.postDelayed({
            log("observer1 subscribe")
            observable.subscribe(observer1)
        }, 17500)
    }

    private fun refCount() {
        log("refCount")

        var subscription1 : Disposable? = null
        var subscription2 : Disposable? = null
        val observer1 = object : Observer<Long> {
            override fun onComplete() {
                log("observer1 onCompleted")
            }

            override fun onSubscribe(d: Disposable) {
                subscription1 = d
            }

            override fun onNext(value: Long?) {
                log("observer1 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }

        val observer2 = object : Observer<Long> {
            override fun onComplete() {
                log("observer2 onCompleted")
            }

            override fun onSubscribe(d: Disposable?) {
                subscription2 = d
            }

            override fun onNext(value: Long?) {
                log("observer2 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }


        log("observable create")

        val observable = Observable
                .interval(1, TimeUnit.SECONDS)
                .take(6)
                .publish()
                .refCount()


        window.decorView.postDelayed({
            log("observer1 subscribe")
            observable.subscribe(observer1)
        }, 1500)

        window.decorView.postDelayed({
            log("observer2 subscribe")
            observable.subscribe(observer2)
        }, 3000)

        window.decorView.postDelayed({
            log("observer1 unsubscribe")
            subscription1?.dispose()
        }, 5000)

        window.decorView.postDelayed({
            log("observer2 unsubscribe")
            subscription2?.dispose()
        }, 6000)
        window.decorView.postDelayed({
            log("observer1 subscribe")
            observable.subscribe(observer1)
        }, 6500)
    }

    private fun replay() {
        log("replay")
        val observer1 = object : Observer<Long> {
            override fun onComplete() {
                log("observer1 onCompleted")
            }

            override fun onSubscribe(d: Disposable?){}

            override fun onNext(value: Long?) {
                log("observer1 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }
        val observer2 = object : Observer<Long> {
            override fun onComplete() {
                log("observer2 onCompleted")
            }

            override fun onSubscribe(d: Disposable?){}

            override fun onNext(value: Long?) {
                log("observer2 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }


        log("observable create")

        val observable = Observable
                .interval(1, TimeUnit.SECONDS)
                .take(6)
                .replay()

        log("observable connect")
        observable.connect()
        window.decorView.postDelayed({
            log("observer1 subscribe")
            observable.subscribe(observer1)
        }, 2500)

        window.decorView.postDelayed({
            log("observer2 subscribe")
            observable.subscribe(observer2)
        }, 4500)
    }

    private fun hotObservable() {
        log("hot")
        val observer1 = object : Observer<Long> {
            override fun onComplete() {
                log("observer1 onCompleted")
            }

            override fun onSubscribe(d: Disposable?){}

            override fun onNext(value: Long?) {
                log("observer1 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }
        val observer2 = object : Observer<Long> {
            override fun onComplete() {
                log("observer2 onCompleted")
            }

            override fun onSubscribe(d: Disposable?){}

            override fun onNext(value: Long?) {
                log("observer2 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }


        log("observable create")

        val observable = Observable.interval(1, TimeUnit.SECONDS)
                .take(6)
                .publish()


        window.decorView.postDelayed({
            log("observer1 subscribe")
            observable.subscribe(observer1)
        }, 2500)

        window.decorView.postDelayed({
            log("observable connect")
            observable.connect()
            log("observer2 subscribe")
            observable.subscribe(observer2)
        }, 4500)

    }

    private fun coldObservable() {
        log("cold")
        val observer1 = object : Observer<Long> {
            override fun onComplete() {
                log("observer1 onCompleted")
            }

            override fun onSubscribe(d: Disposable?){}

            override fun onNext(value: Long?) {
                log("observer1 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }
        val observer2 = object : Observer<Long> {
            override fun onComplete() {
                log("observer2 onCompleted")
            }

            override fun onSubscribe(d: Disposable?){}

            override fun onNext(value: Long?) {
                log("observer2 onNext value = ${value}")
            }

            override fun onError(e: Throwable?) {}
        }


        log("observable create")

        val observable = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
        window.decorView.postDelayed({
            log("observer1 subscribe")
            observable.subscribe(observer1)
        }, 1000)

        window.decorView.postDelayed({
            log("observer2 subscribe")
            observable.subscribe(observer2)
        }, 2500)
    }
}
