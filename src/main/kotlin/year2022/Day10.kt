package year2022

import utils.getPuzzleInput
import utils.logMeasureTime

class Day10 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = getPuzzleInput(this)

            println("=== Part One ===")
            logMeasureTime {
                Day10().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day10().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {
        println(
            (20..220 step 40).fold(0) { acc: Int, i: Int ->
                acc + (getSignalStrength(lines, i) * i)
            }
        )
    }

    private fun partTwo(lines: List<String>) {
        println(lines)
    }

    private fun getSignalStrength(lines: List<String>, cycle: Int): Int {
        var currentCycle = 0
        var currentCount = 1

        lines.forEach { line ->
            if (line == "noop") {
                currentCycle++
            } else {
                currentCycle += 2

                if (currentCycle < cycle) {
                    currentCount += line.split(" ").last().toInt()
                } else {
                    return currentCount
                }
            }
        }

        return currentCount
    }
}