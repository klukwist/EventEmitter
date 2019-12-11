class MyFragment : Fragment() {
    private val navigationEventsObserver = Events.EventObserver { event ->
            when (event) {
                is MyFragmentNavigation.ShowCategoryList -> ShowCategoryList()
                is MyFragmentNavigation.PlayVideo -> videoPlayerView.loadUrl(event.url)
                is MyFragmentNavigation.OpenProduct -> openProduct(id = event.productId, name = event.otherInfo)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            myViewModel.navigator.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
            myViewModelSecond.navigator.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
            myViewModelThird.navigator.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
        }
    
    private fun ShowCategoryList(){
        ...
    }
    
    private fun openProduct(id: String, name: String){
        ...
    }
}
