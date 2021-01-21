package com.example.commons

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolder<MODEL>(val itemVariableId: Int, val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: MODEL) {
        binding.setVariable(itemVariableId, item)
        binding.executePendingBindings()
    }
}