package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodeLabTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			BasicCodeLabTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					MyApp()
				}
			}
		}
	}


	@Composable
	fun MyApp(
		modifier: Modifier = Modifier,
		names: List<String> = listOf("World", "Compose")
	) {
		Column(modifier) {
			for (name in names) {
				Greeting(name = name)
			}
		}
	}

	@Composable
	fun Greeting(name: String, modifier: Modifier = Modifier) {
		Surface(color = MaterialTheme.colorScheme.primary) {
			Column(modifier = modifier.padding(24.dp)) {
				Text(text = "Hello ")
				Text(text = name)
			}
		}
	}

	@Preview(showBackground = true)
	@Composable
	fun GreetingPreview() {
		BasicCodeLabTheme {
			MyApp()
		}
	}
}
