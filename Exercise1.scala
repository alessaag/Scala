/*
* Ejercicio 1: POO (Traits, case classes and Objects)
Necesitamos 3 tipos de mensajes, todos ellos tendran asociado un id:

- Text: contiene un String
- Attachment: contiene una URI, que indentifica el fichero adjunto.
- Sound: contiene una URI, que indentifica el fichero de sonido.

* Los mensajes también necesitan soporte para:

- Ser Printable: Acción de poder imprimirse.
- Ser Runnable: Acciones de start/stop
- Ser Coloreable: background_color

* El modelado se debe hacer teniendo en cuenta las siguientes restricciones:

- Text y Attachment pueden ser Printable
- Solamente los mensajes de tipo Sound pueden ser Runnable
- Solamente los mensajes de tipo Text pueden ser Coloreable

* Extra:

- Define un método apply para que los mensajes de tipo Text, puedan sear creados unicamente con su contenido.
- Define un método apply para los mensajes de tipo Attachment y Sound, para poder crear los mensajes usando únicamente el URI.
* */

package io.keepcoding.exercise1

import java.net.URI
import java.util.UUID

//Los traits son clases que no se pueden
//instanciar y no pueden recibir parametros

trait Printable {
  def print: Unit
}

trait Runnable {
  def start(): Unit
  def stop(): Unit
}

trait Coloreable {
  val background_color: String
}

//un sealed trait solo puede extender
// las clases que se encuentran en el mismo fichero

sealed trait Message{
  val id: UUID
}

case class TextMessage(id: UUID, content: String) extends Message with Printable with Coloreable {
  override def print: Unit = println(s"Content: $content")

  override val background_color: String = "Red"
}

//Un companion object es un objeto con el mismo nombre de una clase del mismo archivo
//permite usar el metodo como un objeto

object TextMessage {
  def apply(content: String): TextMessage = TextMessage(UUID.randomUUID(), content)
}

case class AttachmentMessage(id: UUID, attachmentURI: URI) extends Message with Printable {
  override def print: Unit = println(s"Content: $attachmentURI")
}

object AttachmentMessage {
  def apply(attachmentURI: URI): AttachmentMessage = AttachmentMessage(UUID.randomUUID(), attachmentURI)
}

case class SoundMessage(id: UUID, soundURI: URI) extends Message with Runnable {
  override def start(): Unit = println(s"Starting sound: $soundURI")

  override def stop(): Unit = println(s"Stoping sound: $soundURI")
}

object SoundMessage {
  def apply(soundURI: URI): SoundMessage = SoundMessage(UUID.randomUUID(), soundURI)
}

object Main {
  def main(args: Array[String]): Unit = {
    val text1 = TextMessage(UUID.randomUUID(), "This is the content")
    val text2 = TextMessage("This is the content con companion object")
    val attach1 = AttachmentMessage(UUID.randomUUID(), new URI("http://myUri1"))
    val attach2 = AttachmentMessage(new URI("http://myUri2"))
    val sound1 = SoundMessage(UUID.randomUUID(), new URI("http://myUri/sound1"))
    val sound2 = SoundMessage(new URI("http://myUri/sound2"))

    sound1.start()
    sound2.start()
    text1.print
    text2.print
    attach1.print
    attach2.print
  }


}