/*
* Las colecciones en Scala son inmutables
* List: mantiene el orden de creacion de sus elementos
* Set: no se repiten los elementos y no mantiene el orden
* Seq:
* Option:
*
* */

val numLst = List(1, 2, 3, 4, 5)
val numSet = Set(1, 1, 2, 2, 3, 4, 5)

println(numLst)
println(numSet)

numLst(0) //equivale a numLst.apply(0)
numSet(1)//equivale a numSet.apply(1)

numLst.apply(0)
numSet.apply(1)

/*
* Si bien son inmutables, se pueden añadir elementos
* ante lo cual se crean nuevas colecciones
*
* */

numLst :+ 10
numSet + 10



List(1,2,3) ++ List(3,4,5)

Set(1,2,3) ++ Set(3,4,5)

/*
* Metodos:
* filter: te deja solo lo que cumple la condicion
* map: aplica una funcion a cada elemento de la lista y crea una nueva lista con los elementos modificados
* fold: es una función que toma dos argumentos, el segundo argumento es una funcion que a su vez recibe dos argumentos (acumulado, actual).
* la función es recursiva y se aplica a cada elemento de la lista. El primer valor de acumulado es el primer argumento de fold.
* Se puede encontrar una descripcion detallada sobre fold en: https://www.baeldung.com/scala/folding-lists
* option: es util para apoyar la escritura de codigo que debe tratar con ausencia de datos.
* Ver más informacion en: https://www.baeldung.com/scala/option-type
* */

numLst.filter(elem => elem % 2 == 0) // es lo mismo que numLst.filter(_ % 2 == 0)

numLst.map(_ * 10) //es lo mismo que numLst.map(elem => elem * 10)

numLst.fold(0)((acumulado, actual) => acumulado + actual) //toma la lista numLst desde el elemento 0 y genera la suma del acumulado más el elemento actual


val stringList = List("hola", "juan", "keepcoding")

stringList.map(str => str.toList) //Genera una lista de listas
stringList.map(str =>str.toList).flatten //elimina el anidamiento de listas y genera una sola lista
stringList.flatMap(str =>str.toList)

numLst.exists(elem => elem > 4) //exists indica si se cumple un condición
numLst.contains(2) //contains indica si la lista contiene un elemento específico
numLst.count(elem => elem > 4) // count genera el conteo de los elementos que cumplen la condicion

//Option
 def dividir(a: Int, b: Int): Option[Double] = {
   if (b == 0) None
   else Some(a / b)
 }

val d = dividir(12, 3)
val d2 = dividir(12, 0)

d match{
 case None => println("No se pudo dividir")
 case Some(value) => println(s"El resultado es: $value")
}

d2 match{
 case None => println("No se pudo dividir")
 case Some(value) => println(s"El resultado es: $value")
}

d2.getOrElse(0.0)
d2.isEmpty
d.isEmpty

d2.map(v => v * 10)
d.map(v => v * 10)