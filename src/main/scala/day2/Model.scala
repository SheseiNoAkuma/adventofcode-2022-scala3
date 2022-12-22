package com.micro.adventofcode
package day2

object Model {

  def decode(value: String): RockPaperScissors =
    RockPaperScissors.values.toList.find(v => v.isMappedBy(value)).head

  enum Outcome(val value: String) {
    case Win extends Outcome("Z")
    case Draw extends Outcome("Y")
    case Lose extends Outcome("X")
  }
  object Outcome {
    def fromValue(v: String): Outcome =
      Outcome.values.toList.find(_.value == v).get
  }

  enum RockPaperScissors(mappedBy: List[String]) {
    def isMappedBy(v: String): Boolean = mappedBy.contains(v)
    def play(other: RockPaperScissors): Outcome = (this, other) match
      case (t, o) if t == o => Outcome.Draw
      case (RockPaperScissors.Rock, RockPaperScissors.Paper) => Outcome.Win
      case (RockPaperScissors.Paper, RockPaperScissors.Scissors) => Outcome.Win
      case (RockPaperScissors.Scissors, RockPaperScissors.Rock) => Outcome.Win
      case _ => Outcome.Lose

    def moveForOutcome(outcome: Outcome): RockPaperScissors =
      RockPaperScissors.values.toList
        .find(other => this.play(other) == outcome)
        .get

    case Rock extends RockPaperScissors(List("A", "X"))
    case Paper extends RockPaperScissors(List("B", "Y"))
    case Scissors extends RockPaperScissors(List("C", "Z"))
  }

  case class PointEvaluator(move1: RockPaperScissors, move2: RockPaperScissors) {
    def evaluate: Int = {
      val movePoint = move2 match
        case RockPaperScissors.Rock => 1
        case RockPaperScissors.Paper => 2
        case RockPaperScissors.Scissors => 3

      val outcomePoint = move1.play(move2) match
        case Outcome.Win => 6
        case Outcome.Draw => 3
        case Outcome.Lose => 0

      movePoint + outcomePoint
    }
  }

}
