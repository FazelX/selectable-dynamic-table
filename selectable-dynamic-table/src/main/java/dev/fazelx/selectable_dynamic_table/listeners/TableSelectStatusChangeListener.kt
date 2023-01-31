/*
*Copyright 2023 Fazel Heidari
*
*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
 */
package dev.fazelx.selectable_dynamic_table.listeners

import dev.fazelx.selectable_dynamic_table.model.Cell

/**
 * Created on : January 29, 2023
 * Author     : FazelX
 * Name       : Selectable dynamic table
 * GitHub     : https://github.com/fazelX
 */

/** Interface definition for a callback to be invoked when the table row or cell select state changes. */
interface TableSelectStatusChangeListener {

    /**
     * Register a callback to table rows select status changes.
     *
     * @param cellSelectChangeListener The callback that will run.
     */
    fun setOnCellSelectChangeListener(cellSelectChangeListener: (isSelected: Boolean, cell: Cell) -> Unit)

    /**
     * Register a callback to table cells select status changes.
     *
     * @param rowSelectChangeListener The callback that will run.
     */
    fun setOnRowSelectChangeListener(rowSelectChangeListener: (isSelected: Boolean, rowData: List<Cell>, pos: Int) -> Unit)
}