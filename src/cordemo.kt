import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun main() {

    println("started")
    /*val job1 = GlobalScope.async {
        println("1 started with launch")
        delay(4000)
        println("1 ending in launch")
        return@async "Palak"
    }
    val job2 = GlobalScope.async {
        println("2 started with launch")
        delay(4000)
        println("2 ending in launch")
        return@async "Darji"
    }
    println("bypassed launch")
    val value1 = job1.await()
    val value2 = job2.await()
    println("done $value1 $value2")
*/

    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    scope.launch {
        launch {
            println("launched first child")
            delay(4000)
        }
        launch {
            println("launched second child")
            delay(4000)
        }
        println("launched all children")
    }
    println("launched everything")
}

