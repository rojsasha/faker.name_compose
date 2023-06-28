package com.example.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.theme.blackText
import com.example.compose.theme.fontRoboto
import com.example.compose.theme.grayTabText
import com.example.compose.theme.violetIndicator
import com.example.search.vm.SearchViewModel

import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchMainScreen(
    navController: NavController,
    query: String?,
    onItemClick: (Int?) -> Unit
) {
    val pagerState = rememberPagerState()
    val viewModel = hiltViewModel<SearchViewModel>()
    val tabs = arrayListOf(
        TabItem.Search { SearchScreen(viewModel) },
        TabItem.SearchHistory { SearchScreen(viewModel) },
    )
    Column {
        Column(modifier = Modifier.fillMaxWidth()) {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                    .padding(horizontal = 16.dp),
                height = 2.dp,
                color = violetIndicator
            )
        },
        backgroundColor = Color.White
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = {
                    Text(
                        text = tab.title,
                        fontFamily = fontRoboto,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        letterSpacing = 0.01.sp,
                    )
                },
                selected = pagerState.currentPage == index,
                selectedContentColor = blackText,
                unselectedContentColor = grayTabText,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, pageCount = tabs.size, userScrollEnabled = false) { page ->
        tabs[page].screen()
    }
}

sealed class TabItem(val title: String, val screen: @Composable () -> Unit) {
    class Search(screen: @Composable () -> Unit) : TabItem("Поиск", screen)
    class SearchHistory(screen: @Composable () -> Unit) : TabItem("История поиска", screen)
}