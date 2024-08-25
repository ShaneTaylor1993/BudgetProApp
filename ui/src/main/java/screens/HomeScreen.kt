package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import components.TransactionForm
import components.TransactionList
import data.UserTransaction
import theme.BudgetProTheme
import viewmodel.BudgetViewModel

@Composable
fun HomeScreen(vm: BudgetViewModel = viewModel()) {
    val income = vm.incomeList.collectAsState().value
    val expense = vm.expenseList.collectAsState().value
    Home(income, expense, vm::addTransaction)
}

@Composable
fun Home(
    income: List<UserTransaction>,
    expense: List<UserTransaction>,
    onTransactionAdded: (UserTransaction) -> Unit
) {
    Column {
        TransactionForm(onTransactionAdded)
        TransactionList(title = "Income", userTransactions = income)
        TransactionList(title = "Expense", userTransactions = expense)
    }
}

@Composable
@Preview
fun PreviewHome() {
    BudgetProTheme {
        Home(
            income = listOf(
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
            ),
            expense = listOf(
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
            )
        ) {}
    }
}