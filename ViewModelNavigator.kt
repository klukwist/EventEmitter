import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/*
 * By Alexey Che on 2019/11/11
 */

open class NavigationEvent(var isHandled: Boolean = false) {
    companion object {
        fun createObserver(handlerBlock: (NavigationEvent) -> Unit) =
            Observer<NavigationEvent> {
                if (!it.isHandled) it.apply(handlerBlock)
                it.isHandled = true
            }
    }
}

/** 
 * emitter - объект, на который подписываются фрагменты и активити
 * */
class ViewModelNavigator {
    val emitter = MutableLiveData<NavigationEvent>()

    fun newEvent(event: NavigationEvent) {
        if (emitter.hasActiveObservers()) emitter.value = event
        else emitter.value = null
    }
}
