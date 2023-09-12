import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun rollNumber(): Flow<Int> = (1..4).asFlow()

fun names(): Flow<String> = flowOf("mathavan", "Ravi", "Vinoth")

fun simple(): Flow<String> = flow {
    for (i in 1..10) {
        emit("Hello world $i")
    }
}

fun main() = runBlocking<Unit> {

    // simple Swap function
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)

    for (i in list) {
        println("simple-->$i")
    }

}




