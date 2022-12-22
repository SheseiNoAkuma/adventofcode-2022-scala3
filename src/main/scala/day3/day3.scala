package com.micro.adventofcode
package day3

import com.micro.adventofcode.day3.Model.{PriorityMapper, Row, Rucksacks}

import scala.io.Source

@main
def day3(): Unit = {
  val part1 = Source.fromResource("day3.txt").getLines()
    .map(l => Row(l))
    .map(_.splitToRucksacks)
    .map(t => t._1.itemsInOverlaps(t._2))
    .map(PriorityMapper.toPriority)
    .sum

  println(s"part1: $part1")

  val part2 = Source.fromResource("day3.txt").getLines()
    .map(l => Rucksacks(l))
    .sliding(3, 3)
    .map (a =>a.head.itemsInOverlaps(a.tail))
    .map(PriorityMapper.toPriority)
    .sum

  println(s"part2: $part2")
  
}





