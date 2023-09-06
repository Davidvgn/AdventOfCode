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
        val naughtWordsRegex = ".*(ab|cd|pq|xy).*".toRegex()

        println(lines.fold(0) { acc: Int, s: String ->
            val vowelCount = s.count { char ->
                char in listOf('a', 'e', 'i','o', 'u' )
            }

            val hasSubsequentLetterTwiceInARow = s.zipWithNext().find { it.first == it.second } != null

            if (vowelCount >= 3 && hasSubsequentLetterTwiceInARow && !naughtWordsRegex.matches(s)) {
             acc + 1
            } else {
                acc
            }
        })
    }
    //--------------   Version plus concise :
//    private fun partOne(lines: List<String>) {
//        val naughtyWordsRegex = ".*(ab|cd|pq|xy).*".toRegex()
//
//        println(lines.count { s ->
//            val vowelCount = s.count { char -> char in listOf('a', 'e', 'i', 'o', 'u') }
//            val hasSubsequentLetterTwiceInARow = s.zipWithNext().any { it.first == it.second }
//
//            vowelCount >= 3 && hasSubsequentLetterTwiceInARow && !naughtyWordsRegex.matches(s)
//        })
//    }

    private fun partTwo(lines: List<String>) {
    }
}