class MyFragment : Fragment() {
    private val navigationEventsObserver = Events.EventObserver { event ->
            when (event) {
                is MyFragmentNavigation.ShowCameraPermission -> showCameraPermission()
                is MyFragmentNavigation.PlayVideo -> videoPlayerView.loadUrl(event.url)
                is MyFragmentNavigation.OpenProduct -> openProduct(event.productId, event.otherInfo)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            myViewModel.navigator.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
        }
    
    private fun showCameraPermission(){
        ...
    }
    
    private fun openProduct(id: String, name: String){
        ...
    }
}
