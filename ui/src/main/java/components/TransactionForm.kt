package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var selectedValue by remember {
        mutableStateOf("")
    }
    var showDropdownMenu by remember {
        mutableStateOf(false)
    }

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
            TransactionType {
                selectedValue
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        val transaction = UserTransaction(
                            category = categoryState,
                            amount = amountState.toFloatOrNull() ?: 0f,
                            transactionType = selectedValue
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

@Composable
fun TransactionType(onValueChange: (String) -> Unit) {
    val items = listOf("Income", "Expense")
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedItem by remember {
        mutableStateOf(items[0])
    }
    Box( contentAlignment = Alignment.Center) {
        TextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            label = { Text("Transaction Type") },
            trailingIcon = {
                IconButton( onClick = {expanded = true}) {
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
                }
            }
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        items.forEach { item ->
            DropdownMenuItem(
                text = { Text(text = item) },
                onClick = {
                    selectedItem = item
                    onValueChange(selectedItem)
                    expanded = false
                })
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