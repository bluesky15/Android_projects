import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    doWorld()
}

suspend fun doWorld() = coroutineScope {
    val job = launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
    job.join()
    println("Done")
}
//fun main() {
//    runBlocking {
//        printThreadName()
//        for (i in 1..7) {
//            val job = GlobalScope.async {
//             bigTask()
//            }
//            //job.await()
//        }
//    }
//
//}

fun printThreadName() {
    println("the current thread ${Thread.currentThread()}")
}


suspend fun bigTask() {
    printThreadName()
    delay(2000L)
}