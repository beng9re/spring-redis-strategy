package com.benggrea.springredisstrategy.infra

import com.benggrea.springredisstrategy.domain.Data
import org.springframework.data.jpa.repository.JpaRepository


interface DataJpaRepository : JpaRepository<Data, Long>
