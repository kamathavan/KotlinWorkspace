import SealedClasses.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException

fun rollNumber(): Flow<Int> = (1..4).asFlow()

fun names(): Flow<String> = flowOf("mathavan", "Ravi", "Vinoth")

fun simple(): Flow<String> = flow {
    for (i in 1..10) {
        emit("Hello world $i")
    }
}

fun main() = runBlocking<Unit> {

    evaluateNormalClasses(ConstValueExp(5))
    evaluateNormalClasses(Sum(4, 5))
    //evaluateNormalClasses(Exp())

    println("Evaluate sealed classed")
    evaluateSealedClasses(Expression.ConstantExpression("This is constant expression"))
    evaluateSealedClasses(Expression.StatementExpression("This is constant expression"))
    evaluateSealedClasses(Expression.LoadingExpression)

    println("Evaluate sealed classed for Error state classes")

    evaluateErrorState(CommonError)
    evaluateErrorState(DataBaseError(dataError = 100))
    evaluateErrorState(APIError(code = 101))

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


