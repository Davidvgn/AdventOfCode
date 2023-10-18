package year2016

import utils.logMeasureTime
import java.io.File

class Day02 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2016/day02.txt").readLines()

            println("=== Part One ===")
            logMeasureTime {
                Day02().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day02().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {


        lines.forEach {
            println(
                it.fold(5) { acc: Int, s: Char ->
                    acc + if (s == 'L' && acc != 1 && acc != 4 && acc != 7) {
                        (-1)
                    } else if (s == 'R' && acc != 3 && acc != 6 && acc != 9) {
                        1
                    } else if (s == 'U' && acc != 1 && acc != 2 && acc != 3) {
                        (-3)

                    } else if (s == 'D' && acc != 7 && acc != 8 && acc != 9) {
                        +3
                    } else {
                        0
                    }
                }
            )
        }

    }


    private fun partTwo(lines: List<String>) {
        println(lines.size)
    }
}