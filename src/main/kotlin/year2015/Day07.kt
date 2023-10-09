package year2015

import utils.logMeasureTime
import java.io.File

class Day07 {

    companion object {
        private val REGEX_ASSIGN = Regex("^(([0-9]|[a-z])+) -> ([a-z]+)$")
        private val REGEX_BITWISE = Regex("^(([0-9]|[a-z])+) (AND|OR|LSHIFT|RSHIFT) (([0-9]|[a-z])+) -> ([a-z]+)$")
        private val REGEX_NOT = Regex("^NOT ([a-z]+) -> ([a-z]+)$")

        @JvmStatic
        fun main(args: Array<String>) {
            val lines = File("data/2015/day07.txt").readLines()

            println("=== Part One ===")
            logMeasureTime {
                Day07().partOne(lines)
            }
            println()

            println("=== Part Two ===")
            logMeasureTime {
                Day07().partTwo(lines)
            }
            println()
        }
    }

    private fun partOne(lines: List<String>) {
        val variableNameValues = mutableMapOf<Variable.Named, Variable>()

        lines.map {
            val matchResultAssign = REGEX_ASSIGN.find(it)

            if (matchResultAssign != null) {
                val variable = matchResultAssign.groupValues[1]
                val variableAsInt = variable.toIntOrNull()

                Operation.Assign(
                    variable = if (variableAsInt != null) {
                        Variable.Value(variableAsInt)
                    } else {
                        Variable.Named(variable)
                    },
                    variableResult = Variable.Named(matchResultAssign.groupValues[3])
                )
            } else {
                val matchResultBitwise = REGEX_BITWISE.find(it)

                if (matchResultBitwise != null) {
                    val variable1 = matchResultBitwise.groupValues[1]
                    val variable1AsInt = variable1.toIntOrNull()
                    val variable2 = matchResultBitwise.groupValues[4]
                    val variable2AsInt = variable2.toIntOrNull()
                    Operation.Bitwise(
                        variable1 = if (variable1AsInt != null) {
                            Variable.Value(variable1AsInt)
                        } else {
                            Variable.Named(variable1)
                        },
                        variable2 = if (variable2AsInt != null) {
                            Variable.Value(variable2AsInt)
                        } else {
                            Variable.Named(variable2)
                        },
                        variableResult = Variable.Named(matchResultBitwise.groupValues[6]),
                        operator = Operator.valueOf(matchResultBitwise.groupValues[3])
                    )
                } else {
                    val matchResultNot = REGEX_NOT.find(it)

                    if (matchResultNot != null) {
                        Operation.Not(
                            variableName = matchResultNot.groupValues[1],
                            variableResult = matchResultNot.groupValues[2],
                        )
                    } else {
                        throw IllegalStateException("Unknown pattern : $it")
                    }
                }
            }
        }.forEach { operation ->
            when (operation) {
                is Operation.Assign -> variableNameValues[operation.variableResult] = operation.variable
                is Operation.Bitwise -> {
//                    val variable1Resolved: Int = if (operation.variable1 is Variable.Value) {
//                        operation.variable1.value
//                    } else {
//
//                        variableNameValues[operation.variable1]
//                    }
//
//                    val variable2Resolved: Int = if (operation.variable2 is Variable.Value) {
//                        operation.variable2.value
//                    } else {
//                        variableNameValues[operation.variable2]!!
//                    }
//
//                    when (operation.operator) {
//                        Operator.AND -> variableNameValues[operation.variableResult] =
//                            variable1Resolved and variable2Resolved
//
//                        Operator.OR -> variableNameValues[operation.variableResult] =
//                            variable1Resolved or variable2Resolved
//
//                        Operator.LSHIFT -> variableNameValues[operation.variableResult] =
//                            variable1Resolved shl variable2Resolved
//
//                        Operator.RSHIFT -> variableNameValues[operation.variableResult] =
//                            variable1Resolved shr variable2Resolved
//                    }
                }

                is Operation.Not -> TODO()
            }
        }


        println(variableNameValues)
    }

    private fun partTwo(lines: List<String>) {
        println()
    }

    sealed class Operation {
        data class Assign(
            val variable: Variable,
            val variableResult: Variable.Named,
        ) : Operation()

        data class Bitwise(
            val variable1: Variable,
            val variable2: Variable,
            val variableResult: Variable.Named,
            val operator: Operator,
        ) : Operation()

        data class Not(
            val variableName: String,
            val variableResult: String,
        ) : Operation()
    }

    sealed class Variable {
        data class Value(val value: Int) : Variable()
        data class Named(val name: String) : Variable()
    }

    enum class Operator {
        AND,
        OR,
        LSHIFT,
        RSHIFT,
    }
}