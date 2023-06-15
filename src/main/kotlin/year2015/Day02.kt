package year2015

import utils.logMeasureTime
import java.io.File

class Day02 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2015/day02.txt").readLines()

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

        val result = lines.fold(0) { acc: Int, formula: String ->
            acc + getArea(formula)
        }
        println(result)
    }


    private fun getArea(formula: String) : Int {

        val numbers: List<Int> = formula.split('x').map {it.toInt()}
        var ope = 2 * numbers[0] * numbers[1] + 2 * numbers[0] * numbers[2] + 2 * numbers[1] * numbers[2]
        var opePlusMin = ope + numbers.min() * numbers.sorted()[1]

       return opePlusMin

    }

    private fun partTwo(lines: List<String>) {
        val result = lines.fold(0) { acc: Int, formula: String ->
            acc + getRibbonNeeded(formula)
        }
        println(result)
    }
    private fun getRibbonNeeded(formula: String) : Int {

        val numbers: List<Int> = formula.split('x').map {it.toInt()}
        var wrapPresent = numbers.min() * 2 + numbers.sorted()[1] * 2
        var bowPlusWrapPresent = numbers[0] * numbers[1] * numbers [2] + wrapPresent

        return bowPlusWrapPresent

    }
}