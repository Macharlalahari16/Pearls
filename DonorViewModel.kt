package com.example.mad
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DonorViewModel() : ViewModel() {
    private val _donorData = MutableStateFlow<List<Donor>>(emptyList())
    val donorData: StateFlow<List<Donor>> = _donorData

    fun fetchDonorData(bloodGroup : String) {
        viewModelScope.launch {
            val Donor = Repository()
            val donorList = Donor.getDonorData(bloodGroup)
            _donorData.value = donorList
        }
    }
}
