package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.les_fifth_third.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var adapter = PixaAdapter(arrayListOf())
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClikers()
    }

    private fun initClikers() {
        with(binding) {
            btnChange.setOnClickListener {
                ++page
                request()

            }
            btnOk.setOnClickListener {
                page = 1
                adapter.list.clear()
                request()
            }
        }
    }

    private fun ActivityMainBinding.request() {
        RetrofitService().api.searchImage(edKeyWord.text.toString(), page = page)
            .enqueue(object : retrofit2.Callback<PixabayModel> {
                override fun onResponse(
                    call: Call<PixabayModel>,
                    response: Response<PixabayModel>
                ) {
                    if (response.isSuccessful) {
                        adapter.list.addAll(response.body()?.hits!!)
                        recyclerView.adapter = adapter

                    }
                }

                override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ,${t.message},")
                }
            })
    }
}


