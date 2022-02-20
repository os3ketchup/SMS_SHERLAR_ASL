package com.example.sms_sherlar.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sms_sherlar.R
import kotlinx.android.synthetic.main.item_rv.view.*

class MyPoemAdapter(val list:List<Poems>):RecyclerView.Adapter<MyPoemAdapter.VH>() {
 private lateinit var onItemClickListener: OnItemClickListener

    inner class VH(var itemRV:View):RecyclerView.ViewHolder(itemRV){
        fun onBind(poems: Poems){
            itemRV.tv_titleOfPoem.text = poems.titleOfPoems
            itemRV.tv_ContextOfPoems.text = poems.contextOfPoems
        }
    }

    private fun getItem(position: Int):Poems{
            ItemPosition.position = position
            return list[position]
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
        holder.itemView.setOnClickListener(View.OnClickListener {
                onItemClickListener.onItemClick(position)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}