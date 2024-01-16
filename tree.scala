/*
* Ejercicio Binary Tree
*
*Completa en el tree package:
*
*[pre-order/post-order/in-order algorithm](https://en.wikipedia.org/wiki/Tree_traversal#Depth-first_search_of_binary_tree)
*
*Comprueba tu respuesta con los tests
*/

package io.keepcoding.exercise2

sealed trait Tree
case object Leaf extends Tree
case class Node(left: Tree, value: Int, right: Tree) extends Tree


object Tree {

  def preOrder(node: Tree): List[Int] = node match{
    case Leaf => List.empty
    case Node(left, value, right) => List(value) ++ preOrder(left) ++ preOrder(right)
  }
  def inOrder(node: Tree): List[Int] = node match {
    case Leaf => List.empty
    case Node(left, value, right) => inOrder(left) ++ List(value) ++ inOrder(right)
  }
  def postOrder(node: Tree): List[Int] = node match {
    case Leaf => List.empty
    case Node(left, value, right) => postOrder(left) ++ postOrder(right) ++ List(value)
  }

}


/*Treetest:

*
package io.keepcoding.exercise2

import org.scalatest.{FlatSpec, MustMatchers}

class TreeTest extends FlatSpec with MustMatchers {

  import TreeTest._

  behavior of "Tree - InOrder"

  it must "works with sample 1" in {
    Tree.inOrder(tree1) must be (List(4, 2, 5, 1, 3))
  }

  it must "works with sample 2" in {
    Tree.inOrder(tree2) must be (List(6, 4, 1, 3, 0, 5, 9, 2, 11, 7, 10))
  }

  it must "works with sample 3" in {
    Tree.inOrder(tree3) must be (List(3, 5, 6, 7, 7, 5, 6, 8, 9, 10))
  }
}

object TreeTest {

  val tree1: Tree = Node(Node(Node(Leaf, 4, Leaf), 2, Node(Leaf, 5, Leaf)), 1, Node(Leaf, 3, Leaf))
  val tree2: Tree = Node(Node(Node(Leaf, 6, Leaf), 4, Node(Node(Leaf, 1, Leaf), 3, Node(Leaf, 0, Leaf))), 5,
    Node(Node(Leaf, 9, Leaf), 2, Node(Node(Leaf, 11, Leaf), 7, Node(Leaf, 10, Leaf))))
  val tree3: Tree = Node(Node(Node(Leaf, 3, Leaf), 5, Leaf), 6, Node(Node(Leaf, 7, Leaf), 7,
    Node(Node(Node(Node(Leaf, 5, Leaf), 6, Leaf), 8, Leaf), 9, Node(Leaf, 10, Leaf))))

}

*/
 */