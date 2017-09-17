package org.clulab

import org.clulab.processors.clu.CluProcessor
import scala.io.Source

class Processors() {
  def process(text:String) {
    val proc = new CluProcessor()
    val doc = proc.annotate(text)
    for(s <- doc.sentences) {
      println(s"Words: ${s.words.mkString(", ")}")
      println("POS tags: " + s.tags.get.mkString(", "))
    }
  }
}

object Processors {
  def main(args:Array[String]) {
      val fs = new Processors()
      fs.process("This is a test.")
  }
}
