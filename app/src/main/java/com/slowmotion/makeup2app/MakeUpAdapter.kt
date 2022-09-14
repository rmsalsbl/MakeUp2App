package com.slowmotion.makeup2app

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.slowmotion.makeup2app.Model.MakeUpModel
import kotlinx.android.synthetic.main.item_makeup.view.*

class MakeUpAdapter (
    val list: List<MakeUpModel?>,
//    val itemClick: OnClickListener
): RecyclerView.Adapter<MakeUpAdapter.MakeUpViewHolder>(){
    inner class MakeUpViewHolder (private val view: View) : RecyclerView.ViewHolder(view){
        fun bind(item: MakeUpModel){
            view.tv_Name.text = item.Name

            Glide.with(view.context)
                .load(item.Picture)
                .apply(RequestOptions())
                .override(500,500)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(view.iv_item)

//            view.setOnClickListener{
//                itemClick.detail(item)
//            }
        }
    }

//    interface OnClickListener {
//        fun detail(item: MakeUpModel)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeUpViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_makeup, parent, false)
        return MakeUpViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakeUpViewHolder, position: Int) {
        val view = list.get(position)

        holder.bind(view!!)
    }

    override fun getItemCount(): Int = list?.size

}