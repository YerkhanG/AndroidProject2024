package com.example.androidproject.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidproject.api.ApiClient
import com.example.androidproject.databinding.FragmentMainBinding
import com.example.androidproject.model.Character
import com.example.androidproject.model.CharacterResponse
import com.example.androidproject.views.home.service.CharacterAdapter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val client = ApiClient.instance
    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter()
    }
    private var originalCharacters: ArrayList<Character> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        getCharacters()
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

    private fun setupAdapter() {
        with (binding) {
            title.text = "Characters"
            characterList.adapter = adapter
        }
    }

    private fun getCharacters() {
        binding.loadingProgressBar.visibility = View.VISIBLE

        val response = client.getCharacters()
        response.enqueue(object: Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                binding.loadingProgressBar.visibility = View.GONE
                val responseBody = response.body()

                if (responseBody != null && responseBody.data.results.isNotEmpty()) {
                    val characters = responseBody.data.results

                    originalCharacters.addAll(characters)
                    adapter.submitList(characters)
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                binding.loadingProgressBar.visibility = View.GONE
                println("ERROR HttpResponse: ${t.message}")
            }
        })
    }
}