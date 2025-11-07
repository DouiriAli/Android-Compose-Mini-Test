package com.alidouiri.technicaltest.domain.model

internal data class Show(
    val id: String,
    val title: String,
    val thumbnailUrl: String? = null,
    val viewers: Int
)