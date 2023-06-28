package com.example.model

data class Documents(
    val current_page: Int,
    val last_page: Int,
    val total: Int,
    val data: List<DocumentsPage>
)
