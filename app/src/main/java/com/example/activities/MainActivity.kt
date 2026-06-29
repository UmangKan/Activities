package com.example.activities

import android.R.attr.onClick
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activities.ui.theme.ActivitiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivitiesTheme {

            }
        }
    }
}

@Composable
fun ActivityVar()
{
    ActivitySelect(
        activity1 = stringResource(R.string.activity_1),
        onClick = {
            println("TODO")
        }
    )
}
@Composable
fun ActivitySelect(activity1: String, modifier: Modifier = Modifier,onClick: () -> Unit){
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = activity1,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { onClick()}){
            Text("Go to")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActivitiesTheme {
        ActivitySelect("Activity") { }
    }
}