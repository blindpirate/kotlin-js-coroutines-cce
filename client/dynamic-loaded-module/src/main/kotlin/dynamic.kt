import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.dom.appendText

fun main() {
    val gameApi = window.asDynamic().api.unsafeCast<GameApi>()
    gameApi.runSuspend {
        document.body?.appendText("Suspend function starts...")
        delay(1000)
        document.body?.appendText("Suspend function ends...")
    }
}
