package com.zavaitar.beercraft.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.zavaitar.beercraft.core.architecture.MviFragment
import com.zavaitar.beercraft.data.Beer
import com.zavaitar.beercraft.databinding.BeerDetailsBinding
import com.zavaitar.beercraft.factory.BeerDetailsFactory
import com.zavaitar.beercraft.mvi.beerDetails.BeerDetailsEffect
import com.zavaitar.beercraft.mvi.beerDetails.BeerDetailsIntent
import com.zavaitar.beercraft.mvi.beerDetails.BeerDetailsState
import com.zavaitar.beercraft.mvi.beerDetails.BeerDetailsView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BeerDetailsFragment : MviFragment<BeerDetailsState, BeerDetailsIntent, BeerDetailsView,
        BeerDetailsEffect>(), BeerDetailsView {

    @Inject
    lateinit var beerDetailsFactory: BeerDetailsFactory

    private var _binding: BeerDetailsBinding? = null
    private val binding get() = _binding!!

    override val mviViewModel by lazy { beerDetailsFactory.getViewModel() }
    override val mviRenderer by lazy { beerDetailsFactory.getRenderer() }
    override val mviView by lazy { beerDetailsFactory.getView(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BeerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val beer = arguments?.getSerializable(SELECTED_ITEM_KEY) as Beer
        setUpScreen(beer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setUpScreen(beer: Beer) {
        binding.itemImage.load(beer.imageUrl)
        binding.itemName.text = beer.name
        binding.firstBrewedDateText.text = beer.firstBrewed
        binding.brewersTipsText.text = beer.brewersTips
        binding.additionalInfoText.text = beer.description
    }

    private companion object {
        const val SELECTED_ITEM_KEY = "selectedBeer"
    }
}
