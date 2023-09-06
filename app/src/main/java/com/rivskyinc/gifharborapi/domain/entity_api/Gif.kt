package com.rivskyInc.gifharbor.domain.entity_api

import com.rivskyInc.gifharbor.domain.entity_api.dataObjectItem.DataObjectItem

data class Gif(
    val data: List<DataObjectItem>,
    val meta: Meta,
    val pagination: Pagination
)