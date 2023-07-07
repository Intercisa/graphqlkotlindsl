package com.expediagroup.graphql.demo.query

import com.expediagroup.graphql.spring.operations.Query
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.springframework.stereotype.Component

@Component
class ScheduleDetails: Query {

    suspend fun apps(): List<String> = coroutineScope {

        val cached = async { cachedApps() }
        val databased = async { databaseApps() }

        val results = listOf(cached.await(), databased.await()).flatten()
        results
    }

    private suspend fun cachedApps(): List<String> {
        delay(100)
        return listOf("BEPS, SAPS")
    }


    private suspend fun databaseApps(): List<String> {
        delay(3000)
        return listOf("BPAS, VPS")
    }
}
