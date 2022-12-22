package com.micro.adventofcode
package day3

object Model {

  case class Row(content: String) {
    def splitToRucksacks: (Rucksacks, Rucksacks) = {
      val length = content.length
      val left = content.substring(0, length / 2)
      val right = content.substring(length / 2)
      (Rucksacks(left), Rucksacks(right))
    }
  }
  case class Rucksacks(items: String) {
    def itemsInOverlaps(other: Rucksacks): Char = {
      items.toList.filter(i => other.items.contains(i)).distinct.head
    }
    def itemsInOverlaps(others: Seq[Rucksacks]): Char = {
      items.toList.filter(i => others.forall(o => o.items.contains(i))).distinct.head
    }
  }

  object PriorityMapper {
    def toPriority(char: Char): Int =
      if (char.isLetter && (char >= 'a' && char <= 'z')) char.toInt - 96
      else if (char.isLetter && (char >= 'A' && char <= 'Z')) char.toInt - 38
      else 0
  }


}
