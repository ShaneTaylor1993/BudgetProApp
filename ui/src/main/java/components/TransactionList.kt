package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.UserTransaction
import theme.BudgetProTheme

@Composable
fun TransactionList(title: String, userTransactions: List<UserTransaction>) {
    Card(
        shape = RectangleShape
    ) {
        Text(text = title)
        LazyColumn {
            items(userTransactions) { transaction ->
                Card {
                    HorizontalDivider()
                    TransactionItem(transaction)
                }
            }

        }
    }
}

@Composable
fun TransactionItem(userTransaction: UserTransaction) {
    Surface {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = userTransaction.category)
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = userTransaction.amount.toString())
        }
    }


}

@Preview
@Composable
fun TransactionListPreview() {
    BudgetProTheme {
        TransactionList(
            title = "Income",
            userTransactions = listOf(
                UserTransaction(2.00f, "Food"),
                UserTransaction(2.00f, "Food"),
                UserTransaction(2.00f, "Food"),
                UserTransaction(2.00f, "Food")
            )
        )
    }

}