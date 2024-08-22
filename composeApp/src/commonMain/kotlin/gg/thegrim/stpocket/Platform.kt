package gg.thegrim.stpocket

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform