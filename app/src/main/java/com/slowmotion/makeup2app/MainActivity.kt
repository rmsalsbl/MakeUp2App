package com.slowmotion.makeup2app

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
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<MakeUpModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_kamu.setHasFixedSize(true)
        rv_kamu.layoutManager = LinearLayoutManager(this)
        val adapter = MakeUpAdapter(list)
        rv_kamu.adapter = adapter

        Retrofit.instance.getMakeUpList().enqueue(object : retrofit2.Callback<ArrayList<MakeUpModel>>{
            override fun onResponse(
                call: Call<ArrayList<MakeUpModel>>,
                response: Response<ArrayList<MakeUpModel>>
            ) {
                for (q in response.body()!!){
                    Log.e("Berhasil", q.Name.toString() )
                }
            }

            override fun onFailure(call: Call<ArrayList<MakeUpModel>>, t: Throwable) {
                Log.e("Fail", "Be fail")
            }


        })
    }
}