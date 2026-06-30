package com.example.activities

import android.R.attr.onClick
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.activities.ui.theme.ActivitiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivitiesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ActivityVar()
                }

            }
        }
    }
}

@Composable
fun ActivityVar()
{
    val context = LocalContext.current
    ActivitySelect(
        activity1 = stringResource(R.string.activity_1),
        onClick = {
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)

        }
    )
}
@Composable
fun ActivitySelect(activity1: String, modifier: Modifier = Modifier,onClick: () -> Unit){
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
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