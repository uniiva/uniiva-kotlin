package net.uniiva.model.share

/**
 * id: ユニークid
 * title: タイトル
 * contents: 質問内容
 */
data class Board(
    val id: String,
    var title: String,
    var contents: String
)