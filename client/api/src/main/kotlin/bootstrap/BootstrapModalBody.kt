@file:JsModule("react-bootstrap/ModalBody")
@file:JsNonModule

package bootstrap

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapModalBody: RClass<BootstrapModalBodyProps>

// https://react-bootstrap.github.io/components/badge/
external interface BootstrapModalBodyProps : RProps {
    var className: String
    var `as`: Any
    var bsPrefix: String
}
