import bootstrap.BootstrapModalProps
import react.RElementBuilder

typealias ModalConfiguration = RElementBuilder<BootstrapModalProps>.() -> Unit

interface GameApi {
    fun showModal(title: String, content: String)
    fun showModal(modalConfig: ModalConfiguration?)
}
