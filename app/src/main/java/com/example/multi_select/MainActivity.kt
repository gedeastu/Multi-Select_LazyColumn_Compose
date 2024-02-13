package com.example.multi_select

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multi_select.ui.theme.Multi_selectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Multi_selectTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main(){
    var items by remember {
        mutableStateOf(
            (1..20).map {
                ListItems(
                    title = "Item $it",
                    isSelected = false
                )
            }
        )
    }
    LazyColumn(modifier = Modifier.fillMaxSize(),content = {
        items(items.size){
            Row(modifier= Modifier
                .fillMaxWidth()
                .clickable {
                    items = items.mapIndexed{ j, item ->
                        if (it == j){
                            item.copy(isSelected = !item.isSelected)
                        }else{
                            item
                        }
                    }
                }
                .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Text(text = items[it].title)
                if (items[it].isSelected){
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Checked", tint = Color.Yellow)
                }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Multi_selectTheme {
        Main()
    }
}