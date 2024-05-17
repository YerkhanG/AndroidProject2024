package com.example.androidproject.views.creators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidproject.api.ApiClient
import com.example.androidproject.databinding.FragmentMainBinding
import com.example.androidproject.model.Creator
import com.example.androidproject.model.Creators
import com.example.androidproject.model.CreatorsResponse
import com.example.androidproject.views.creators.service.CreatorsListAdapter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreatorsFragment : Fragment() {
  private var _binding: FragmentMainBinding? = null
  private val binding get() = _binding!!

  private val client = ApiClient.instance
  private val adapter: CreatorsListAdapter by lazy {
    CreatorsListAdapter()
  }
  private var originalCreators: ArrayList<Creator> = ArrayList()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentMainBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupAdapter()
    getCreators()
  }

  override fun onDestroy() {
    super.onDestroy()

    _binding = null
  }

  private fun setupAdapter() {
    with(binding) {
      title.text = "Creators"
      characterList.adapter = adapter
    }
  }

  private fun getCreators() {
    binding.loadingProgressBar.visibility = View.VISIBLE

    val response = client.getCreators()
    response.enqueue(object : Callback<CreatorsResponse> {
      override fun onResponse(
        call: Call<CreatorsResponse>,
        response: Response<CreatorsResponse>
      ) {
        binding.loadingProgressBar.visibility = View.GONE
        val responseBody = response.body()

        if (responseBody != null && responseBody.data.results.isNotEmpty()) {
          val characters = responseBody.data.results

          originalCreators.addAll(characters)
          adapter.submitList(characters)
        }
      }

      override fun onFailure(call: Call<CreatorsResponse>, t: Throwable) {
        binding.loadingProgressBar.visibility = View.GONE
        println("ERROR HttpResponse: ${t.message}")
      }
    })
  }
}
