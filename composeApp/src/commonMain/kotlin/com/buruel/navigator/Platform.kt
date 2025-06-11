package com.buruel.navigator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform