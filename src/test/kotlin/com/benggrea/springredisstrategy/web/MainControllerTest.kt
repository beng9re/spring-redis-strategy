package com.benggrea.springredisstrategy.web

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class MainControllerTest : AnnotationSpec() {

    @Test
    fun `컨트롤러 테스트`() {
        val name = "kyunam"
        name shouldBe "kyunam"
    }


}
