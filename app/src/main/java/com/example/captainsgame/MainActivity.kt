package com.example.captainsgame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.captainsgame.ui.theme.CaptainsGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainsGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background


                ) {
                    captainGame()

                }
            }
        }
    }

}

@Composable
fun captainGame(){

    val treasuresFound = remember { mutableStateOf(0) }     //keeps track of all treasures found
    //  helps you *remember* important things across changes
    // mutableStateOf gives you a tool to change and update those important things
    // Val isn't changed but is mutable because it's associated with a MutableState
    // (box in the val variable & box is same but content in box changing)

    val direction = remember { mutableStateOf("NORTH") }
    val stormEncountered = remember { mutableStateOf("No Damage") }
    val healthOfShip = remember { mutableIntStateOf(100) }
    val shipDestroyed = remember { mutableStateOf("Ship Sailing") }
    // 'by' keyword gives us the value directly in the variable
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        val context = LocalContext.current

        Row(modifier = Modifier
            .fillMaxWidth()
        )
        {
            Box( modifier = Modifier
                .padding(8.dp)
                .weight(1F), Alignment.CenterStart){
                Text(text = "Treasures Found : ${treasuresFound.value}", fontSize = 15.sp,textAlign = TextAlign.Start)
            }
            Box( modifier = Modifier
                .padding(8.dp)
                .weight(1F), Alignment.CenterStart){

                Text(text = "Current Direction : ${direction.value}", fontSize = 15.sp,textAlign = TextAlign.Start)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
        )
        {
            
            Box( modifier = Modifier
                .padding(8.dp)
                .weight(1F), Alignment.CenterStart){
                Text(text = "Storm : ${stormEncountered.value}", fontSize = 15.sp,textAlign = TextAlign.Start)
            }
            Box( modifier = Modifier
                .padding(8.dp)
                .weight(1F), Alignment.CenterStart){
                Text(text = "Health of Ship : ${healthOfShip.value}", fontSize = 15.sp,textAlign = TextAlign.Start)
                // if we used "by" keyword no need for ".value"
            }
        }

        Row {

                Text(
                    text = "Ship : ${shipDestroyed.value}",
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )

        }

        // BUTTON NORTH
        Row {
            Button(onClick = {
                direction.value = "NORTH"
                if (healthOfShip.value > 0) {
                    if (Random.nextBoolean() == true) {        //50-50 randomizer
                        treasuresFound.value += 1
                        Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                        stormEncountered.value = "No Damage"
                    } else {
                        stormEncountered.value = "* Ship Damaged *"
                        healthOfShip.value -= 10
                    }
                }
                else {
                    shipDestroyed.value = "Ship has been Destroyed !"
                }
            }, modifier = Modifier.padding(10.dp)) {
                Text("Sail NORTH")
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = "north")
            }
        }

        Row {
            Column {
                // Button WEST
                Button(onClick = {
                    direction.value = "WEST"
                    if (healthOfShip.value > 0) {
                        if (Random.nextBoolean() == true) {        //50-50 randomizer
                            treasuresFound.value += 1
                            Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                            stormEncountered.value = "No Damage"
                        } else {
                            stormEncountered.value = "* Ship Damaged *"
                            healthOfShip.value -= 10
                        }
                    }
                    else {
                        shipDestroyed.value = "Ship has been Destroyed !"
                    }
                }, modifier = Modifier.padding(10.dp)) {
                    Text("Sail WEST")
                    Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "west")
                }
            }

            Column {
                // Button EAST
                Button(onClick = {
                    direction.value = "EAST"
                    if (healthOfShip.value > 0) {
                        if (Random.nextBoolean() == true) {        //50-50 randomizer
                            treasuresFound.value += 1
                            Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                            stormEncountered.value = "No Damage"
                        } else {
                            stormEncountered.value = "* Ship Damaged *"
                            healthOfShip.value -= 10
                        }
                    }
                    else {
                        shipDestroyed.value = "Ship has been Destroyed !"
                    }
                },
                    modifier = Modifier.padding(10.dp)) {
                    Text("Sail EAST")
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = "east")
                }
            }
        }

        Row {// BUTTON SOUTH
            Button(onClick = {
                direction.value = "SOUTH"
                if (healthOfShip.value > 0) {
                    if (Random.nextBoolean() == true) {        //50-50 randomizer
                        treasuresFound.value += 1
                        Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                        stormEncountered.value = "No Damage"
                    } else {
                        stormEncountered.value = "* Ship Damaged *"
                        healthOfShip.value -= 10
                    }
                }
                else {
                    shipDestroyed.value = "Ship has been Destroyed !"
                }
            },
                modifier = Modifier.padding(10.dp)) {
                Text("Sail SOUTH")
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "south")
            }
        }

        Row{
            Text("1 Treasure can Repair 20 HP of ship",Modifier.padding(0.dp,45.dp,0.dp,0.dp) )
        }

        Row(modifier = Modifier.padding(10.dp))
        {
            Button(onClick = {
                if(treasuresFound.value != 0) {
                    treasuresFound.value -= 1
                    healthOfShip.value += 20
                    shipDestroyed.value = "Ship Sailing"
                    Toast.makeText(context, "Ship Repaired !", Toast.LENGTH_SHORT).show()
                }else{
                    shipDestroyed.value = "GAME OVER"
                }
            }) {
                Text("Repair Ship ")
                Icon(Icons.Default.Build, contentDescription = "REPAIR")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun captainGamePreview(){
    captainGame()
}