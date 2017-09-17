package org.clulab.processors

import java.io.{BufferedReader, InputStreamReader}

import org.clulab.processors.clu.CluProcessor
import org.clulab.processors.clu.syntax.EvaluateMalt
import org.scalatest.{FlatSpec, Matchers}

/**
  * Integration test for the Clu parser
  * User: mihais
  * Date: 7/26/17
  */
class ProcessorsTest extends FlatSpec with Matchers {
  val proc = new CluProcessor

  "CluProcessor" should "parse WSJ with an accuracy over 87%" in {
    val model = proc.depParser
    val stream = getClass.getClassLoader.getResourceAsStream("org/clulab/processors/wsj_test.conllx")
    val reader = new BufferedReader(new InputStreamReader(stream))
    val (las, uas) = EvaluateMalt.evaluate(model, reader)
    println(s"WSJ performance: $las, $uas")
    reader.close()
    (las > 0.87) should be (true)
  }
}