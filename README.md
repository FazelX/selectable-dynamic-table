# Selectable dynamic table

The selectable dynamic table is an easy-to-use, lightweight library that lets you create a scrollable and customizable table with a static header and indexes, you can also select its rows and the cells as shown below.

## Demos


| Static header and indexes                                                                                                                |                                                           Selectable cells and rows                                                            |
|----------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------:| 
| <img src="https://raw.githubusercontent.com/FazelX/selectable-dynamic-table/master/sample/sdt_scroll.gif" width="392" height="854"> | <img src="https://raw.githubusercontent.com/FazelX/selectable-dynamic-table/master/sample/sdt_select.gif" width="392" height="854"> |


### Features:
- Dynamic rows and columns based on given data
- Selectable cells and rows
- Static header and indexes
- Can hide header and indexes
- Can disable selectable cells and rows
- Support for API Level 16+
- Highly customizable
- Lightweight and easy-to-use

## Usage

Put selectable-dynamic-table in your desired XML file:

### XML
```xml
    <dev.fazelx.selectable_dynamic_table.TableView
    android:id="@+id/selectableDataTableView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
/>
```

Then in your Java or Kotlin code create a list of list of Cell models (List<List<Cell>>) and a list of Strings as headers, and pass them to the table using setData(headers, data) method.

In a Cell object, you should set an id, content that will be shown in the table cell, and a data parameter which basically can be anything.

After that use your desired customizing methods and then call fillToTable() method.

```kotlin
binding.selectableDataTableView.setData(headersList, dataList)
binding.selectableDataTableView.setSelectingStatus(selectableRow = true, selectableCell = true)
binding.selectableDataTableView.setRadius(15f)
binding.selectableDataTableView.setMaxVisibleItems(5)
...//other customizing methods
binding.selectableDataTableView.fillToTable()
```

You can access selected row or cell data by setting the proper listener to the selectable-dynamic-table like below:

set listener to row select status change:

```kotlin

//Set listener to get the data of the selected row, or notified when the selected row is unselected
binding.selectableDataTableView.setOnRowSelectChangeListener { isSelected , rowData, pos ->
    if (isSelected) {
        //do something
    }
}

```

set listener to cell select status change:


```kotlin

//set listener to get the data of the selected cell, or notified when the selected cell unselected
binding.selectableDataTableView.setOnCellSelectChangeListener { isSelected, cell ->
    if (isSelected) {
        //do something
    }
}

```

Check out the Sample app, for more information.

### Gradle
* This library is available on jitpack.io . To use it
	
Step 1. Add JitPack repository to your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    
```


Step 2. Add the following to ypur app level `build.gradle`
```gradle
dependencies {
    implementation 'com.github.fazelx:selectable-dynamic-table:1.0'
}
```

### XML
```xml
    <dev.fazelx.selectable_dynamic_table.TableView
    android:id="@+id/selectableDataTableView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:has_border="true"
    app:border_color="@color/black"
    app:rows_height="55dp"
    app:header_height="75dp"
/>
```
| **attr**     | **Description**                                       |
| ------------ | ----------------------------------------------------- | 
| has_border | Indicates if the table should have borders            |
| border_color | Sets the border color of the table | 
| rows_height |Sets the custom height to the rows |
| header_height |Sets the custom height to the header|

### OR Programmatically

| **Method**     | **Description**                                     |
| ------------ | --------------------------------------------------- | 
| `fun setData(headers: List<String>?, data: List<List<Cell>>)` | Called to set headers and data that will be going to show in the table          |
| `fun fillToTable()` | Called to fill the provided data into the table          |
| `fun clearTable()` | Called to clear table data and views          |
| `fun hideHeader()` | Hides the header of this table           |
| `fun hideIndexes()` | Hides the indexes of this table           |
| `fun hideColumns(columnIndexes: List<Int>)` | Hides this table data columns based on given column indexes          |
| `fun setRadius(radius: Float)` | Sets the radius            |
| `fun setHasBorder(hasBorder: Boolean)` | Sets whether the card has border(Call this before fillToTable() function)         |
| `fun setBorderColor(color: Int)` | Hides the header of this table(Call this before fillToTable() function)          |
| `fun setHeaderBackgroundColor(color: Int)` | Sets the header background color           |
| `fun setHeaderTextColor(color: Int)` | Sets the header cell's text color(Call this before fillToTable() function)         |
| `fun setIndexesBackgroundColor(color: Int)` | Sets the indexes background color          |
| `fun setIndexesTextColor(color: Int)` | Sets the index cell's text color(Call this before fillToTable() function)         |
| `fun setDataTableBackgroundColor(color: Int)` |Sets the data's background color           |
| `fun setDataCellsTextColor(color: Int)` | Sets the data cell's text color(Call this before fillToTable() function)          |
| `fun setSelectedCellsTextColor(color: Int)` | Sets the selected data cell's text color          |
| `fun setSelectedRowColor(color: Int)` | Sets the selected row's background color          |
| `fun setSelectedCellColor(color: Int)` | Sets the selected cell's background color          |
| `fun setIndexesTitle(indexesTitle: String)` | Sets the indexes general title           |
| `fun setIndexesTitleWidth(width: Int)` | Sets the indexes width(Call this before fillToTable() function)          |
| `fun setHeaderHeight(height: Int)` | Sets the headers height(Call this before fillToTable() function)          |
| `fun setRowsHeight(height: Int)` | Sets the rows height(Call this before fillToTable() function)          |
| `fun setMaxVisibleItems(maxVisibleItems: Int)` | Sets the max visible items to show in the this table, if the table rows was more than given number then table would be scrollable        |
| `fun setSelectingStatus(selectableRow: Boolean, selectableCell: Boolean)` | Sets the selectable status for the cells and the rows          |


## Contribute

Users are welcome to suggest ideas or feature requests or report bugs and issues [here](https://github.com/FazelX/selectable-dynamic-table/issues)

I am always open to new suggestions and good contributions.

## Contact

Feel free to reach out to me at fazelhey@gmail.com

## License:
```
Copyright 2023 Fazel Heidari

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
