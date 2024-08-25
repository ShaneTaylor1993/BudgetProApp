package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.UserTransaction
import theme.BudgetProTheme

@Composable
fun TransactionForm(
    onTransactionAdded: (UserTransaction) -> Unit
) {
    var categoryState by remember { mutableStateOf("") }
    var amountState by remember { mutableStateOf("") }
    var transactionTypeState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Card {
            TextField(
                modifier = Modifier,
                value = categoryState,
                onValueChange = { categoryState = it },
                label = { Text("Category") }
            )
            TextField(
                value = amountState,
                onValueChange = { amountState = it },
                label = { Text("Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = transactionTypeState,
                onValueChange = { transactionTypeState = it },
                label = { Text("Transaction Type") }
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        val transaction = UserTransaction(
                            category = categoryState,
                            amount = amountState.toFloatOrNull() ?: 0f,
                            transactionType = transactionTypeState.uppercase()
                        )
                        onTransactionAdded(transaction)
                    }
                ) {
                    Text("Add Transaction")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Handle cancel action */ }
                ) {
                    Text("Cancel")
                }
            }
        }
    }

}

@Preview
@Composable
fun Preview_TransactionForm() {
    BudgetProTheme {
        TransactionForm() {}
    }
}