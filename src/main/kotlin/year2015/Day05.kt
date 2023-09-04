package year2015

import utils.logMeasureTime
import java.io.File

class Day05 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2015/day05.txt").readLines()

            println("=== Part One ===")
            logMeasureTime {
                Day05().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day05().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {
        val regex = """[aeiou]""".toRegex() // just a first try for first condition
        val thirdCondition = """ab|cd|pq|xy""".toRegex()

        println(lines.fold(0) { acc: Int, s: String ->
            acc + if (thirdCondition.containsMatchIn(s)){
                -1
            } else if (regex.containsMatchIn(s)) {
                +1
            } else {
                0
            }
        })
    }

    private fun partTwo(lines: List<String>) {
        println(lines)
    }
}