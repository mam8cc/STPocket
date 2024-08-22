package gg.thegrim.stpocket.game

import gg.thegrim.stpocket.characters.Character

data class Player (
    val name: String,
    val character: Character
)

data class Game (
    val players: List<Player> = listOf<Player>()
)