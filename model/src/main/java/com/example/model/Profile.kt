package com.example.model


data class Profile(
    val id: Int,
    val role_id: Int,
    val name: String,
    val email: String,
    val phone: Int?,
    val avatar: String,
    val email_verified_at: String?,
    val created_at: String,
    val updated_at: String
)
