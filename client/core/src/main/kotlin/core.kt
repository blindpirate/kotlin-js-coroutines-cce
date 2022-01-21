import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.dom.appendText

fun main() {
    window.asDynamic().api = GameImpl()
    document.body?.appendText("Start loading dynamic module...")
    window.fetch("/dynamic-loaded-module.js").then {
        it.text().then {
            eval(it)
        }
        document.body?.appendText("Loading dynamic module done.")
    }
}

class GameImpl : GameApi {
    override fun runSuspend(fn: suspend () -> Unit) {
        GlobalScope.launch {
            fn()
        }
    }
}
