package com.slowmotion.makeup2app

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
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
import com.slowmotion.makeup2app.Network.Retrofit
import kotlinx.android.synthetic.main.item_makeup.view.*
import kotlin.coroutines.coroutineContext

class MakeUpAdapter (private val clickListener : OnClickListener): RecyclerView.Adapter<MakeUpAdapter.MakeUpViewHolder>(){

    //variable penampung
    private val data = ArrayList<MakeUpModel>()
    //try
//    lateinit var itemClick: OnClickListener
//    private lateinit var onItemClickCallBack: OnItemClickCallBack
//
//    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack){
//        this.onItemClickCallBack = onItemClickCallBack
//    }
    //bagian adapter, wajib
    //nyambungin ui dan code
    inner class MakeUpViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){


        fun bind(data: MakeUpModel) {
            //lib3
            Glide.with(itemView.context)
                .load(data.Picture)
                .apply(
                    RequestOptions()
                        .override(100, 100)
                )
                .into(itemView.iv_item)

            itemView.tv_Name.text = data.Name

            //try
//            itemView.setOnClickListener{
//                itemClick.detail(data)
//            }
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeUpViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_makeup, parent, false)
        return MakeUpViewHolder(view)
    }

    //try
    interface OnClickListener{
        fun detail(item: Int)
    }


    //sesuai api
    override fun onBindViewHolder(holder: MakeUpViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            clickListener.detail(position)
        }
//        holder.itemView.setOnClickListener { (holder.bind(data[position])) }
    }

    override fun getItemCount(): Int = data.size


    @SuppressLint("NotifyDataSetChanged")
    //buat mainac
    fun setData(list: ArrayList<MakeUpModel>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

//    interface OnItemClickCallBack {
//        fun onItemClick(data: MakeUpModel)
//    }

}

