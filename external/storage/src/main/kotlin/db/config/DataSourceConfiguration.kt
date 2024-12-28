package db.config

import com.zaxxer.hikari.HikariDataSource
import db.config.DataSourceConfiguration.Companion.MASTER_DATASOURCE
import db.config.DataSourceConfiguration.Companion.SLAVE_DATASOURCE
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager.isCurrentTransactionReadOnly
import javax.sql.DataSource
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy


@Configuration
class DataSourceConfiguration {
    companion object {
        const val MASTER_DATASOURCE: String = "masterDataSource"
        const val SLAVE_DATASOURCE: String = "slaveDataSource"
    }

    // Master 데이터베이스의 DataSource를 생성하는 빈 설정
    @Bean(MASTER_DATASOURCE)
    @ConfigurationProperties("spring.datasource.master.hikari")
    fun masterDataSource(): DataSource {
        return DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .build()
            .apply { isReadOnly = true }
    }

    // Slave 데이터베이스의 DataSource를 생성하는 빈 설정
    @Bean(SLAVE_DATASOURCE)
    @ConfigurationProperties("spring.datasource.slave.hikari")
    fun slaveDataSource(): DataSource {
        return DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .build()
            .apply { isReadOnly = true }
    }

    // 라우팅 데이터베이스를 생성하는 빈 설정
    @Bean
    @DependsOn(MASTER_DATASOURCE, SLAVE_DATASOURCE)
    fun routingDataSource(): DataSource {
        val routingDataSource = DynamicRoutingDataSource()

        routingDataSource.setTargetDataSources(mapOf(MASTER_DATASOURCE to masterDataSource(), SLAVE_DATASOURCE to slaveDataSource()))
        routingDataSource.setDefaultTargetDataSource(masterDataSource())

        return routingDataSource
    }

    @Primary
    @Bean
    @DependsOn("routingDataSource")
    fun dataSource(): DataSource {
        return LazyConnectionDataSourceProxy(routingDataSource())
    }
}

class DynamicRoutingDataSource: AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any {
        return if (isCurrentTransactionReadOnly()) SLAVE_DATASOURCE else MASTER_DATASOURCE
    }
}
