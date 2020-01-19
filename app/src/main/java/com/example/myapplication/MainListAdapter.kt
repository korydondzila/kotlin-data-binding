package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.databinding.ListItemBinding

class MainListAdapter(
    private val selectedID: LiveData<Int>,
    private val viewLifecycleOwner: LifecycleOwner,
    private val onClickCallback: ((Int) -> Unit)?
) : DataBoundListAdapter<Int>(
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
            R.layout.list_item,
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: Int) {
        when (binding) {
            is ListItemBinding -> {
                binding.optionID = item
                selectedID.observe(viewLifecycleOwner, Observer {
                    binding.itemLabel.isChecked = it == item
                })

                binding.root.setOnClickListener {
                    onClickCallback?.invoke(item)
                }
            }
        }
    }
}
