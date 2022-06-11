package com.example.compose_marvel.view.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_marvel.network.model.CharacterResponseModel
import com.example.compose_marvel.network.repository.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {
    private val _limit: Int = 30;
    var offset = mutableStateOf<Int>(0)
    var characterList = mutableStateOf<List<CharacterResponseModel>>(listOf())
    var isLoading = mutableStateOf<Boolean>(false);

    init {
        getMarvelCharacters()
    }

    fun loadMoreCharacters(){
        offset.value += _limit;
        getMarvelCharacters()
    }

    private fun getMarvelCharacters() {
        viewModelScope.launch {
            isLoading.value = true;
            val result = repository.getCharactersList(
                limit = _limit,
                offset = offset.value,
                comics = null,
                series = null,
                name = null
            );
            if (result.code == 200) {
                characterList.value = characterList.value.plus(result.data!!.results);
                isLoading.value = false;
            } else {
                isLoading.value = false;
            }
        }


    }

}