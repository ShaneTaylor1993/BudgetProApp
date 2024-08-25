package viewmodel

import androidx.compose.ui.util.fastMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.UserTransaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import usecase.AddTransaction
import usecase.DeleteTransaction
import usecase.GetTransactions
import usecase.UpdateBudget
import javax.inject.Inject
import kotlin.math.exp

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val addTransaction: AddTransaction,
    deleteTransaction: DeleteTransaction,
    getTransactions: GetTransactions,
    updateBudget: UpdateBudget
): ViewModel() {

    private var _incomeList = MutableStateFlow(listOf(UserTransaction()))
    val incomeList = _incomeList
    private val _expenseList = MutableStateFlow(listOf(UserTransaction()))
    val expenseList = _expenseList

    init {
        viewModelScope.launch {
            val income = getTransactions.getTransactions("INCOME").map {
                it.map {
                    UserTransaction(
                        amount = it.transactionAmount,
                        category = it.transactionCategory,
                        transactionType = it.transactionType
                    )
                }
            }
            val expense = getTransactions.getTransactions("EXPENSE").map {
                it.map {
                    UserTransaction(
                        amount = it.transactionAmount,
                        category = it.transactionCategory,
                        transactionType = it.transactionType
                    )
                }
            }

            income.collect {
                _incomeList.emit(it)
            }
            expense.collect {
                _expenseList.emit(it)
            }
        }
    }

    fun addTransaction(userTransaction: UserTransaction) {
        viewModelScope.launch {
            addTransaction.addTransaction(
                userTransaction.transactionType,
                userTransaction.category,
                userTransaction.amount
            )
        }
    }




}