package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.databinding.ListItemBinding

class MainListAdapter(
    appExecutors: AppExecutors,
    private val viewModel: MainViewModel
) : DataBoundListAdapter<Int>(
    appExecutors = appExecutors,
    diffCallback = object: DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item, parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: Int) {
        when (binding) {
            is ListItemBinding -> {
                binding.optionID = item
                binding.viewModel = viewModel
            }
        }
    }
}
