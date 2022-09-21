package com.slowmotion.makeup2app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.slowmotion.makeup2app.Model.MakeUpModel
import com.slowmotion.makeup2app.Network.Retrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MakeUpAdapter.OnClickListener {

    //inilisiasi
    private lateinit var adapter: MakeUpAdapter


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deklarasi
        rv_kamu.setHasFixedSize(true)
        rv_kamu.layoutManager = LinearLayoutManager(this)
        adapter = MakeUpAdapter(this)
        adapter.notifyDataSetChanged()
        rv_kamu.adapter = adapter
        getDataFromApi()


}


    private fun getDataFromApi() {
        Retrofit.instance.getMakeUpList()
            .enqueue(object : Callback<ArrayList<MakeUpModel>>{
                override fun onResponse(
                    call: Call<ArrayList<MakeUpModel>>,
                    response: Response<ArrayList<MakeUpModel>>
                ) {
                    if(response.isSuccessful) {
                        showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<ArrayList<MakeUpModel>>, t: Throwable) {
                    Log.e("Fail", "Be Fail")
                }

            })
    }

    private fun showData(data: ArrayList<MakeUpModel>) {
        val result = data
        adapter.setData(result)


    }

    override fun detail(item: Int) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }


}
