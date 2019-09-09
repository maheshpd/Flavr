package com.example.flavr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flavr.R
import com.example.flavr.model.CategoryModel

class CategoryAdapter(private val context: Context, private val itemList: List<CategoryModel>?) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.categories_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.txt_name.text = itemList!![position].name
    }


    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        var txt_name: TextView

        init {
            txt_name = view.findViewById(R.id.cate_name)
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }


}