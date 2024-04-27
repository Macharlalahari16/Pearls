package com.example.mad

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import com.example.mad.ui.theme.MadTheme
import kotlinx.serialization.Serializable

class PlasmaRecipient : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlasmaRecipientScreen(
                        onPlasmaDonorClicked = {
                            var donorIntent = Intent(this@PlasmaRecipient, PlasmaDonorActivity::class.java)
                            donorIntent.putExtra("recipient", it as java.io.Serializable)
                            startActivity(donorIntent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun PlasmaRecipientScreen(onPlasmaDonorClicked:(Recipient) ->Unit) {
    var name by remember { mutableStateOf("") }
    var bloodType by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var PhoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Plasma Recipient")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = bloodType,
            onValueChange = { bloodType = it },
            label = { Text("bloodType") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = PhoneNumber,
            onValueChange = { PhoneNumber = it },
            label = { Text("PhoneNumber") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val recipient = Recipient(name, location, bloodType, PhoneNumber)
                onPlasmaDonorClicked(recipient)
            },
            modifier = Modifier.align(Alignment.End)
        ) {

            Text(text = "Next ")
        }
    }
}

@Composable
fun RecipientForm(
    name: String,
    bloodType: String,
    location: String,
    onNameChange: (String) -> Unit,
    onBloodTypeChange: (String) -> Unit,
    onLocationChange: (String) -> Unit,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Plasma Recipient")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = location,
            onValueChange = onLocationChange,
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = bloodType,
            onValueChange = onBloodTypeChange,
            label = { Text("Blood Type") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
//                onButtonClick(
//                Recipient("skjdahf","sjkfhd","A","897868"))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Request")
        }
    }
}

@Serializable
data class Recipient(
    val name: String = "",
    val location: String = "",
    val bloodType: String = "",
    val phoneNumber: String = ""
) : java.io.Serializable
