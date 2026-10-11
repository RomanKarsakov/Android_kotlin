package com.example.karsakov_andr.data.model

data class TodosResponse(
    val items: List<Items>,
    val page: Int? = null,
    val perPage: Int? = null,
    val totalItems: Int? = null,
    val totalPages: Int? = null
)
