package com.alidouiri.technicaltest.data.model

data class ShowEntity(
    val id: String,
    val title: String,
    val thumbnailUrl: String? = null,
    val viewers: Int
)


