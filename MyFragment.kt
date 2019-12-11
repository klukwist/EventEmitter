class MyFragment : Fragment() {
    private val navigationEventsObserver = Events.EventObserver { event ->
            when (event) {
                is MyFragmentNavigation.ShowCategoryList -> ShowCategoryList()
                is MyFragmentNavigation.PlayVideo -> videoPlayerView.loadUrl(event.url)
                is MyFragmentNavigation.OpenProduct -> openProduct(id = event.productId, name = event.otherInfo)
                is MyFragmentNavigation.ShowNetworkError -> showNetworkErrorAlert()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            //Один обзервер на несколько вьюмоделей в рамках одного фрагмента
            myViewModel.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
            myViewModelSecond.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
            myViewModelThird.emitter.observe(viewLifecycleOwner, navigationEventsObserver)
        }
    
    private fun ShowCategoryList(){
        ...
    }
    
    private fun openProduct(id: String, name: String){
        ...
    }
    
    private fun showNetworkErrorAlert(){
        ...
    }
}
