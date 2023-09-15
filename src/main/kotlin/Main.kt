import HigerOrderFunctions.functionTypeFunction
import SealedClasses.*
import kotlinx.coroutines.runBlocking

fun printCalculateValue(value1: Int, value2: Int, calculate: (Int, Int) -> Int) {
    val calculateValue = calculate(value1, value2)
    println("Calculated value is-->$calculateValue")
}

fun displayCustomerName(firstName: String, secondName: String, formatCustomerName: (String, String) -> String) {
    println(formatCustomerName(firstName, secondName))
}

val fancyFormatter: (String, String) -> String = { firstName, secondName ->
    "Hello Mr $firstName $secondName "
}

val basicFormatter: (String, String) -> String = { first, last ->
    "First name $first  Second name $last"
}

fun main() = runBlocking<Unit> {

    displayCustomerName(
        firstName = "mathavan",
        secondName = "Kaliyaperumal",
        formatCustomerName = basicFormatter
    )

    displayCustomerName(
        firstName = "Mathavan",
        secondName = "Madhavi",
        formatCustomerName = fancyFormatter
    )

    displayCustomerName(
        firstName = "Mathavan",
        secondName = "Madhavi",
        formatCustomerName = { husband, wifename ->
            "This is family name $husband $wifename "
        }
    )

    displayCustomerName(firstName = "Mathavan", secondName = "Madhavi") { husband, wifename ->
        "This is family name $husband $wifename "
    }

    printCalculateValue(12, 23) { value1, value2 ->
        value1 + value2
    }

    printCalculateValue(12, 23) { value1, value2 ->
        value1 - value2
    }

    println(functionTypeFunction("Android"))
// function invoke
    println(functionTypeFunction.invoke("Kotlin World "))
// update the value
    functionTypeFunction = {
        "This is $it"
    }

    println(functionTypeFunction("Mathavan world"))
}

fun evaluateNormalClasses(expression: Exp) {
    when (expression) {
        is ConstValueExp -> println("It is constant value---> $expression.value")
        is Sum -> println("It is sum of the value---> ${expression.left + expression.right}")
        else -> throw IllegalStateException("Unknown class exceptions-------->")
    }
}

fun evaluateSealedClasses(expression: Expression) {
    when (expression) {
        is Expression.ConstantExpression -> println("This is statement Expression.ConstantExpression --->")
        is Expression.StatementExpression -> println("This is statement Expression.StatementExpression --->")
        is Expression.LoadingExpression -> println("This is loading status")
    }
}

fun evaluateErrorState(errorState: ErrorState) {
    when (errorState) {
        is APIError -> println("This is for API error handling")
        is DataBaseError -> println("This is for DataBaseError ---> ${errorState.dataError}")
        is CommonError -> println("This is common error handling")
    }
}


