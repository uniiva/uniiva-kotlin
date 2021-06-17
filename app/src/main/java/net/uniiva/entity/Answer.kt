package net.uniiva.entity

/**
 * id: ユニークid
 * boardId: 回答した質問と結びつくID
 * contents: 回答内容
 */
data class Answer(
    var id: String,
    var boardId: String,
    var contents: String
)
