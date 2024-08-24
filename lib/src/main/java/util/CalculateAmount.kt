package util

fun calculateAmount(operator: String, amount: Float): Float {
    return if (operator == "+") {
        amount
    } else {
        -amount
    }
}