package com.shubham.gmailclone.Components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.gmailclone.Models.DrawerMenuData

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun GmailNavigationDrawer() {

    var drawerState = rememberDrawerState(DrawerValue.Closed)
    var scope = rememberCoroutineScope()
    var drawerSelectedItem by remember {
        mutableStateOf("Primary")   // Initially Primary menu item is selected in drawer menu
    }
    var bottomSelectedItem by remember {
        mutableStateOf("Mail")   // Initially Mail menu item is selected in bottom navigation bar
    }

    var openAccountDialog = remember {
        mutableStateOf(false)
    }

    val lazyListState = rememberLazyListState()
    var previousIndex by remember { mutableStateOf(0) }             // track the previous scroll position of the LazyColumn
    var previousScrollOffset by remember { mutableStateOf(0) }      // track the previous scroll position of the LazyColumn
    var isFabExtended by remember { mutableStateOf(true) }          // control the visibility state of the FAB (extended or not)

    // Detect scroll direction and update FAB state
    LaunchedEffect(lazyListState) {
        snapshotFlow { lazyListState.firstVisibleItemIndex to lazyListState.firstVisibleItemScrollOffset }
            .collect { (currentIndex, currentOffset) ->
                val isScrollingUp = if (currentIndex == previousIndex) {
                    currentOffset < previousScrollOffset
                } else {
                    currentIndex < previousIndex
                }

                // Only update isFabExtended if scrolling
                if (currentIndex != 0 || currentOffset != 0) {
                    isFabExtended = isScrollingUp
                }
                previousIndex = currentIndex
                previousScrollOffset = currentOffset
            }
    }

    // list of the menu items in order of display
    val menuList = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Promotions,
        DrawerMenuData.Social,
        DrawerMenuData.Updates,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Scheduled,
        DrawerMenuData.Outbox,
        DrawerMenuData.Drafts,
        DrawerMenuData.AllMail,
        DrawerMenuData.Spam,
        DrawerMenuData.Bin,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,
        DrawerMenuData.Settings,
        DrawerMenuData.HelpAndFeedback
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxHeight().width(300.dp).verticalScroll(rememberScrollState()) // Making ModalDrawerSheet to vertically scroll
            ) {
                Text("Gmail",
                    color = Color.Red,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
                )

                menuList.forEach { item ->
                    when {
                        item.isDivider ->
                            HorizontalDivider(modifier = Modifier.padding(vertical = 5.dp))
                        item.isHeader ->
                            Text(text = item.title!!,
                                fontWeight = FontWeight.W400,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 10.dp))
                        else ->
                            NavigationDrawerItem(
                                icon = {
                                    Icon(item.icon!!, item.title, modifier = Modifier.padding(end = 5.dp)) },
                                label = {
                                    Text(item.title!!, fontSize = 14.sp, fontWeight = FontWeight.W500)
                                },
                                selected = item.title == drawerSelectedItem,
                                onClick = {
                                    // TODO
                                }
                            )
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                HomeAppBar(drawerState, scope, openAccountDialog)
            },
            bottomBar = {
                HomeBottomMenu(bottomSelectedItem)
            },
            floatingActionButton = {
                GmailFab(isFabExtended)
            }) { innerPadding ->

            MailingList(innerPadding, drawerSelectedItem, lazyListState)
        }
    }
}