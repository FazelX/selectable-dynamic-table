package dev.fazelx.dynamictable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dev.fazelx.dynamictable.databinding.FragmentFirstBinding
import dev.fazelx.selectable_dynamic_table.model.Cell
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataTable()
    }

    private fun initDataTable() {

        val titles: MutableList<String> = mutableListOf()
        for (i in 0..8)
            titles.add("Header $i")


        val data: MutableList<MutableList<Cell>> = mutableListOf()

        for (i in 0..20) {
            val tempList: MutableList<Cell> = mutableListOf()
            for (j in 0..titles.size) {
                tempList.add(Cell(UUID.randomUUID().toString(), "content $i $j", "data $i $j"))
            }
            data.add(tempList)
        }


        binding.fakeDataTableView.setData(titles, data)
        binding.fakeDataTableView.setSelectingStatus(selectableRow = true, selectableCell = true)
        binding.fakeDataTableView.setRadius(15f)
        binding.fakeDataTableView.setMaxVisibleItems(5)
        binding.fakeDataTableView.fillToTable()
        
        binding.fakeDataTableView.setOnRowSelectChangeListener { isSelected , rowData, pos ->
            if (isSelected) {
                val rowInfo = HashMap<String, Any>()
                for (i in titles.indices) {
                    rowInfo[i.toString()] = data[pos][i].mData
                }

                Toast.makeText(requireContext(), rowInfo.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        binding.fakeDataTableView.setOnCellSelectChangeListener { isSelected, cell ->
            if (isSelected) {

                Toast.makeText(requireContext(), cell.mData.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}