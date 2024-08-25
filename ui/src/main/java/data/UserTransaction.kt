package data

data class UserTransaction(
    val amount: Float? = 0f,
    val category: String? = "",
    val transactionType: String? = ""
)
