interface GameApi {
    fun runSuspend(fn: suspend () -> Unit)
}
