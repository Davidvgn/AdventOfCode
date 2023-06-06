package utils

import java.io.File
import java.util.*

fun getPuzzleInput(companion: Any): List<String> {
    val day = companion::class.java.enclosingClass.simpleName.lowercase(Locale.getDefault())
/*
    val year = companion::class.java.enclosingClass.packageName.takeLast(4)
*/
    val year =0 ;

    return File("data/$year/$day.txt").readLines()
}