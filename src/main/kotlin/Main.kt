package ru.netology

import kotlin.math.max

const val ERROR_TIPE = -1
const val ERROR_LIMIT = -2
fun main() {
    println(commission("MasterCard", 100_000, 0))
}
// расчет комиссии
fun commission(typeCard: String, transfer: Int, previous: Int): Int = when (typeCard) {
    "MasterCard", "Maestro" -> if (transfer <= 150_000 && transfer + previous <= 600_000) {
        if (transfer + previous >= 75_000)(transfer * 0.006 + 20).toInt() else 0
    } else {
        ERROR_LIMIT
    }
    "Visa", "Мир" -> if (transfer <= 150_000 && transfer + previous <= 600_000) {
        max(35, (transfer * 0.0075).toInt())
    } else {
        ERROR_LIMIT
    }
    "VK Pay" -> if (transfer <= 15_000 && transfer + previous <= 40_000) 0 else ERROR_LIMIT
    else -> ERROR_TIPE
}