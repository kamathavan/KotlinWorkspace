import SealedClasses.*

fun displayArithmeticOperation(value1: Int, value2: Int, calculate: (Int, Int) -> Int) {
    val calculateValue = calculate(value1, value2)
    println("Calculated value is-->$calculateValue")
}

fun displayCustomerName(firstName: String, secondName: String, formatCustomerName: (String, String) -> String) {
    println(formatCustomerName(firstName, secondName))
}

val addition: (Int, Int) -> Int = { first, second ->
    first + second
}

val subraction: (Int, Int) -> Int = { first, second ->
    first - second
}

val multiply: (Int, Int) -> Int = { first, second ->
    first * second
}

val division: (Int, Int) -> Int = { first, second ->
    first / second
}

val fancyFormatter: (String, String) -> String = { firstName, secondName ->
    "Hello Mr $firstName $secondName "
}

val basicFormatter: (String, String) -> String = { first, last ->
    "First name $first  Second name $last"
}

var displayFullName: (String, String) -> Unit = { first, second ->
    println("Full name is : $first $second")
}

fun main() {

    displayFullName("Kaliyaperumal", "Kanagavali")
    displayFullName.invoke("AjithKumar", " Vikas")

    displayFullName = { first, second -> println("Hello name- $first $second") }

    displayFullName("Rajesh", "Kumar")

    println(multiply.invoke(12, 3))

    println(fancyFormatter.invoke("MAthava", "MAdhavai"))
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

    displayArithmeticOperation(value1 = 12, value2 = 23, addition)
    displayArithmeticOperation(12, 23, subraction)
    displayArithmeticOperation(value1 = 45, value2 = 5, division)
    displayArithmeticOperation(value1 = 12, value2 = 16, calculate = { first, second ->
        second / first
    })


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


