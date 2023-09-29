package year2015

import utils.getPuzzleInput
import utils.logMeasureTime
import java.io.File

class Day07 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2015/day07.txt").readLines()

            println("=== Part One ===")
            logMeasureTime {
                Day07().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day07().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {
        println(lines)
    }

    private fun partTwo(lines: List<String>) {
        println(lines)
    }
}