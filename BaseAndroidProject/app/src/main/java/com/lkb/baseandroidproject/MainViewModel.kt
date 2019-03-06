package com.lkb.baseandroidproject

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable

class MainViewModel : ViewModel() {
    fun getData(): Observable<String> {
        //return Observable.just("hello", "hi", "there").delay(3000,TimeUnit.MILLISECONDS)
        return Observable.range(1,100)
            .flatMap {
                Thread.sleep(2000)
                Observable.just(it.toString())
            }

    }

}