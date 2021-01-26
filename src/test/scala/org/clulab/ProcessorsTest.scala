package org.clulab.processors

import java.io.{BufferedReader, InputStreamReader}

import org.clulab.processors.clu.CluProcessor
import org.scalatest.{FlatSpec, Matchers}
import org.clulab.dynet.Utils

/**
  * Integration test for the Clu parser
  * User: mihais
  * Date: 7/26/17
  */
class ProcessorsTest extends FlatSpec with Matchers {
  val proc = {
    Utils.initializeDyNet()
    new CluProcessor // or new FastNLPProcessor()
  }

  "CluProcessor" should "parse text correctly" in {
    val sent = "John likes cake that contains chocolate."
    val doc = proc.annotate(sent)

    println(s"Basic universal dependencies for sentence: $sent")
    println(doc.sentences.head.universalBasicDependencies.get)

    doc.sentences.head.universalBasicDependencies.get.hasEdge(1, 0, "nsubj") should be(true)
    doc.sentences.head.universalBasicDependencies.get.hasEdge(1, 2, "dobj") should be(true)
    doc.sentences.head.universalBasicDependencies.get.hasEdge(2, 4, "acl:relcl") should be(true)
    doc.sentences.head.universalBasicDependencies.get.hasEdge(4, 3, "nsubj") should be(true)
    doc.sentences.head.universalBasicDependencies.get.hasEdge(4, 5, "dobj") should be(true)
    println("Parsing is fine.")
  }
}