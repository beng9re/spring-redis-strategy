package com.benggrea.springredisstrategy.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/main")
    private fun main(): String {
        return "안녕"
    }
}
