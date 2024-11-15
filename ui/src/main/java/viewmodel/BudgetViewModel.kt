package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.Budget
import data.UserTransaction
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import usecase.AddBudget
import usecase.AddTransaction
import usecase.DeleteTransaction
import usecase.GetBudget
import usecase.GetTransactions
import usecase.UpdateBudget
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val addTransaction: AddTransaction,
    deleteTransaction: DeleteTransaction,
    getTransactions: GetTransactions,
    val updateBudget: UpdateBudget,
    getBudget: GetBudget,
    addBudget: AddBudget
) : ViewModel() {

    private var _incomeList = MutableStateFlow(listOf(UserTransaction()))
    val incomeList = _incomeList
    private val _expenseList = MutableStateFlow(listOf(UserTransaction()))
    val expenseList = _expenseList
    private var _budget = MutableStateFlow(Budget(amount = 0))
    val budget = _budget

    init {
        viewModelScope.launch {
            val income = getTransactions.getTransactions("Income").map {
                it.map {
                    UserTransaction(
                        id = it.id,
                        amount = it.transactionAmount,
                        category = it.transactionCategory,
                        transactionType = it.transactionType
                    )
                }
            }
            income.collect {
                _incomeList.emit(it)
            }
        }

        viewModelScope.launch {
            val expense = getTransactions.getTransactions("Expense").map {
                it.map {
                    UserTransaction(
                        id = it.id,
                        amount = it.transactionAmount,
                        category = it.transactionCategory,
                        transactionType = it.transactionType
                    )
                }
            }
            expense.collect {
                _expenseList.emit(it)
            }
        }

        viewModelScope.launch {
            val budgetFlow = getBudget.getBudget()
            budgetFlow.collect {
                if (it == null) {
                    addBudget(Budget(amount = 2000))
                    //_budget.emit(Budget(amount = 2000))
                } else
                    _budget.emit(Budget(amount = it.amount ))
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
            calculateBudget(userTransaction.transactionType, userTransaction.amount ?: 0f)
        }
    }

    private fun calculateBudget(transactionType: String?, amount: Float) {
        viewModelScope.launch {
            when (transactionType) {
                "Income" -> updateBudget.updateBudget(
                    operator = "+",
                    transactionAmount = amount.toInt(),
                    budgetAmount = budget.value.amount
                )
                "Expense" -> updateBudget.updateBudget(
                    operator = "-",
                    transactionAmount = amount.toInt(),
                    budgetAmount = budget.value.amount)
            }
        }
    }
}