package viewmodel

import androidx.compose.ui.util.fastMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.UserTransaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import usecase.AddTransaction
import usecase.DeleteTransaction
import usecase.GetTransactions
import usecase.UpdateBudget
import javax.inject.Inject
import kotlin.math.exp

@HiltViewModel
class BudgetViewModel @Inject constructor(
    addTransaction: AddTransaction,
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
                UserTransaction(
                    amount = it.transactionAmount,
                    category = it.transactionCategory,
                    transactionType = it.transactionType
                )
            }
            val expense = getTransactions.getTransactions("EXPENSE").map {
                UserTransaction(
                    amount = it.transactionAmount,
                    category = it.transactionCategory,
                    transactionType = it.transactionType
                )
            }

            _incomeList.emit(income)
            _expenseList.emit(expense)
        }
    }




}