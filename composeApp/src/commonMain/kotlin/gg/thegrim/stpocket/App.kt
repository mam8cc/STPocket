package gg.thegrim.stpocket

import Greeting
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.InputMode.Companion.Keyboard
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import gg.thegrim.stpocket.characters.CharacterProvider
import gg.thegrim.stpocket.characters.CharacterType
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import stpocket.composeapp.generated.resources.Res
import stpocket.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {


    MaterialTheme {


        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            var showPlayerCountError by remember { mutableStateOf(false) }
            var numberOfPlayers by remember { mutableStateOf("") }
            val count = numberOfPlayers.toIntOrNull() ?: 0

            var playerNames by remember { mutableStateOf("") }

            if (showPlayerCountError) {
                Column(modifier = Modifier.padding(8.dp).background(Color.Red)) {
                    Text(text = "BotC only supports up to 20 players.", style = MaterialTheme.typography.h6)
                }
            }

            TextField(
                value = numberOfPlayers,
                onValueChange = { input ->
                    if (input.all { it.isDigit() }) {
                        numberOfPlayers = input
                    }
                },
                label = { Text("How many players?") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            if (count < 21) {
                repeat (count) { index ->
                    TextField(
                        value = playerNames,
                        label = { Text(index.toString()) },
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = {}
                    )
                }
            }
            else {
                showPlayerCountError = true
            }

            Spacer(modifier = Modifier.height(16.dp))

            CharacterProvider.getAllCharacters().forEach {
                val color = when (it.type) {
                    CharacterType.DEMON -> Color.Red
                    CharacterType.OUTSIDER -> Color.Gray
                    CharacterType.TOWNSFOLK -> Color.Blue
                    else -> Color. White
                }
                Column(modifier = Modifier.padding(8.dp).background(color)) {
                    Text(text = it.name, style = MaterialTheme.typography.h6)
                    Text(text = it.type.name, style = MaterialTheme.typography.body2)
                    Text(text = it.rule, style = MaterialTheme.typography.body1)
                    Text(text = it.flavorText, style = MaterialTheme.typography.caption)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}