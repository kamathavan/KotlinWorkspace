package SealedClasses

sealed class Expression {
    class ConstantExpression(val message: String) : Expression()

    class StatementExpression(val message: String) : Expression()

    data object LoadingExpression : Expression()
}

