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
    rollNumber().zip(names()) { roll, name ->
        "Roll number $roll is of name is $name"
    }.collect {
        println(it)
    }

    println("-------------Sample testing------------ ")

    simple().collect {
        println(it)
    }
}




