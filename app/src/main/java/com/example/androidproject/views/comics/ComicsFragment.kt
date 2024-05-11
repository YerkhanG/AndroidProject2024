package com.example.androidproject.views.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.R
import com.example.androidproject.api.ApiClient
import com.example.androidproject.databinding.FragmentComicsBinding
import com.example.androidproject.model.Comics
import com.example.androidproject.model.ComicsListState
import com.example.androidproject.model.ComicsResponse
import com.example.androidproject.viewModel.ComicsViewModel
import com.example.androidproject.views.comics.service.ComicsListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

class ComicsFragment : Fragment() {
    private val adapter: ComicsListAdapter by lazy {
        ComicsListAdapter()
    }
    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!

    private val viewModel : ComicsViewModel by lazy {
        ViewModelProvider(
            this,
            ComicsViewModel.Provider(
                service = ApiClient.instance
            )
        )[ComicsViewModel::class.java]
    }

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
        viewModel.fetchComicsList()
        binding.loadingProgressBar.visibility = View.VISIBLE
        viewModel.comicsListState.observe(viewLifecycleOwner) {state ->
            when(state){
                is ComicsListState.Success -> adapter?.submitList(state.items)
                is ComicsListState.Loading -> {
                    with(binding) {
                        loadingProgressBar.isVisible = state.isLoading
                        comicsList.isVisible = !state.isLoading
                    }
                }
                is ComicsListState.Error -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle(R.string.error_title)
                        .setMessage(state.message ?: getString(R.string.error_message))
                        .show()
                }
            }
        }
    }
}