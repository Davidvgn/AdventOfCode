package year2015

import utils.logMeasureTime
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

class Day04 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2015/day04.txt").readLines()

            println("=== Part One ===")
            logMeasureTime {
                Day04().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day04().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {


        fun md5Hash(input: ByteArray): String {
            val md = MessageDigest.getInstance("MD5")
            val digest = md.digest(input)
            val bigInt = BigInteger(1, digest)
            return bigInt.toString(16).padStart(32, '0')
        }

        fun findNumberForLetters(letters: String): Long? {
            var number = 0L
            val prefixZeros = "00000"

            while (true) {
                val hash = md5Hash((letters + number).toByteArray())

                if (hash.startsWith(prefixZeros)) {
                    return number
                }

                number++
            }
        }

        val num = findNumberForLetters(lines.first())
        println(num)

    }

    private fun partTwo(lines: List<String>) {

        fun md5Hash(input: ByteArray): String {
            val md = MessageDigest.getInstance("MD5")
            val digest = md.digest(input)
            val bigInt = BigInteger(1, digest)
            return bigInt.toString(16).padStart(32, '0')
        }

        fun findNumberForLetters(letters: String): Long? {
            var number = 0L
            val prefixZeros = "000000"

            while (true) {
                val hash = md5Hash((letters + number).toByteArray())

                if (hash.startsWith(prefixZeros)) {
                    return number
                }

                number++
            }
        }

        val num = findNumberForLetters(lines.first())
        println(num)

        }
}