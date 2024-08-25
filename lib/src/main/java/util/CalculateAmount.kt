package util

fun calculateAmount(operator: String, amount: Int): Int {
    return if (operator == "+") {
        amount
    } else {
        -amount
    }
}