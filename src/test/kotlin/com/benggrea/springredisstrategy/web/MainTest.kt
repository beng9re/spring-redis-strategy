package com.benggrea.springredisstrategy.web

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class MainTest : AnnotationSpec() {

    @Test
    fun `테스트 샘플`() {
        val name = "kyunam"
        name shouldBe "kyunam"
    }
}
