package com.template.flows

import net.corda.core.node.ServiceHub
import net.corda.core.node.services.CordaService

const val TABLE_NAME = "Infodatabase"

@CordaService
class DatabaseValues(services: ServiceHub) : DatabaseConnection(services) {

    init{
        setUpStorage()
    }

    private fun setUpStorage() {
        val query = """
            create table if not exists $TABLE_NAME(
                name varchar(64),
                age int
            )"""

        executeUpdate(query, emptyMap())
        log.info("***************************Created Infodatabase table.****************************")
    }
}
