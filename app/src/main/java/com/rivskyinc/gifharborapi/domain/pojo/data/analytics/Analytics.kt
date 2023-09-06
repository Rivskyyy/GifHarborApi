package com.rivskyinc.gifharborapi.domain.pojo.data.analytics

import com.rivskyinc.gifharborapi.domain.pojo.data.analytics.Onclick
import com.rivskyinc.gifharborapi.domain.pojo.data.analytics.Onload
import com.rivskyinc.gifharborapi.domain.pojo.data.analytics.Onsent

data class Analytics(
    val onclick: Onclick,
    val onload: Onload,
    val onsent: Onsent
)