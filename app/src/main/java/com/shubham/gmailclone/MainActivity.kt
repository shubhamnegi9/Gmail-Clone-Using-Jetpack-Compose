package com.shubham.gmailclone

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shubham.gmailclone.Components.GmailNavigationDrawer
import com.shubham.gmailclone.Components.HomeAppBar
import com.shubham.gmailclone.ui.theme.GmailCloneTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GmailCloneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GmailApp()
                }
            }
        }
    }


}

@Composable
fun GmailApp() {
    GmailNavigationDrawer()
}

@Preview(showBackground = true)
@Composable
fun GmailAppPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}
