package components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.UserTransaction
import theme.BudgetProTheme

@Composable
fun TransactionList(title: String, userTransactions: List<UserTransaction>) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = title, textAlign = TextAlign.Center,
        color = Color.White
    )
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 12.dp),
        shape = RoundedCornerShape(topEnd = 0.dp, bottomEnd = 0.dp)
    ) {
        if (userTransactions.isEmpty()) {
            EmptyTransactionTable()
        } else {
            LazyColumn(modifier = Modifier.height(225.dp)) {
                items(userTransactions,
                    key = { transaction ->
                        transaction.id
                    }) { transaction ->
                    HorizontalDivider(color = Color.Black)
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = userTransaction.category ?: "")
            Text(text = "$${userTransaction.amount}")
        }
    }
}

@Composable
fun EmptyTransactionTable() {
    Surface {
        HorizontalDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "")
            Text(text = "")
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
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
            )
        )
    }

}