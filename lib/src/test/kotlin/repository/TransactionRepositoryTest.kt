package repository

import data.Transaction
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import service.TransactionDao
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
class TransactionRepositoryTest {

    @MockK
    lateinit var service: TransactionDao

    private lateinit var repo: TransactionRepository

    private val transactions = listOf(
        Transaction(2, "income", "food", 1.00f),
        Transaction(2, "income", "food", 1.00f)
    )

    private val transaction = Transaction(2, "income", "food", 1.00f)


    fun setup() {
        MockKAnnotations.init(this)
        repo = TransactionRepository(service)
    }

    @Test
    fun testGetListOfTransactionsReturnListOfTransactions() = runTest {
        every { service.getListByType("income") } returns transactions.asFlow()
        service.addTransaction(transaction)
        val flow = service.getListByType("income")
        val result = flow.first()
        assertEquals(result, transactions)
    }


}