package year2015

import utils.logMeasureTime
import java.io.File

class Day06 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2015/day06.txt").readLines()

            println("=== Part One ===")
            logMeasureTime {
                Day06().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day06().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {
        val gridSize = 1000
        val lightsOn = Array(gridSize) { BooleanArray(gridSize) { false } }

        for (line in lines) {
            val splittedSentence = line.split("\\s".toRegex()).toTypedArray()

            when {
                splittedSentence.contains("on") -> {
                    val indexOfNum1 = splittedSentence.indexOf("on") + 1
                    val indexOfNum2 = splittedSentence.indexOf("through") + 1

                    val splittedStart = splittedSentence[indexOfNum1].split(",".toRegex())
                    val splittedEnd = splittedSentence[indexOfNum2].split(",".toRegex())

                    for (x in splittedStart.first().toInt()..splittedEnd.first().toInt()) {
                        for (y in splittedStart.last().toInt()..splittedEnd.last().toInt()) {
                            lightsOn[x][y] = true
                        }
                    }
                }

                splittedSentence.contains("off") -> {
                    val indexOfNum1 = splittedSentence.indexOf("off") + 1
                    val indexOfNum2 = splittedSentence.indexOf("through") + 1

                    val splittedStart = splittedSentence[indexOfNum1].split(",".toRegex())
                    val splittedEnd = splittedSentence[indexOfNum2].split(",".toRegex())

                    for (x in splittedStart.first().toInt()..splittedEnd.first().toInt()) {
                        for (y in splittedStart.last().toInt()..splittedEnd.last().toInt()) {
                            lightsOn[x][y] = false
                        }
                    }
                }

                splittedSentence.contains("toggle") -> {
                    val indexOfNum1 = splittedSentence.indexOf("toggle") + 1
                    val indexOfNum2 = splittedSentence.indexOf("through") + 1

                    val splittedStart = splittedSentence[indexOfNum1].split(",".toRegex())
                    val splittedEnd = splittedSentence[indexOfNum2].split(",".toRegex())

                    for (x in splittedStart.first().toInt()..splittedEnd.first().toInt()) {
                        for (y in splittedStart.last().toInt()..splittedEnd.last().toInt()) {
                            lightsOn[x][y] = !lightsOn[x][y]
                        }
                    }
                }
            }
        }

        var lightsOnCount = 0
        for (x in 0 until gridSize) {
            for (y in 0 until gridSize) {
                if (lightsOn[x][y]) {
                    lightsOnCount++
                }
            }
        }
        println(lightsOnCount)
    }

    private fun partTwo(lines: List<String>) {
        val gridSize = 1000
        val lightsOn = Array(gridSize) { IntArray(gridSize) { 0 } }

        for (line in lines) {
            val splittedSentence = line.split("\\s".toRegex()).toTypedArray()

            when {
                splittedSentence.contains("on") -> {
                    val indexOfNum1 = splittedSentence.indexOf("on") + 1
                    val indexOfNum2 = splittedSentence.indexOf("through") + 1

                    val splittedStart = splittedSentence[indexOfNum1].split(",".toRegex())
                    val splittedEnd = splittedSentence[indexOfNum2].split(",".toRegex())

                    for (x in splittedStart.first().toInt()..splittedEnd.first().toInt()) {
                        for (y in splittedStart.last().toInt()..splittedEnd.last().toInt()) {
                            lightsOn[x][y] += 1
                        }
                    }
                }

                splittedSentence.contains("off") -> {
                    val indexOfNum1 = splittedSentence.indexOf("off") + 1
                    val indexOfNum2 = splittedSentence.indexOf("through") + 1

                    val splittedStart = splittedSentence[indexOfNum1].split(",".toRegex())
                    val splittedEnd = splittedSentence[indexOfNum2].split(",".toRegex())

                    for (x in splittedStart.first().toInt()..splittedEnd.first().toInt()) {
                        for (y in splittedStart.last().toInt()..splittedEnd.last().toInt()) {
                            lightsOn[x][y] = (lightsOn[x][y] - 1).coerceAtLeast(0)
                        }
                    }
                }

                splittedSentence.contains("toggle") -> {
                    val indexOfNum1 = splittedSentence.indexOf("toggle") + 1
                    val indexOfNum2 = splittedSentence.indexOf("through") + 1

                    val splittedStart = splittedSentence[indexOfNum1].split(",".toRegex())
                    val splittedEnd = splittedSentence[indexOfNum2].split(",".toRegex())

                    for (x in splittedStart.first().toInt()..splittedEnd.first().toInt()) {
                        for (y in splittedStart.last().toInt()..splittedEnd.last().toInt()) {
                            lightsOn[x][y] += 2
                        }
                    }
                }
            }
        }

        var lightsOnCount = 0
        for (x in 0 until gridSize) {
            for (y in 0 until gridSize) {

                    lightsOnCount += lightsOn[x][y]
                }
            }
        println(lightsOnCount)
    }
}