package com.example.model


data class DocumentsPage(
    val id: Int,
    val inn: String?,
    val passport: String?,
    val description: String?,
    val country_id: Int,
    val user_id: Int,
    val created_at: String,
    val updated_at: String
)

data class DocumentsPageModel(
    val id: Int,
    val inn: String?,
    val passport: String?,
    val description: String?,
    val country_id: Int,
    val user_id: Int,
    val created_at: String,
    val updated_at: String
)

fun DocumentsPage.toUIModel(): DocumentsPageModel {
    return DocumentsPageModel(
        id = id,
        inn = inn,
        passport = passport,
        description = description,
        country_id = country_id,
        user_id = user_id,
        created_at = created_at,
        updated_at = updated_at
    )
}

