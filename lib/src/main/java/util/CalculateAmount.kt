package util

fun calculateAmount(operator: String, transactionAmount: Int, budgetAmount: Int): Int {
    return if (operator == "+") {
        budgetAmount + transactionAmount
    } else {
        budgetAmount - transactionAmount
    }
}