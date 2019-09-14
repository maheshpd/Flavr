package com.example.flavr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.flavr.Interface.IItemClickListener
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
        holder.setClick(object : IItemClickListener {
            override fun onItemClickListener(view: View, position: Int) {
                Toast.makeText(context, " " + itemList[position].name, Toast.LENGTH_SHORT).show()
            }
        })
    }


    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        var txt_name: TextView

        lateinit var itemClickListener: IItemClickListener

        fun setClick(itemClickListener: IItemClickListener) {
            this.itemClickListener = itemClickListener
        }

        init {
            txt_name = view.findViewById(R.id.cate_name)
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            itemClickListener.onItemClickListener(view!!, adapterPosition)
        }
    }


}