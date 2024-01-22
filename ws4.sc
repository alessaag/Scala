/*
* map y flatMap aplicado a listas
* map: aplica la función a cada elemento de la lista
* flatMap: aplica la funcion a cada elemento de la lista, generando una lista única como resultado, sin anidamientos
* for comprehension: permite generar el mismo resulado de un map y flatMap anidados.
*
* */

val x = List(1, 2 , 3)
val y = List(true, false)

x.flatMap(x => y)

y.map(a => (x,a))

x.map(a => (a,y))

x.flatMap(x =>
  y.map(y => (x,y))
)

/*
*
* List(1, 2 , 3).flatMap(x =>
  List(true, false).map(y => (x,y))
)
* */

for{
  x <- List(1, 2, 3)
  y <- List(true, false)
}yield(x,y)

for{
  x <- List(1, 2, 3, 4, 5, 6)
  if x < 3
  y <- List("a", "b")
}yield(x,y)

List(1, 2, 3, 4, 5, 6).withFilter(_<3).flatMap(x =>
  List("a", "b").map(y => (x,y))
)