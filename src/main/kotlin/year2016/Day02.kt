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
        val firstElement = lines[0]
        val secondElement = lines[1]
        val thirdElement = lines[2]
        val fourthElement = lines[3]
        val fifthElement = lines[4]
        var xFirst = 5
        var xSecond: Int
        var xThird: Int
        var xFourth: Int
        var xFifth: Int


        println(firstElement.fold(0) { acc: Int, s: Char ->
            if (s == 'L' && xFirst != 1 && xFirst != 4 && xFirst != 7) {
                xFirst -= 1

            } else if (s == 'R' && xFirst != 3 && xFirst != 6 && xFirst != 9) {

                xFirst += 1

            } else if (s == 'U' && xFirst != 1 && xFirst != 2 && xFirst != 3) {

                xFirst -= 3

            } else if (s == 'D' && xFirst != 7 && xFirst != 8 && xFirst != 9) {

                xFirst += 3

            }
            acc

        }
        )
        println ("x = $xFirst")



        xSecond = xFirst
        println ("x2 before = $xSecond")

        println(secondElement.fold(0){
                acc: Int, s: Char ->
            if (s == 'L' && xSecond != 1 && xSecond != 4 && xSecond != 7){
                xSecond -=1
            } else if ( s == 'R' && xSecond != 3 && xSecond != 6 && xSecond != 9 ){
                xSecond += 1

            } else if ( s == 'U'&& xSecond != 1 && xSecond != 2 && xSecond != 3 ){
                xSecond -= 3

            } else if ( s == 'D'&& xSecond != 7 && xSecond != 8 && xSecond != 9 ){
                xSecond += 3
            }

            acc

        })
        println("x2 = $xSecond")






        xThird = xSecond
        println ("x3 before = $xThird")

        println(thirdElement.fold(0){
                acc: Int, s: Char ->
            if (s == 'L' && xThird != 1 && xThird != 4 && xThird != 7){
                xThird -=1
            } else if ( s == 'R' && xThird != 3 && xThird != 6 && xThird != 9 ){
                xThird += 1

            } else if ( s == 'U'&& xThird != 1 && xThird != 2 && xThird != 3 ){
                xThird -= 3

            } else if ( s == 'D'&& xThird != 7 && xThird != 8 && xThird != 9 ){
                xThird += 3
            }

            acc

        })
        println("x3 = $xThird")





        xFourth = xThird
        println ("x4 before = $xFourth")

        println(fourthElement.fold(0){
                acc: Int, s: Char ->
            if (s == 'L' && xFourth != 1 && xFourth != 4 && xFourth != 7){
                xThird -=1
            } else if ( s == 'R' && xFourth != 3 && xFourth != 6 && xFourth != 9 ){
                xFourth += 1

            } else if ( s == 'U'&& xFourth != 1 && xFourth != 2 && xFourth != 3 ){
                xFourth -= 3

            } else if ( s == 'D'&& xFourth != 7 && xFourth != 8 && xFourth != 9 ){
                xFourth += 3
            }

            acc

        })
        println("x4 = $xFourth")






        xFifth = xFourth
        println ("x5 before = $xFifth")

        println(fifthElement.fold(0){
                acc: Int, s: Char ->
            if (s == 'L' && xFifth != 1 && xFifth != 4 && xFifth != 7){
                xFifth -=1
            } else if ( s == 'R' && xFifth != 3 && xFifth != 6 && xFifth != 9 ){
                xFifth += 1

            } else if ( s == 'U'&& xFifth != 1 && xFifth != 2 && xFifth != 3 ){
                xFifth -= 3

            } else if ( s == 'D'&& xFifth != 7 && xFifth != 8 && xFifth != 9 ){
                xFifth += 3
            }

            acc

        })
        println("x5 = $xFifth")
        println("$xFirst / $xSecond / $xThird / $xFourth / $xFifth")

    }


    private fun partTwo(lines: List<String>) {
        println(lines.size)
    }
}