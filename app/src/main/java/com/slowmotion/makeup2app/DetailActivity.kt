package com.slowmotion.makeup2app;
import android.graphics.text.LineBreaker
import android.os.Build
import com.slowmotion.makeup2app.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.slowmotion.makeup2app.Model.MakeUpModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_makeup.*

class DetailActivity : AppCompatActivity() {

    private var item: MakeUpModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
//        tv_detail_name.setText(item?.Name)
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        tv_detail_name.text = item?.Name
//        tv_detail_price.setText(item?.Price)
//        tv_detail_desc.setText(item?.Description)


//        Glide.with(this)
//            .load(item?.Picture)
//            .apply(
//                RequestOptions()
//                    .override(500,500)
//                    .placeholder(R.drawable.ic_launcher_background)
//                    .priority(Priority.HIGH))
//                    .into(iv_detail)

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            tv_detail_desc.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
//        }
    }
}