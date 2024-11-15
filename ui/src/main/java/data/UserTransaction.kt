package data

import java.io.Serializable
import java.time.LocalDate

data class UserTransaction(
    val amount: Float? = 0f,
    val category: String? = "",
    val transactionType: String? = "",
    val date: LocalDate? = LocalDate.now(),
    val id: Int = 0,
) : Serializable {
    val formattedCategory: String
        get() {
            return category?.replaceFirstChar { it.uppercase() } ?: ""
        }
}
