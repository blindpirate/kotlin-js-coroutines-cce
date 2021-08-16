@file:JsModule("react-bootstrap/Modal")
@file:JsNonModule

package bootstrap

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapModal: RClass<BootstrapModalProps>

// https://react-bootstrap.github.io/components/modal/#modal-props
external interface BootstrapModalProps : RProps {
    var size: String
    var className: String
    var centered: Boolean
    var ariaLabelledby: Any
    var show: Boolean
    var onHide: Any
    var onExit: Any
    var onExited: Any
    var onExiting: Any
    var onShow: Any
    var animation: Boolean
}
