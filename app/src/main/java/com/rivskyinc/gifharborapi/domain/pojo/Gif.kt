package com.rivskyinc.gifharborapi.domain.pojo

import com.rivskyinc.gifharborapi.domain.pojo.data.Data
import com.rivskyinc.gifharborapi.domain.pojo.meta.Meta
import com.rivskyinc.gifharborapi.domain.pojo.pagination.Pagination

data class Gif(
    val data: List<Data>,
    val meta: Meta,
    val pagination: Pagination
)