package com.example.androidproject.views.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidproject.api.ApiClient
import com.example.androidproject.databinding.FragmentComicsBinding
import com.example.androidproject.model.Comics
import com.example.androidproject.model.ComicsResponse
import com.example.androidproject.views.comics.service.ComicsListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComicsFragment : Fragment() {


    private val client = ApiClient.instance
    private val adapter: ComicsListAdapter by lazy {
        ComicsListAdapter()
    }
    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.comicsList.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
        val response = client.getComics()
        binding.loadingProgressBar.visibility = View.VISIBLE
        response.enqueue(object : Callback<ComicsResponse> {
            override fun onResponse(
                call: Call<ComicsResponse>,
                response: Response<ComicsResponse>
            ) {
                binding.loadingProgressBar.visibility = View.GONE
                val responseBody = response.body()
                println(responseBody)
                if (responseBody != null && responseBody.data.results.isNotEmpty()) {
                    adapter.submitList(responseBody.data.results)
                }
            }

            override fun onFailure(call: Call<ComicsResponse>, t: Throwable) {
                binding.loadingProgressBar.visibility = View.GONE
                println("ERROR HttpResponse: ${t.message}")
            }
        })
    }
}