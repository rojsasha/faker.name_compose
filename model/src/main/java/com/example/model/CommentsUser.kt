package com.example.model

import com.squareup.moshi.Json

data class CommentsUser (

    val idDocument: Int,
    @Json(name = "id") val id: Int,
    @Json(name = "text") val text: String,
    @Json(name = "is_positive") val is_positive: Int,
    @Json(name = "parent_id") val parent_id: String,
    @Json(name = "document_id") val document_id: Int,
    @Json(name = "user_id") val user_id: Int,
    @Json(name = "created_at") val created_at: String,
    @Json(name = "updated_at") val updated_at: String,
    @Json(name = "user") val user: User

        )


