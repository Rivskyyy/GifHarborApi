package com.rivskyinc.gifharborapi.domain.pojo.pagination

data class Pagination(
    val count: Int,
    val offset: Int,
    val total_count: Int
)