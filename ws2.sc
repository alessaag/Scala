//Se puede expresar el if en una sola línea
//si contiene más de 1 línea se debe poner entre llaves
val num = 5
if (num % 2 == 0) println("Es par") else println("Es impar")

//En Scala el if se evalua y devuelve un valor,
//que puede ser guardado en una variable
//además infiere el tipo del resultado
val numPar = if(num % 2 == 0) num else 0

//Debido a la inferencia de tipo, es una buena practica indicarlo
val numPar: Int = if(num % 2 == 0) num else 0

//Esto también se puede expresar como una función
def esPar(num: Int): Boolean = if(num % 2 == 0) true else false

esPar(3)
esPar(4)

//los for en Scala no tienen un contador, sino que van asociados a listados

val lst = List(1, 1, 2, 2, 3, 3)
for (elem <- lst){
  //codigo
  println(s"Elemento $elem")
}

//si no hay elementos a recorrer, sino que se tiene que ejecutar
//algo un número de veces, se crea un rango

val range = (0 to 10)
for (elem <- range){
  //codigo
  println(s"Elemento $elem")
}

//Otra forma de recorrer una lista es con foreach
lst.foreach(println)

//While no se usa mucho ya que requiere un contador

var a = 0
while(a < 5){
  println(s"A vale $a")
  a = a + 1
}

//Pattern matching: en el ejemplo se ingresa num
//en la variable x y segun su valor se evaluan los casos
//case _ es el valor por defecto

def esPar(num: Int): Boolean = num match{
  case x if x % 2 == 0 => true
  case _ => false
}

esPar(15)

//En el siguiente ejemplo el obj se pasa a o, y se toma una accion
//según el tipo, en lugar de o, se puede nombrar cada caso de forma diferente
//p.e. case str, case int, etc

def printType(obj: Any): Unit = obj match{
  case o: String => println(s"Es un string: $o")
  case o: Int => println(s"Es un int: $o")
  case _ => println("No se lo que es")
}

printType("Hello World!")
printType(245)
printType(true)