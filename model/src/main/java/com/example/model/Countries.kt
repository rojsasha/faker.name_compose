package com.example.model

import com.squareup.moshi.Json

data class Countries(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String?,
    @Json(name = "is_active") val is_active: Int?,
    @Json(name = "created_at") val created_at: String?,
    @Json(name = "updated_at") val updated_at: String?
)
