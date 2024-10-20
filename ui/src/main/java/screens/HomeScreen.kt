package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import components.BudgetText
import components.TransactionForm
import components.TransactionList
import data.UserTransaction
import theme.BudgetProTheme
import viewmodel.BudgetViewModel

@Composable
fun HomeScreen(vm: BudgetViewModel = viewModel()) {
    val income = vm.incomeList.collectAsState().value
    val expense = vm.expenseList.collectAsState().value
    val budget = vm.budget.collectAsState().value
    Home(income, expense, budget.amount, vm::addTransaction)
}

@Composable
fun Home(
    income: List<UserTransaction>,
    expense: List<UserTransaction>,
    budget: Int,
    onTransactionAdded: (UserTransaction) -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(red = 1, green = 46, blue = 81)
    ) {
        Column {
            BudgetText(budget = budget)
            TransactionForm(onTransactionAdded)
            TransactionList(title = "Income", userTransactions = income)
            TransactionList(title = "Expense", userTransactions = expense)
        }
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
                UserTransaction(2.00f, "Food", "income",),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
            ),
            budget = 1050
        ) {}
    }
}