package com.app.androidev.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.androidev.databinding.FragmentMovieDetailsBinding
import com.app.androidev.utils.base.loadRect
import com.app.androidev.utils.base.parseDate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<MovieDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showMovieDetails()

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    private fun showMovieDetails() {
        binding.fullTitle.text = args.movie.fullTitle
        binding.avatar.loadRect(args.movie.image)
        binding.title.text = args.movie.title
        binding.date.text = args.movie.releaseState
        binding.stars.text = args.movie.stars
        binding.genres.text = args.movie.genres
        binding.rating.text = args.movie.imDbRating
        binding.description.text = args.movie.plot
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}