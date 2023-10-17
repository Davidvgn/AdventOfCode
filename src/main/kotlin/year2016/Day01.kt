package year2016

import utils.logMeasureTime
import java.io.File
import kotlin.math.absoluteValue

class Day01 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2016/day01.txt").readLines()

            println("=== Part One ===")
            logMeasureTime {
                Day01().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day01().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {

        val splitLines = lines.flatMap { entry -> entry.replace(" ", "").split(",") }

        var x = 0
        var y = 0
        var isNegative = false
        var isAbscissa = true

        for (element in splitLines.indices) {
            val elementPaired = getElementPaired(splitLines[element])

            if (isAbscissa) {
                if (!isNegative) {
                    if (elementPaired.first == 'R') {
                        x += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        x += elementPaired.second.toInt() * -1
                        isNegative = true
                    }
                } else {
                    if (elementPaired.first == 'L') {
                        x += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        x += elementPaired.second.toInt() * -1
                        isNegative = true
                    }
                }
            } else {
                if (!isNegative) {
                    if (elementPaired.first == 'L') {
                        y += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        y += elementPaired.second.toInt() * -1
                        isNegative = true
                    }
                } else {
                    if (elementPaired.first == 'R') {
                        y += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        y += elementPaired.second.toInt() * -1
                        isNegative = true
                    }
                }
            }
            isAbscissa = !isAbscissa
        }
        println(x.absoluteValue + y.absoluteValue)

    }

    private fun getElementPaired(element: String): Pair<Char, String> {
        val withoutLetter = element.replace(Regex("[RL]"), "")

        return Pair(element.first(), withoutLetter)

    }

    private fun partTwo(lines: List<String>) {
        val splitLines = lines.flatMap { entry -> entry.replace(" ", "").split(",") }

        var x = 0
        var y = 0
        var isNegative = false
        var isAbscissa = true
        var listOfPoint: MutableList<Pair<Int, Int>> = mutableListOf()
        var indices = 1

        listOfPoint.add(0, Pair(x, y))

        for (element in splitLines.indices) {
            val elementPaired = getElementPaired(splitLines[element])

            if (isAbscissa) {
                if (!isNegative) {
                    if (elementPaired.first == 'R') {
                        x += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        x += elementPaired.second.toInt() * -1
                        isNegative = true

                    }
                } else {
                    if (elementPaired.first == 'L') {
                        x += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        x += elementPaired.second.toInt() * -1
                        isNegative = true
                    }
                }


                if (listOfPoint[indices - 1].first < x) {
                    for (i in listOfPoint[indices - 1].first..x) {
                        if (i > listOfPoint[indices - 1].first && i < x) {
                            listOfPoint.add(indices++, Pair(i, y))
                        }
                    }
                } else {

                    for (i in listOfPoint[indices - 1].first downTo x) {
                        if (i < listOfPoint[indices - 1].first && i > x) {
                            listOfPoint.add(indices++, Pair(i, y))
                        }
                    }
                }
            } else {
                if (!isNegative) {
                    if (elementPaired.first == 'L') {
                        y += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        y += elementPaired.second.toInt() * -1
                        isNegative = true
                    }
                } else {
                    if (elementPaired.first == 'R') {
                        y += elementPaired.second.toInt()
                        isNegative = false
                    } else {
                        y += elementPaired.second.toInt() * -1
                        isNegative = true
                    }
                }

                if (listOfPoint[indices - 1].second < y) {
                    for (i in listOfPoint[indices - 1].second..y) {
                        if (i > listOfPoint[indices - 1].second && i < y) {

                            listOfPoint.add(indices++, Pair(x, i))
                        }
                    }
                } else {

                    for (i in listOfPoint[indices - 1].second downTo y) {
                        if (i < listOfPoint[indices - 1].second && i > y) {

                            listOfPoint.add(indices++, Pair(x, i))
                        }
                    }
                }

            }
            isAbscissa = !isAbscissa

                listOfPoint.add(indices++, Pair(x, y))

        }

        println(listOfPoint.groupingBy { it }.eachCount().filter { it.value > 1 }.firstNotNullOf { it })

    }
}