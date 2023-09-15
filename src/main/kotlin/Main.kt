fun checkType(input: Any?) {
    when (input) {
        is String -> println("It is String value")
        is Int -> println("It is Integer value")
        null -> println("It is null value---->")
        else -> println("It is unknown input value")
    }
}

fun main() {
    checkType(7.3)
}




