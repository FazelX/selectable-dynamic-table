package dev.fazelx.selectable_dynamic_table.sync_scroll


interface IScrollListener {
    fun onScrollChanged(scrollView: ObservableScrollView?, x: Int, y: Int, oldx: Int, oldy: Int)
}