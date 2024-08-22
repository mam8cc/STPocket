package gg.thegrim.stpocket.characters

enum class CharacterType {
    TOWNSFOLK, OUTSIDER, MINION, DEMON, TRAVELER, FABLED
}

data class Character(
    val name: String,
    val type: CharacterType,
    val rule: String,
    val flavorText: String,
    val link: String
)

object CharacterProvider{
    private val characters = mutableListOf<Character>(
        Character(
            name = "Imp",
            type = CharacterType.DEMON,
            rule = "Each night...",
            flavorText = "",
            link = ""
        ),
        Character(
            name = "Monk",
            type = CharacterType.TOWNSFOLK,
            rule = "Each night...",
            flavorText = "",
            link = ""
        ),
        Character(
            name = "Saint",
            type = CharacterType.OUTSIDER,
            rule = "Each night...",
            flavorText = "",
            link = ""
        ),
    )

    fun getAllCharacters(): List<Character> = characters

    fun getCharactersByType(type: CharacterType): List<Character> {
        return characters.filter { it.type == type }
    }
}