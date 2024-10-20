package data

import java.io.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

data class UserTransaction(
    val amount: Float? = 0f,
    val category: String? = "",
    val transactionType: String? = "",
    val date: LocalDate? = LocalDate.now(),
    val id: Int = 0,
) : Serializable
