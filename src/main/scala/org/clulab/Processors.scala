package org.clulab

import org.clulab.processors.clu.CluProcessor
import org.clulab.dynet.Utils
import scala.io.Source

class Processors() {
  def process(text:String) {
    Utils.initializeDyNet()
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
