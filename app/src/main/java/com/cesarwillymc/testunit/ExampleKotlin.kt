package com.cesarwillymc.testunit

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */

const val ZERO = 0
const val SPACE = ' '
const val ONE = 1
const val TWO = 2
const val THREE = 3
const val SEVEN = 7

fun getNumbersByReadLine(size: Int): List<Int> {
    var resultArray = listOf<String>()
    var isCorrect = false
    while (!isCorrect) {
        println("Now!! You need add $size numbers: ")
        resultArray = readLine()!!.split(SPACE)
        isCorrect = resultArray.size == size
        if(!isCorrect)
            print("Error ->>>")
    }
    return resultArray.map { it.toInt() }
}

fun getHappinessScore(elements: List<Int>, groupA: List<Int>, groupB: List<Int>): Int {
    var score = ZERO
    elements.forEach { number ->
        when {
            groupA.contains(number) -> score++
            groupB.contains(number) -> score--
            else -> {
                if (number == ONE || number == THREE) score++
            }
        }
    }
    return score
}

fun main(args: Array<String>) {

    val (n, m) = getNumbersByReadLine(TWO)

    val elements = getNumbersByReadLine(n)
    val a = getNumbersByReadLine(m)
    val b = getNumbersByReadLine(m).distinctBy { it == SEVEN }

    println("Your score is: ${getHappinessScore(elements, a, b)}")
}