package com.shubham.gmailclone.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.gmailclone.ui.theme.GmailCloneTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(drawerState: DrawerState, scope: CoroutineScope, openAccountDialog: MutableState<Boolean>) {
    // Modifier.windowInsetsPadding automatically handle system insets like the status bar
    Box(modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 10.dp, vertical = 10.dp).height(50.dp),
        contentAlignment = Alignment.Center) {
        Card(shape = RoundedCornerShape(50.dp),
            elevation = CardDefaults.cardElevation(8.dp)) {

            // Creating using Row composable
            /*
            Row(modifier = Modifier.padding(10.dp).fillMaxWidth().padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
                Text("Search in emails", fontSize = 16.sp,
                    modifier = Modifier.weight(1.0f)
                        .padding(start = 10.dp))
                Image(imageVector = Icons.Default.Person, contentDescription = "Profile",
                    modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Gray))
            }
             */

            // Creating using TopAppBar composable
            TopAppBar(title = {Text("Search in emails", fontSize = 16.sp)},
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()  // Open drawer state inside coroutine scope
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    Image(imageVector = Icons.Default.Person, contentDescription = "Profile",
                        modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Gray)
                            .clickable {
                                openAccountDialog.value = true
                            })
                },
                modifier = Modifier.padding(end = 10.dp)
            )

            if(openAccountDialog.value) {
                AccountDialog(openAccountDialog)
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeAppBarPreview() {
    GmailCloneTheme {
//        HomeAppBar()
    }
}