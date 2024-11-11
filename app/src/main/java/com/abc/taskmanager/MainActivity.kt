package com.abc.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abc.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CompletedTasksScreen(
                        Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
// The solution does not pass the modifier
fun CompletedTasksScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier, // For some reason, the solution has a modifier.fillMaxWidth().fillMaxHeight()
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.tasks_completed),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.praise),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskCompletedPreview() {
    TaskManagerTheme {
        CompletedTasksScreen(Modifier.fillMaxSize())
    }
}