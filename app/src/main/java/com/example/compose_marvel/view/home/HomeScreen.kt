package com.example.compose_marvel.view.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose_marvel._product.component.CharacterItem
import com.example.compose_marvel.core.component.CenterOfLoading
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter

@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val scrollState = rememberLazyListState();
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        renderBody(
            viewModel = viewModel, listState = scrollState
        )
    }
}

@Composable
fun renderBody(viewModel: HomeViewModel, listState: LazyListState) {
    if (viewModel.isLoading.value) {
        CenterOfLoading()
    } else {
        LazyColumn(state = listState) {
            items(viewModel.characterList.value) { item ->
                CharacterItem(characters = item)
            }
        }
    }

    InfiniteListHandler(listState = listState){
        viewModel.loadMoreCharacters()
    }
}

@Composable
fun InfiniteListHandler(
    listState: LazyListState,
    buffer: Int = 2,
    onLoadMore: () -> Unit
) {
    val loadMore = remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
            lastVisibleItemIndex > (totalItemsNumber - buffer)
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore.value }
            .filter { it }
            .collect {
                println("collect data")
                onLoadMore()
            }
    }
}




