package com.micro.adventofcode
package day2

import com.micro.adventofcode.day2.Model
import com.micro.adventofcode.day2.Model.{Outcome, PointEvaluator}

import scala.io.Source

@main
def day2(): Unit = {
  val input = Source.fromResource("day2.txt").getLines()
    .map(l => l.split(" "))
    .toList


    val part1 = input.map(a => (Model.decode(a(0)), Model.decode(a(1))))
    .map(t => PointEvaluator(t._1, t._2))
    .map(_.evaluate)
    .sum

  println(part1)

  val part2 = input.map(a => (Model.decode(a(0)), Outcome.fromValue(a(1))))
    .map ( t => PointEvaluator(t._1, t._1.moveForOutcome(t._2)))
    .map(_.evaluate)
    .sum

  println(part2)

}



