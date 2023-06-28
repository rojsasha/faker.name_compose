package com.example.model

data class Search(
    var idUser: String = "",
    val id: Int,
    val current_page: Int?,
    val last_page: Int?,
    val total: Int?,
    val data: List<SearchModel>
    ) {
    companion object {
        fun getIdUser(countryId: Int?, query: String) = "id=$countryId&query=$query"
    }
}