package com.example.mvvminjetpackcompos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvminjetpackcompos.ui.theme.MvvmInJetpackComposTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        val counterViewModel: CounterViewModel = viewModel()
//        here its hows error , cause
        //        viewModel() is a Composable function and must be inside setContent{}.
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val counterViewModel: CounterViewModel = viewModel()//Now, counterViewModel is retrieved inside the Composable context.
            MvvmInJetpackComposTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(
                        counterViewModel ,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterApp(counterViewModel: CounterViewModel, modifier: Modifier = Modifier) {
    CounterScreen(
        count = counterViewModel.count.value,
        onIncrement = { counterViewModel.increaseCount() },
        onDecrement = { counterViewModel.decreasesCount() }
    )
}

@Composable
fun CounterScreen(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
) {

    val customTextLayout = TextStyle(
        fontSize = 24.sp,
        color = Color(0xFF02233B),
        fontFamily =
        FontFamily(
            Font(R.font.medium)
        )
    )
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(onClick = onIncrement, modifier = Modifier.padding(8.dp) , colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFBBDEFB),
            contentColor = Color(0xFF02233B)
        )) { Text( text = "Increment" ) }
        Text( text = count.toString() , style = customTextLayout , modifier = Modifier.padding(18.dp))
        Button( onClick = onDecrement , modifier = Modifier.padding(8.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFBBDEFB),
            contentColor = Color(0xFF02233B)
        ) ) { Text( text = "Decrement" ) }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    MvvmInJetpackComposTheme {
        CounterApp(counterViewModel = CounterViewModel())
    }
}