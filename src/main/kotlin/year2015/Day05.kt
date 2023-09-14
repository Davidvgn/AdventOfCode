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
                char in listOf('a', 'e', 'i', 'o', 'u')
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
        println(
            lines.count { line: String ->
                // Rule 1: Check for pairs of characters that appear at least twice without overlapping.
                val hasPairTwice = hasRepeatingPair(line)

                // Rule 2: Check for a letter that repeats with exactly one letter between them.
                val hasRepeatingLetterWithOneBetween = hasRepeatingLetterWithOneBetween(line)

                // Both rules must be satisfied for the string to be nice.
                hasPairTwice && hasRepeatingLetterWithOneBetween
            }
        )
    }

    private fun hasRepeatingPair(line: String): Boolean {
        val pairs = mutableSetOf<String>()
        for (i in 0 until line.length - 1) {
            val pair = line.substring(i, i + 2)
            if (pairs.contains(pair)) {
                return true
            }
            if (line.indexOf(pair, i + 2) != -1) {
                pairs.add(pair)
            }
        }
        return false
    }

    private fun hasRepeatingLetterWithOneBetween(line: String): Boolean {
        for (i in 0 until line.length - 2) {
            if (line[i] == line[i + 2]) {
                return true
            }
        }
        return false
    }
}

//    private fun partTwo(lines: List<String>) {
//        println(
//            lines.count { line: String ->
//
//                val pairsWithIndex = line.mapIndexedNotNull { index, char ->
//                    line.getOrNull(index + 1)?.let { next ->
//                        PairWithIndex(
//                            index = index,
//                            firstChar = char,
//                            secondChar = next
//                        )
//                    }
//                }
//
//                if (
//                    pairsWithIndex.any { pair ->
//                        pairsWithIndex.find { possibleMatchPair ->
//                            pair.firstChar == possibleMatchPair.firstChar
//                                && pair.secondChar == possibleMatchPair.secondChar
//                                && pair.index + 2 < possibleMatchPair.index
//                        } != null
//                    }
//                ) {
//
//                    val groupOfThree = line.windowed(3, 1)
//                    for (i in groupOfThree) {
//                        if (i.first() == i.last()) {
//                            return@count true
//                        }
//                    }
//                }
//                false
//            }
//        )
//    }
//
//    data class PairWithIndex(
//        val index: Int,
//        val firstChar: Char,
//        val secondChar: Char
//    )
//}