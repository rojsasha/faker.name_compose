package com.example.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "id") val id: Int,
    @Json(name = "role_id") val role_id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String,
    @Json(name = "phone") val phone: Int?,
    @Json(name = "avatar") val avatar: String,
    @Json(name = "email_verified_at") val email_verified_at: String,
    @Json(name = "created_at") val created_at: String,
    @Json(name = "updated_at") val updated_at: String
)