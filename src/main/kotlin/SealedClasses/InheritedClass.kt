package SealedClasses

open class Exp ()

class ConstValueExp(const:Int) : Exp()

class Sum(val left:Int , val right:Int): Exp()