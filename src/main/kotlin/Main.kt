fun getMessage(input: Int) = if (input > 3) {
    "Given is bigger than 3"
} else {
    "Given is value is not more 3"
}

fun checkWhenMessage(input: Int) = when {
    input > 3 -> "Given is bigger than 3"
    else -> "Given is value is not more 3"
}

fun checkWhenMessage1(input: Int): String {
    val message = when (input) {
        3 -> "Given input value is 3"
        else -> "Given input value is not 3"
    }
    return message
}

fun checkWhenMessage2(input: Int) {
    when (input) {
        in 1..10 -> println("value range from 1 to 10")
        35 -> println("It is valid value for 35")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }
}

fun checkFDataType(input: Any?) {
    when (input) {
        is String -> println("This is string type value")
        is Number -> if (input is Int) {
            println("This is integer type")
        } else {
            println("This is not number type s")
        }

        null -> println("This is null value")
        else -> println("Unknow type of the value")
    }
}


fun main() {

    println(getMessage(2))

    println(checkWhenMessage(3))

    println(checkWhenMessage1(4))

    checkWhenMessage2(101)

    checkFDataType(null)

    checkFDataType(4)

    checkFDataType(4.5)

    checkFDataType("Mathavan")
}




