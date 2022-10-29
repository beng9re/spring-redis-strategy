package com.benggrea.springredisstrategy.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/main")
    private fun main(): String {
        return "안녕"
    }
}
