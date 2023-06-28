package com.example.model

import com.squareup.moshi.Json

data class ShowComment(

    @Json(name = "id") val id: Int,
    @Json(name = "text") val text: String,
    @Json(name = "is_positive") val is_positive: Int,
    @Json(name = "document_id") val document_id: Int,
    @Json(name = "user_id") val user_id: Int,
    @Json(name = "created_at") val created_at: String,
    @Json(name = "updated_at") val updated_at: String,

    )