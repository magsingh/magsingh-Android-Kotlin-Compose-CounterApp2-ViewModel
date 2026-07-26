package com.example.compose_counterapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_counterapp.ui.theme.ComposeCounterAppTheme
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val counterViewModel: CounterViewModel = viewModel()
            ComposeCounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (
                        modifier = Modifier.fillMaxWidth().padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Counter App", fontSize = 40.sp)
                        Row(
                            modifier = Modifier.padding(vertical = 50.dp)
                        ) {
                            Text(text = "Count = ", fontSize = 20.sp)
                            Text(text = counterViewModel.count.toString(), fontSize = 20.sp,
                                color = if (counterViewModel.count >= 0) Color.Green else Color.Red
                                )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 50.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Button(
                                onClick = {
                                    counterViewModel.increment()
                                    Log.d("MAGS", "+ btn clicked")
                                },
                                modifier = Modifier.width(100.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                            ) {
                                Text(text = "+", fontSize = 20.sp)
                            }
                            Button(
                                onClick = {
                                    counterViewModel.decrement()
                                    //counterViewModel.count=500 //Gives error since count is private
                                    Log.d("MAGS", "- btn clicked")
                                },
                                modifier = Modifier.width(100.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                            ) {
                                Text(text = "-", fontSize = 20.sp)
                            }
                        }
                        Button(
                            onClick = {
                                counterViewModel.reset()
                                Log.d("MAGS", "reset btn clicked")
                            },
                            modifier = Modifier.width(200.dp),
                            enabled = (counterViewModel.count >= 5 || counterViewModel.count <= -5)
                        ) {
                            Text(text = "Reset")
                        }
                    }
                }
            }
        }
    }
}
