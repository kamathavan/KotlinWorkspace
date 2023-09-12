import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow


fun flowTest(request: Int): Flow<String> = flow {
    emit("First $request")
    delay(100)
    emit("Second $request")
}

fun flowCompletion() = (1..3).asFlow()

// simple Extension function

fun MutableList<Int>.swap(number1: Int, number2: Int) {
    val temp = this[number1]
    this[number1] = this[number1]
    this[number2] = temp

}