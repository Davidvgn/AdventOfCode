package year2015

import utils.logMeasureTime
import java.io.File
import javax.xml.crypto.dsig.keyinfo.KeyValue

class Day03 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2015/day03.txt").readLines()


            println("=== Part One ===")
            logMeasureTime {
                Day03().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day03().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {
        val list: MutableList<Pair<Int, Int>> = mutableListOf(Pair(0, 0))

        lines.first().fold(0) { acc: Int, c: Char ->
            val result = getResult(c, list[acc])
            list.add(result)
            acc + 1
        }

        println(list.distinct().size)


    }

    private fun getResult(c: Char, coordinate: Pair<Int, Int>): Pair<Int, Int> {
        var absOrd = coordinate

        if (c == '^') {
            absOrd = Pair(absOrd.first, absOrd.second + 1)
        } else if (c == 'v') {
            absOrd = Pair(absOrd.first, absOrd.second - 1)
        } else if (c == '>') {
            absOrd = Pair(absOrd.first + 1, absOrd.second)
        } else {
            absOrd = Pair(absOrd.first - 1, absOrd.second)
        }

        return absOrd
    }


    private fun partTwo(lines: List<String>) {
        val santaList: MutableList<Pair<Int, Int>> = mutableListOf(Pair(0, 0))
        val robotSantaList: MutableList<Pair<Int, Int>> = mutableListOf(Pair(0, 0))

        val santaLines = getSantaLines(lines.first())
        val robotSantaLines = getRobotSantaLines(lines.first())

        santaLines.fold(0) { acc: Int, c: Char ->
            val result = getResult(c, santaList[acc])
            santaList.add(result)
            acc + 1
        }
        robotSantaLines.fold(0) { acc: Int, c: Char ->
            val result = getResult(c, robotSantaList[acc])
            robotSantaList.add(result)
            acc + 1
        }

        val bothList = santaList + robotSantaList

        println(bothList.distinct().size)
    }

    private fun getRobotSantaLines(sr: String): String {
        return sr.filterIndexed { index, _ ->
            index % 2 == 0
        }
    }

    private fun getSantaLines(sr: String): String {
        return sr.filterIndexed { index, _ ->
            index % 2 != 0
        }
    }
}


