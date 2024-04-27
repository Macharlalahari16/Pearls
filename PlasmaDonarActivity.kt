package com.example.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlasmaDonorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(DonorViewModel::class.java)
        val recipient = intent.getSerializableExtra("recipient") as Recipient
        setContent {
            viewModel.fetchDonorData(recipient.bloodType)
            val plasmaDonors = viewModel.donorData.collectAsState()
            val donors = plasmaDonors.value
            PlasmaDonorScreen(donors, viewModel)
        }
    }
}

@Composable
fun PlasmaDonorScreen(plasmaDonors: List<Donor> = emptyList(), viewModel: DonorViewModel) {
    Column {
        Text(text = "All Donors")
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(plasmaDonors) { donor ->
                PlasmaDonorItemUi(donor.name, donor.BloodType)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
            }
        ) {
            var buttonText = null
            Text(text = "request")
        }
    }
}

@Preview
@Composable
fun PlasmaDonorItemUi(name: String = "Viswanath", bloodType: String = "B+ve") {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column {
            Text(text = "Name: $name")
            Text(text = "Blood Type: $bloodType")
        }
    }
}


data class PlasmaDonor(
    val name: String,
    val bloodType: String
)
