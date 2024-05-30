package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodeLabTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			BasicCodeLabTheme {
				MyApp()

			}
		}
	}

	@Composable
	fun OnBoardScreen(modifier: Modifier = Modifier) {
		var shouldShowOnboarding  by remember { mutableStateOf(true) }

		Column (
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text("Welcome to the basic code lab")
			Button(
				modifier = Modifier.padding(vertical = 24.dp),
				onClick = { shouldShowOnboarding = false }
			) {
				Text("Continue")
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
		val expanded = remember { mutableStateOf(false) }
		val extraPadding = if (expanded.value) 48.dp else 0.dp
		Surface(
			color = MaterialTheme.colorScheme.primary,
			modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
		) {
			Row(modifier = Modifier.padding(24.dp)) {
				Column(
					modifier = Modifier
						.weight(1f)
						.padding(bottom = extraPadding)
				) {
					Text(text = "Hello ")
					Text(text = name)
				}
				ElevatedButton(
					onClick = { expanded.value = !expanded.value }
				) {
					Text(if (expanded.value) "Show less" else "Show more")
				}
			}
		}
	}

	@Preview(showBackground = true, widthDp = 320, heightDp = 320)
	@Composable
	fun OnBoardScreenPreview(){
		BasicCodeLabTheme {
			OnBoardScreen()
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
