package com.prabh.dogsfeed.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prabh.dogsfeed.data.DogsRepository
import com.prabh.dogsfeed.model.GenerateRandomDog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DogsViewmodel(private val dogsRepo: DogsRepository): ViewModel() {

    private val _recentDogsList = MutableStateFlow<List<GenerateRandomDog>?>(null)
    val recentDogsList: StateFlow<List<GenerateRandomDog>?>
        get() = _recentDogsList.asStateFlow()

    fun fetchDogData(result: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = dogsRepo.fetchRandomDog()
            if (response.isSuccessful && response.body() != null && response.body()?.status.equals(
                    "success",
                    ignoreCase = true
                )
            ) {
                response.body()?.dogImageUrl?.let { imageUrl ->
                    result.invoke(imageUrl)
                }
                dogsRepo.addDog(response.body()!!)
            }
        }
    }

    fun fetchDogList() {
        viewModelScope.launch(Dispatchers.IO) {
            dogsRepo.fetchDogs().collectLatest { dogList ->
                _recentDogsList.update{dogList}
            }
        }
    }

    fun clearOldCache() {
        viewModelScope.launch(Dispatchers.Default) {
            recentDogsList.collectLatest { dogList ->
                val newIdsList = dogList?.map { it.id } ?: return@collectLatest
                withContext(context = Dispatchers.IO) {
                    dogsRepo.clearOldCache(newIdsList)
                }
            }
        }
    }

    fun clearCache() {
        viewModelScope.launch(Dispatchers.IO) {
            dogsRepo.clearCache()
        }
    }

}