class MyFragment : Fragment() {
    private val navigationEventsObserver = NavigationEvent.createObserver { event ->
            when (event) {
                is MyFragmentNavigation.ShowCategoriesList -> promoViewModel.showCategoriesList()
                is MyFragmentNavigation.PlayVideo -> videoPlayerView.loadUrl(event.url)
                is MyFragmentNavigation.OpenProduct -> openProduct(event.productId, event.otherInfo)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            myViewModel.navigator.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
        }
}
