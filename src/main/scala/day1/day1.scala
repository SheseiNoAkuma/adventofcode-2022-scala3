package com.micro.adventofcode
package day1

import scala.io.Source

@main
def day1(): Unit = {
  val calories = Source.fromResource("day1.txt").getLines().foldLeft(Seq(Seq.empty[Int])) {
    (acc, s) =>
      if (s.isBlank) acc :+ Seq.empty
      else acc.init :+ (acc.last :+ s.toInt)
  }.map(l => l.sum)

  println(s"part one the most calories: ${calories.max}")

  val threeMaxCalories = calories.sorted(Ordering.Int.reverse).take(3)
  println(s"part two the most 3 calories ($threeMaxCalories): ${threeMaxCalories.sum}")

}





