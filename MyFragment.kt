class MyFragment : Fragment() {
    private val navigationEventsObserver = NavigationEvent.createObserver { event ->
            when (event) {
                is PromoNavigation.ShowCategoriesList -> promoViewModel.showCategoriesList()
                is PromoNavigation.PlayVideo -> videoPlayerView.loadUrl(event.url)
                is PromoNavigation.OpenProduct -> openProduct(event.productId, event.otherInfo)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            myViewModel.navigator.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
        }
}
