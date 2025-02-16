package com.shubham.gmailclone.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.gmailclone.Models.BottomMenuData

@Composable
fun HomeBottomMenu(bottomSelectedItem: String) {

    val bottomMenuList = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )

    NavigationBar(contentColor = Color.Black,
        containerColor = Color.Transparent,
        modifier = Modifier.height(90.dp)) {
        bottomMenuList.forEach {
            NavigationBarItem(
                icon = {
                    Icon(it.icon, it.title)
                },
                onClick = {
                    // TODO
                },
                selected = it.title == bottomSelectedItem,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
    }

}