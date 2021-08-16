import bootstrap.BootstrapModalBody
import bootstrap.BootstrapModalHeader
import bootstrap.BootstrapModalTitle
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLButtonElement
import react.dom.p

fun main() {
    val gameApi = window.asDynamic().api.unsafeCast<GameApi>()
    val button1 = document.createElement("button").apply {
        this as HTMLButtonElement
        innerText = "Run dynamic module showModal('title', 'content')"
        onclick = {
            gameApi.showModal("title", "content")
        }
    }
    val button2 = document.createElement("button").apply {
        this as HTMLButtonElement
        innerText = "Run dynamic module showModal { }"
        onclick = {
            gameApi.showModal {
                attrs.show = true
                attrs.size = "lg"
                attrs.animation = false
                attrs.centered = true
                attrs.onHide = {
                    gameApi.showModal(null)
                }
                BootstrapModalHeader {
                    attrs.closeButton = true
                    BootstrapModalTitle {
                        +"title"
                    }
                }

                BootstrapModalBody {
                    p {
                        +"content"
                    }
                }
            }
        }
    }
    document.body?.appendChild(button1)
    document.body?.appendChild(button2)
}
