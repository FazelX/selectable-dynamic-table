package dev.fazelx.selectable_dynamic_table.model

/**
 * Created on : January 29, 2023
 * Author     : FazelX
 * Name       : Selectable dynamic table
 * GitHub     : https://github.com/fazelX
 */
class Cell
constructor(
    private val mId: String,
    var mContent: String,
    val mData: Any,
) : ISortableModel {

    override fun getId(): String {
        return mId
    }

    override fun getContent(): Any {
        return mData
    }

}