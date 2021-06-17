package net.uniiva.entity

/**
 * id: ユニークid
 * title: タイトル
 * contents: 質問内容
 */
data class Answer(
    var id: String,
    var boardId: String,
    var contents: String
)
