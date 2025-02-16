package com.shubham.gmailclone.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GmailFab(isFabExtended: Boolean) {

    if(isFabExtended) {
        ExtendedFloatingActionButton(
            onClick = {
                // TODO
            }
        ) {
            Icon(Icons.Outlined.Edit, "Edit")
            Text("Compose", Modifier.padding(start = 10.dp))
        }
    } else {
        FloatingActionButton(onClick = {
            // TODO
        }) {
            Icon(Icons.Outlined.Edit, "Edit")
        }
    }
}