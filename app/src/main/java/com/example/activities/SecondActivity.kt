package com.example.activities

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activities.ui.theme.ActivitiesTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val data = intent.extras

            val messageExtra1 = data?.getString(Constants.INTENT_MESSAGE_KEY) ?:"No Message"
            val messageExtra2 = data?.getString(Constants.INTENT_MESSAGE2_KEY)?:"No Message"
            val numberExtra = data?.getDouble(Constants.INTENT_NUMBER_KEY) ?: 0.0

        setContent {
            ActivitiesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SecondActivityApp(
                        messageExtra1,
                        messageExtra2,
                        numberExtra
                    )
                }
            }
        }
    }
}

@Composable
fun SecondActivityApp(message1: String, message2: String, number: Double)
{
    ActivityCard(
        activity2 = stringResource(R.string.activity_2),
        receivedMessage1 = message1,
        receivedMessage2 = message2,
        receivedNumber = number,
        onClick = {
            val intent = Intent(context, MainActivity::class.java)

        }

    )
}

@Composable
fun ActivityCard(activity2: String, receivedMessage1: String, receivedMessage2: String, receivedNumber: Double,onClick: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = activity2,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Message1: $receivedMessage1",
            fontSize = 20.sp,
            modifier= Modifier.padding(16.dp)
        )
        Text(
            text = "Message2: $receivedMessage2",
            fontSize = 20.sp,
            modifier= Modifier.padding(16.dp)
        )
        Text(
            text = "Number: $receivedNumber",
            fontSize = 20.sp,
            modifier= Modifier.padding(16.dp)
        )
        Button(onClick = {onClick()})
        {
            Text("Go Back")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun SecondActivityPreview() {
    ActivitiesTheme {
        ActivityCard("Activity 2",
            "message1",
            "message 2",
            3.14,
            {}
            )
    }
}