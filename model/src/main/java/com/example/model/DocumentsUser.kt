package com.example.model

import com.squareup.moshi.Json

data class DocumentsUser(
    @Json(name = "id") val id: Int,
    @Json(name = "inn") val inn: String?,
    @Json(name = "passport") val passport: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "country_id") val country_id: Int,
    @Json(name = "user_id") val user_id: Int,
    @Json(name = "created_at") val created_at: String,
    @Json(name = "updated_at") val updated_at: String,
    @Json(name = "comments") val comments: List<CommentsUser>?

)