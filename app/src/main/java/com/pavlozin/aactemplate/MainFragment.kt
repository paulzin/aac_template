package com.pavlozin.aactemplate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.pavlozin.aactemplate.utils.InjectorUtils
import com.pavlozin.aactemplate.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels {
        InjectorUtils.provideMainViewModelFactory(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()

        create_data_button.setOnClickListener {
            viewModel.createData("New data")
        }

        delete_data_button.setOnClickListener {
            viewModel.deleteData()
        }
    }

    private fun observeViewModel() {
        viewModel.data.observe(viewLifecycleOwner, Observer {
            data_count_text_view.text = "Total data count: ${it?.let { it.size }}"
        })
    }
}
