# Reproducer for Kotlin JS class loading issue

Steps to reproduce:

- Run `./gradlew server:bootRun`.
- Open http://localhost:8080/
- Click `Run core showModal` buttons, modals are displayed without issues.
- Click `Load dynamic module`. This will load another module dynamically and add two more buttons to DOM.
- Click `Run dynamic module showModal('title', 'content')` button, no issue.
- Click `Run dynamic module showModal { }`, error:

```
1. You might have mismatching versions of React and the renderer (such as React DOM)
2. You might be breaking the Rules of Hooks
3. You might have more than one copy of React in the same app
See https://reactjs.org/link/invalid-hook-call for tips about how to debug and fix this problem.
    at resolveDispatcher (react.development.js?cfe6:1476)
    at useContext (react.development.js?cfe6:1484)
    at useBootstrapPrefix (ThemeProvider.js?88f4:19)
    at eval (ModalHeader.js?21f9:23)
    at renderWithHooks (react-dom.development.js?f6e0:14985)
    at updateForwardRef (react-dom.development.js?f6e0:17044)
    at beginWork (react-dom.development.js?f6e0:19098)
    at HTMLUnknownElement.callCallback (react-dom.development.js?f6e0:3945)
    at Object.invokeGuardedCallbackDev (react-dom.development.js?f6e0:3994)
    at invokeGuardedCallback (react-dom.development.js?f6e0:4056)
```


