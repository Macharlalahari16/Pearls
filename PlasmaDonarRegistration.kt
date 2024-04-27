package com.example.mad

import android.location.Location
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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

class PlasmaDonorRegistration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlasmaDonorScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun PlasmaDonorScreen() {

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
        Text(text = "Plasma Recipient Information")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = bloodType,
            onValueChange = { bloodType = it },
            label = { Text("Blood Type") },
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
            value = PhoneNumber,
            onValueChange = { PhoneNumber = it },
            label = { Text("PhoneNumber") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                var buttonClicked = true
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Accept")
        }
        var buttonClicked = false
        if (buttonClicked) {
            Text(text = "Button Clicked!")

            handleDonorRegistration(name, bloodType)
        }

    }
}



@Composable
fun handleDonorRegistration(name: String, bloodType: String,) {

    println("Name: $name, Blood Group: bloodGroup")
}
