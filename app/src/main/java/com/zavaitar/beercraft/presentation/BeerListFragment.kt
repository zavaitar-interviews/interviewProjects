package com.zavaitar.beercraft.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zavaitar.beercraft.R
import com.zavaitar.beercraft.core.architecture.MviFragment
import com.zavaitar.beercraft.data.Beer
import com.zavaitar.beercraft.databinding.BeerListBinding
import com.zavaitar.beercraft.factory.BeerListFactory
import com.zavaitar.beercraft.mvi.beerList.BeerListEffect
import com.zavaitar.beercraft.mvi.beerList.BeerListIntent
import com.zavaitar.beercraft.mvi.beerList.BeerListState
import com.zavaitar.beercraft.mvi.beerList.BeerListView
import com.zavaitar.beercraft.presentation.adapter.BeerListAdapter
import com.zavaitar.beercraft.presentation.adapter.ItemSelectedListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BeerListFragment : MviFragment<BeerListState, BeerListIntent, BeerListView, BeerListEffect>(),
    BeerListView, ItemSelectedListener {

    @Inject
    lateinit var beerListFactory: BeerListFactory

    private var _binding: BeerListBinding? = null
    private val binding get() = _binding!!

    override val mviViewModel by lazy { beerListFactory.getViewModel() }
    override val mviRenderer by lazy { beerListFactory.getRenderer() }
    override val mviView by lazy { beerListFactory.getView(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BeerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendIntent(BeerListIntent.FetchBeerData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun populateBeerList(beerList: List<Beer>?) {
        binding.beerListRecyclerView.adapter = BeerListAdapter(beerList!!, this)
    }

    override fun showBeerDetailsPage(beer: Beer) {
        findNavController().navigate(R.id.BeerDetailsFragment, Bundle().apply {
            putSerializable(SELECTED_ITEM_KEY, beer)
        })
    }

    override fun loadProgressView() {
        binding.progressbarScreen.visibility = View.VISIBLE
    }

    override fun hideProgressView() {
        binding.progressbarScreen.visibility = View.GONE
    }

    override fun onItemSelected(beer: Beer) {
        sendIntent(BeerListIntent.SelectedBeer(beer))
    }

    private companion object {
        const val SELECTED_ITEM_KEY = "selectedBeer"
    }
}
