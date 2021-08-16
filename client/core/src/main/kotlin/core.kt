import bootstrap.BootstrapModal
import bootstrap.BootstrapModalBody
import bootstrap.BootstrapModalHeader
import bootstrap.BootstrapModalTitle
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import org.w3c.dom.CustomEvent
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.br
import react.dom.button
import react.dom.p
import react.dom.render
import react.setState

fun main() {
    window.asDynamic().api = GameImpl()
    render(document.getElementById("app")) {
        child(IndexPage::class) {
        }
    }
}

interface IndexPageState : RState {
    var modalConfig: ModalConfiguration?
}

class IndexPage : RComponent<RProps, IndexPageState>() {
    val gameApi = window.asDynamic().api.unsafeCast<GameApi>()
    override fun RBuilder.render() {
        button {
            +"Load dynamic module"
            attrs.onClickFunction = {
                window.fetch("/dynamic-loaded-module.js").then {
                    it.text().then {
                        eval(it)
                    }
                }
            }
        }
        br { }
        button {
            +"Run core showModal('title', 'content')"
            attrs.onClickFunction = {
                gameApi.showModal("title", "content")
            }
        }
        button {
            +"Run dynamic module showModal { }"
            attrs.onClickFunction = {
                window.asDynamic().api.unsafeCast<GameApi>().showModal {
                    attrs.show = true
                    attrs.size = "lg"
                    attrs.animation = false
                    attrs.centered = true
                    BootstrapModalHeader {
                        attrs.closeButton = true
                        attrs.onHide = {
                            gameApi.showModal(null)
                        }
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

        br { }
        if (state.modalConfig != undefined) {
            BootstrapModal(state.modalConfig!!)
        }
    }

    override fun componentDidMount() {
        window.addEventListener("showModal", this::onShowModal)
    }

    override fun componentWillUnmount() {
        window.removeEventListener("showModal", this::onShowModal)
    }

    private fun onShowModal(event: Event) {
        setState {
            val detail = (event as CustomEvent).detail
            modalConfig = if (detail == undefined) {
                null
            } else {
                (event.detail as ModalConfiguration /* = react.RElementBuilder<bootstrap.BootstrapModalProps>.() -> kotlin.Unit */)
            }
        }
    }
}

class GameImpl : GameApi {
    override fun showModal(title: String, content: String) {
        showModal {
            attrs.show = true
            attrs.size = "lg"
            attrs.animation = false
            attrs.onHide = {
                showModal(null)
            }
            attrs.centered = true
            BootstrapModalHeader {
                attrs.closeButton = true
                BootstrapModalTitle {
                    +title
                }
            }

            BootstrapModalBody {
                p {
                    +content
                }
            }
        }
    }

    override fun showModal(modalConfig: ModalConfiguration?) {
        window.dispatchEvent(
            CustomEvent("showModal").apply {
                initCustomEvent("showModal", bubbles = true, cancelable = true, detail = modalConfig)
            }
        )
    }
}
