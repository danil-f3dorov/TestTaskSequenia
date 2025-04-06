package com.example.testtasksequenia.fragment.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.testtasksequenia.R
import com.example.testtasksequenia.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmCatalogFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel(
        ownerProducer = { requireActivity() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                FilmCatalogScreen(viewModel) {
                    findNavController().navigate(R.id.filmDetailsFragment)
                }
            }
        }
    }

}