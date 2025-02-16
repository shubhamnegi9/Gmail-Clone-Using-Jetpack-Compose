package com.shubham.gmailclone.Models

data class MailItemModel(
    val mailId: Int = -1,
    val userName: String? = null,
    val subject: String? = null,
    val body: String? = null,
    val timeStamp: String? = null,
    val isHeader: Boolean = false
)
