package HigerOrderFunctions

fun additionHigherOrderFunction(value1: Int, value2: Int, addition: (Int, Int) -> Int) {
    val result = addition(value1, value2)
    println("Simple Higher Order Functions--->$result") // prints 30
}

fun subractionHigherOrderFunction(subraction: (Int, Int) -> Int) {
    val subOutPut = subraction(20, 6)
    println("Subraction output-----> $subOutPut")
}

fun simpleHOD1(name: String, displayName: (name: String) -> Unit) {
    displayName(name)
}

inline fun simpleHOD2(secondName: String): (firstName: String) -> Unit {
    return { firstName -> println("Hello $firstName $secondName") }
}

var functionTypeFunction: (String) -> String = {
    "Hello $it"
}


