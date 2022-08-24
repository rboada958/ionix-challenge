package com.app.androidev.ui.home

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.app.androidev.R
import com.app.androidev.app.model.MovieItem
import com.app.androidev.databinding.FragmentMovieBinding
import com.app.androidev.ui.home.adapter.MovieAdapter
import com.app.androidev.ui.home.mvvm.MovieViewModel
import com.app.androidev.utils.base.gone
import com.app.androidev.utils.base.visible
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MovieFragment : Fragment(), MovieAdapter.OnMovieClickListener {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<MovieViewModel>()
    private val adapter by lazy {
        MovieAdapter(mutableListOf(), this)
    }

    private lateinit var result: List<MovieItem?>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermissions()
        viewModel.getMovies()

        binding.recyclerView.adapter = adapter

        viewModel.movieUiState.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { uiState ->
                when (uiState) {
                    is MovieViewModel.MovieUiState.ShowLoading -> {
                        binding.progress.visible()
                    }
                    is MovieViewModel.MovieUiState.Error -> {
                        binding.progress.gone()
                        Toast.makeText(requireContext(), uiState.msg, Toast.LENGTH_SHORT).show()
                    }
                    is MovieViewModel.MovieUiState.Success -> {
                        this@MovieFragment.result = uiState.result!!
                        binding.progress.gone()
                        adapter.addItems(result)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMovieClicked(item: MovieItem) {
        findNavController().navigate(R.id.movieDetailsFragment, bundleOf("movie" to item))
    }

    private var resultPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            var isGrantAll = false
            permissions.entries.forEach {
                val permissionName = it.key
                isGrantAll = it.value
            }
        }

    private fun requestPermissions() {
        resultPermissions.launch(
            arrayOf(
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS
            )
        )
    }
}