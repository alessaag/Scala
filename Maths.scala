package io.keepcoding.exercise2

object Maths {

  //Definicion de funcion que genera la posición n de la serie de Fibonacci
  //Usando pattern matching
  def fibonacci(n: Int): Int = n match{
    case n if n < 0 => throw new RuntimeException("Número negativo: Ingrese un entero positivo")
    case n if n  == 0 => 0
    case n if n == 1 => 1
    case n if n > 1 => (fibonacci(n - 1) + fibonacci(n - 2))
  }

  def main(args: Array[String]): Unit = {
    println(fibonacci(7))
  }

}

//Usando if
//def fibonacci(n: Int): Int = {
//    if n < 0 throw new RuntimeException("Número negativo: Ingrese un entero positivo")
//    else if (n == 0) 0
//    else if (n == 1) 1
//    else (fibonacci(n - 1) + fibonacci(n - 2))
//  }