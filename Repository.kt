package com.example.mad

import io.ktor.client.call.body
import io.ktor.client.request.get

class Repository {
    suspend fun getDonorData(bloodGroup: String): List<Donor> {
        val response = KtorClient.httpClient
            .get("https://crudcrud.com/api/99ca3df57f9d4c08a219b925e9fd402e/blooddonor")
            .body<List<Donor>>()
        println(response.toString())
        return response.filter { it.BloodType == bloodGroup }

    }
}
