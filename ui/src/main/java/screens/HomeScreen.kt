package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import components.TransactionForm
import components.TransactionList
import data.UserTransaction
import viewmodel.BudgetViewModel

@Composable
fun HomeScreen(vm: BudgetViewModel = viewModel()) {
    val income = vm.incomeList.collectAsState().value
    val expense = vm.expenseList.collectAsState().value
    Home(income, expense)
}

@Composable
fun Home(
    income: List<UserTransaction>,
    expense: List<UserTransaction>,
) {
    Column {
        TransactionForm()
        TransactionList(title = "Income", userTransactions = income)
        TransactionList(title = "Expense", userTransactions = expense)
    }
}