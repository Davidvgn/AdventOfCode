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

        val leftEdge: List<Int> = listOf(1, 4, 7)
        val rightEdge: List<Int> = listOf(3, 6, 9)
        val upEdge: List<Int> = listOf(1, 2, 3)
        val downEdge: List<Int> = listOf(7, 8, 9)

        val result: MutableList<Int> = mutableListOf()

        lines.forEach {
            result.add(
                it.fold(5) { acc: Int, s: Char ->
                    acc + if (s == 'L' && !leftEdge.contains(acc)) {
                        (-1)
                    } else if (s == 'R' && !rightEdge.contains(acc)) {
                        1
                    } else if (s == 'U' && !upEdge.contains(acc)) {
                        (-3)
                    } else if (s == 'D' && !downEdge.contains(acc)) {
                        3
                    } else {
                        0
                    }
                }
            )
        }
        println(result)
    }


    private fun partTwo(lines: List<String>) {

        val leftEdge: List<Int> = listOf(13, 10, 5, 2, 1)
        val rightEdge: List<Int> = listOf(1, 4, 9, 12, 13)
        val upEdge: List<Int> = listOf(5, 2, 1, 4, 9)
        val downEdge: List<Int> = listOf(5, 10, 13, 12, 9)

        val result: MutableList<Int> = mutableListOf()
        val resultStrg: MutableList<String> = mutableListOf()

        lines.forEach { index ->
            result.add(index.fold(5) { acc: Int, s: Char ->
                acc + if (s == 'L' && !leftEdge.contains(acc)) {
                    (-1)
                } else if (s == 'R' && !rightEdge.contains(acc)) {
                    1
                } else if (s == 'U' && !upEdge.contains(acc) && acc != 3) {
                    (-4)
                } else if (s == 'U' && !upEdge.contains(acc) && acc == 3) {
                    (-2)
                } else if (s == 'D' && !downEdge.contains(acc) && acc != 11) {
                    4
                } else if (s == 'D' && !downEdge.contains(acc) && acc == 11) {
                    2
                } else {
                    0
                }
            }
            )

        }

        for (element in result) {
            var elementInStrg = element.toString()
            when (elementInStrg) {
                "10" -> elementInStrg = "A"
                "11" -> elementInStrg = "B"
                "12" -> elementInStrg = "C"
                "13" -> elementInStrg = "D"
            }
            resultStrg.add(elementInStrg)

        }
        println(resultStrg)

    }
}